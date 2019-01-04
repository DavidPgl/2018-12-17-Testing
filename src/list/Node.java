package list;

class Node {
    private String data;
    private Node next;

    Node(String data, Node next) {
        this.data = data;
        this.next = next;
    }

    String data() {
        return data;
    }

    Node next() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
