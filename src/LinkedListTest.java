import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;
    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    void deleteNode() {
        linkedList.add(new Node());
        linkedList.delete();
        assertEquals(0, linkedList.size());
    }

    @Test
    void deleteNothing() {
        linkedList.delete();
        assertEquals(0, linkedList.size());
    }

    @Test
    void addNode() {
        linkedList.add(new Node());
        assertEquals(1, linkedList.size());
    }

    @Test
    void getNode() {
        Node node = new Node();
        linkedList.add(node);
        assertEquals(node, linkedList.getLast());
    }

    @Test
    void getNothing() {
        linkedList = new LinkedList();
        assertEquals(null, linkedList.getLast());
    }

    @Test
    void reverseList() {
        linkedList = new LinkedList();
        Node first = new Node();
        Node middle = new Node();
        Node last = new Node();
        linkedList.add(first);
        linkedList.add(middle);
        linkedList.add(last);

        linkedList.reverse();
        assertEquals(first, linkedList.getLast());
        linkedList.delete();
        assertEquals(middle, linkedList.getLast());
        linkedList.delete();
        assertEquals(last, linkedList.getLast());
        linkedList.delete();
    }

}