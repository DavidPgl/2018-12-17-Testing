package list;

class LinkedList implements List {

    private Node first = null;

    @Override
    public void add(String data) {
        this.first = new Node(data, this.first);
    }

    @Override
    public boolean delete(String data) {
        if (getFirst() == null) return false;
        Node currentNode = getFirst();
        Node lastNode;

        if (currentNode.data().equals(data)) {
            first = currentNode.next();
            return true;
        }
        lastNode = currentNode;
        while ((currentNode = currentNode.next()) != null) {
            if (currentNode.data().equals(data)) {
                lastNode.setNext(currentNode.next());
                return true;
            }
            lastNode = currentNode;
        }
        return false;
    }

    @Override
    public Node getFirst() {
        return this.first;
    }

    @Override
    public void reverse() {
        Node tempFirst;
        if (getFirst() == null) return;
        tempFirst = new Node(this.first.data(), null);

        Node currentNode = this.first;
        while ((currentNode = currentNode.next()) != null) {
            tempFirst = new Node(currentNode.data(), tempFirst);
        }
        this.first = tempFirst;
    }


}
