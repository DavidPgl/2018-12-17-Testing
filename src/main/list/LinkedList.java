package list;

class LinkedList implements List {

    private Node first = null;

    @Override
    public void add(String data) {
        this.first = new Node(data, this.first);
    }

    @Override
    public boolean delete(String data) {
        Node currentNode = getFirst();
        Node lastNode;
        try {
	        if(currentNode.data().equals(data)) {
	            first = currentNode.next();
	            return true;
	        }
        } catch (NullPointerException e) {
        	return false;
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
    public void reverse () throws LinkedListException {
    	Node tempFirst;
    	try {
    		tempFirst = new Node(this.first.data(), null);
    	} catch (NullPointerException e) {
    		throw new LinkedListException("Cannot reverse an empty list.");
    	}
        Node currentNode = this.first;
        while ((currentNode = currentNode.next()) != null){
            tempFirst = new Node(currentNode.data(),tempFirst);
        }
        this.first = tempFirst;
    }


}
