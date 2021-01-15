package simple.tree.binary;

import java.util.ArrayDeque;

public class BinaryTreeReversal {

    private BinaryTreeReversal() {}

    public static void reversal() {
        BinaryTreeNode root = setupBinaryTree();

        BinaryTreePrinter.printTree(root, "Before");
        reverse(root);
        BinaryTreePrinter.printTree(root, "After");
    }

    private static BinaryTreeNode setupBinaryTree() {
        BinaryTreeNode nine = new BinaryTreeNode(9, null, null);
        BinaryTreeNode eight = new BinaryTreeNode(8, null, null);
        BinaryTreeNode seven = new BinaryTreeNode(7, null, null);
        BinaryTreeNode six = new BinaryTreeNode(6, null, null);
        BinaryTreeNode five = new BinaryTreeNode(5, null, null);
        BinaryTreeNode four = new BinaryTreeNode(4, eight, nine);
        BinaryTreeNode three = new BinaryTreeNode(3, six, seven);
        BinaryTreeNode two = new BinaryTreeNode(2, four, five);

        return new BinaryTreeNode(1, two, three);
    }

    private static void reverse(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        reverse(queue);
    }

    // Breadth-first
    private static void reverse(ArrayDeque<BinaryTreeNode> queue) {
        if (queue.isEmpty()) {
            return;
        }

        BinaryTreeNode current = queue.getFirst();

        reverseLeaves(current);

        if (current.getLeft() != null) {
            queue.add(current.getLeft());
        }

        if (current.getRight() != null) {
            queue.add(current.getRight());
        }

        queue.removeFirst();

        reverse(queue);
    }
    private static void reverseLeaves(BinaryTreeNode current) {
        BinaryTreeNode oldLeft = current.getLeft();
        current.setLeft(current.getRight());
        current.setRight(oldLeft);
    }

}
