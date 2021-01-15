package simple.list.linked;

public class LinkedListReversal {

    private LinkedListReversal() {}

    public static void reversal() {
        CustomLinkedList head = setupLinkedList();
        LinkedListPrinter.print(head);

        CustomLinkedList newHead = reverseLinkedList(head);
        LinkedListPrinter.print(newHead);

    }

    private static CustomLinkedList setupLinkedList() {
        CustomLinkedList e = new CustomLinkedList("e", null);
        CustomLinkedList d = new CustomLinkedList("d", e);
        CustomLinkedList c = new CustomLinkedList("c", d);
        CustomLinkedList b = new CustomLinkedList("b", c);

        return new CustomLinkedList("a", b);
    }

    private static CustomLinkedList reverseLinkedList(CustomLinkedList head) {
        CustomLinkedList current = head;
        CustomLinkedList last = null;

        while (current != null) {
            CustomLinkedList next = current.getNext();
            current.setNext(last);
            last = current;
            current = next;
        }

        return last;
    }

}