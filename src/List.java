public interface List {
    void delete();

    int size();

    void add();

    Node getLast();

    void reverse();
    /*------------------------------------------------------------------------------------------------------------*/
    //Maybes

    void delete(int index);

    void add(int index);

    Node getFirst();
    Node get(int index);

}
