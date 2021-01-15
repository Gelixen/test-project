package simple.tree.hierarchy;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static simple.tree.hierarchy.Entity.*;

public class HierarchyTreePrinter {

    private HierarchyTreePrinter() {}

    public static void print() {
        List<Relation> hierarchy = setupHierarchy();

        print(hierarchy);
    }

    private static List<Relation> setupHierarchy() {
        List<Relation> input = new ArrayList<>();

        input.add(new Relation(ANIMAL, MAMMAL));
        input.add(new Relation(ANIMAL, BIRD));
        input.add(new Relation(LIFE_FORM, ANIMAL));
        input.add(new Relation(CAT, LION));
        input.add(new Relation(MAMMAL, CAT));
        input.add(new Relation(ANIMAL, FISH));

        return input;
    }

    public static void print(List<Relation> input) {
        Map<Entity, List<Entity>> map = input.stream()
                .collect(Collectors.groupingBy(Relation::getParent, mapping(Relation::getChild, toList())));

        Relation root = findRootRelation(input).orElseThrow(RootNotFoundException::new);

        print(root.getParent(), map, 1);
    }

    private static void print(Entity parent, Map<Entity, List<Entity>> map, int level) {
        List<Entity> children = map.getOrDefault(parent, List.of());

        printNode(parent, level);

        children.forEach(child -> print(child, map, level + 1));
    }

    private static void printNode(Entity nodeName, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(nodeName.getValue());
    }

    private static Optional<Relation> findRootRelation(List<Relation> input) {
        List<Entity> children = input.stream().map(Relation::getChild).collect(toList());

        Predicate<Relation> relationContainsPredicate = relation -> children.contains(relation.getParent());

        return input.stream()
                .filter(relationContainsPredicate.negate())
                .findFirst();
    }

}
