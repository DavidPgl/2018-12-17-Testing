package list;

interface List {
    boolean delete(String data);

    void add(String data);

    Node getFirst();

    void reverse() throws LinkedListException;


}
