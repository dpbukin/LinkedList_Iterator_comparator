package twoLinkedList.laba_1;

public class Node {
    Minion minion;
    Node previous;
    Node next;

    public Node(Minion minion, Node previous, Node next) {
        this.minion = minion;
        this.previous = previous;
        this.next = next;
    }

    public Node(Minion minions) {
        this.minion = minions;
    }
}
