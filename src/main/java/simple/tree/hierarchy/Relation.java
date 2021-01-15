package simple.tree.hierarchy;

public class Relation {

    private final Entity parent;
    private final Entity child;

    public Relation(Entity parent, Entity child) {
        this.parent = parent;
        this.child = child;
    }

    public Entity getParent() {
        return parent;
    }

    public Entity getChild() {
        return child;
    }

}
