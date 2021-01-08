package simple.list.linked;

class CustomLinkedList {
    private final String value;
    private CustomLinkedList next;

    public CustomLinkedList(String value, CustomLinkedList next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public CustomLinkedList getNext() {
        return next;
    }

    public void setNext(CustomLinkedList next) {
        this.next = next;
    }
}
