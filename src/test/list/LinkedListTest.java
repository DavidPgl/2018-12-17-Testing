package list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    void setUp() {
        linkedList = new LinkedList();
        linkedList.add("3");
        linkedList.add("2");
        linkedList.add("1");
    }
    
    @Test
    void emptyList () {
    	linkedList = new LinkedList();
    	assertListShouldBe(linkedList, new String[]{});
    }
    
    @Test
    void addNode() {
    	linkedList = new LinkedList();
    	linkedList.add("3");
    	assertListShouldBe(linkedList, new String[]{"3"});
    	linkedList.add("2");
    	assertListShouldBe(linkedList, new String[]{"2", "3"});
    }

    @Test
    void deleteNode() {
    	setUp();
        assertTrue(linkedList.delete("1"));
        assertListShouldBe(linkedList, new String[]{"2", "3"});
    }

    @Test
    void deleteNothing() {
    	setUp();
        assertFalse(linkedList.delete("4"));
        assertListShouldBe(linkedList, new String[]{"1", "2", "3"});
    }
    
    @Test
    void deleteFromEmpty() {
    	linkedList = new LinkedList();
        assertFalse(linkedList.delete("1"));
        assertListShouldBe(linkedList, new String[]{});
    }

    @Test
    void reverseList() throws LinkedListException {
    	setUp();
        linkedList.reverse();
        assertListShouldBe(linkedList, new String[]{"3", "2", "1"});
    }
    
    @Test
    void reverseEmpty() {
    	linkedList = new LinkedList();
        assertThrows(LinkedListException.class, () -> { linkedList.reverse(); });
    }

    /*------------------------------------------------------------------------------------------------------------*/
    //https://github.com/htw-imi-info3/lab-04-testing/blob/master/b_test_driven/java/just_code/assert.java
    private void assertListShouldBe(List list, String[] expected) {
        Node currentNode = list.getFirst();
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], currentNode.data(), "element #" + i + " ");
            currentNode = currentNode.next();
        }
        assertNull(currentNode, "should be after last element");
    }
}