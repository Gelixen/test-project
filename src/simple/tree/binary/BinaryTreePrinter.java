package simple.tree.binary;

public class BinaryTreePrinter {

    private BinaryTreePrinter() {}

    static void printTree(BinaryTreeNode root, String title) {
        System.out.println("======================");
        System.out.println(title);
        System.out.println("----------------------");

        printTree(root, 0);
    }

    // Depth-first
    private static void printTree(BinaryTreeNode head, int level) {
        if (head == null) {
            return;
        }

        for (int i = 0; i < level; i++) {
            System.out.print("\t");
        }

        System.out.println(head.getValue());

        printTree(head.getLeft(), level + 1);
        printTree(head.getRight(), level + 1);
    }
}
