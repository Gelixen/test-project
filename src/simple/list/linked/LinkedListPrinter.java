package simple.list.linked;

public class LinkedListPrinter {

    private LinkedListPrinter() {}

    static void print(CustomLinkedList head) {
        CustomLinkedList curr = head;

        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }
        System.out.println("----------------");
    }
}
