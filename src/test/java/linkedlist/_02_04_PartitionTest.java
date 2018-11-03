package linkedlist;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class _02_04_PartitionTest {

    private _02_04_Partition s = new _02_04_Partition();

    @Test
    public void withEmptyList() {
        assertEquals(LinkedListNode.empty(), s.partition(LinkedListNode.empty(), 8));
    }

    @Test
    public void withSortedList() {
        assertEquals(LinkedListNode.of(1, 2, 3), s.partition(LinkedListNode.of(1, 2, 3), 2));
    }

    @Test
    public void withSortedList_AndOutOfListX() {
        assertEquals(LinkedListNode.of(1, 2, 3), s.partition(LinkedListNode.of(1, 2, 3), 4));
    }

    @Test
    public void withSortedList_AndOutOfListX_Smaller() {
        assertEquals(LinkedListNode.of(1, 2, 3), s.partition(LinkedListNode.of(1, 2, 3), 0));
    }

    @Test
    public void withUnSortedList() {
        checkPartition(s.partition(LinkedListNode.of(14, 13, 12, 15, 21, 7,1, 2, 4, 2),5), 7);
    }

    @Test
    public void withUnSortedList_AndOutOfScopeX() {
        checkPartition(s.partition(LinkedListNode.of(3, 4, 2, 6, 1),5), 5);
    }

    private void checkPartition(LinkedListNode head, int partitionValue) {
        boolean isPartitioned = true;
        boolean lessThenMode = true;
        // Checking leftPart is less then partitionValue and rightPart is equal or greater
        while (head != null) {
            if (lessThenMode && head.val < partitionValue) {
                if (head.next.val >= partitionValue) {
                    lessThenMode = false;
                }
                head = head.next;
            } else if (head.val >= partitionValue && !lessThenMode) {
                head = head.next;
            } else {
                isPartitioned = false;
                break;
            }

        }
        assertTrue(isPartitioned);
    }

}