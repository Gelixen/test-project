package simple.tree.hierarchy;

enum Entity {

    ANIMAL("animal"),
    LIFE_FORM("life form"),
    BIRD("bird"),
    CAT("cat"),
    MAMMAL("mammal"),
    FISH("fish"),
    LION("lion");

    private final String value;

    Entity(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
