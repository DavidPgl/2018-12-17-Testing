package list;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
        linkedList.add("3");
        linkedList.add("2");
        linkedList.add("1");
    }

    @Test
    void deleteNode() {
        assertTrue(linkedList.delete("1"));
        assertListShouldBe(linkedList, new String[]{"2", "3"});
    }

    @Test
    void deleteNothing() {
        assertFalse(linkedList.delete("4"));
        assertListShouldBe(linkedList, new String[]{"1", "2", "3"});
    }

    @Test
    void reverseList() {

        linkedList.reverse();
        assertListShouldBe(linkedList, new String[]{"3", "2", "1"});
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