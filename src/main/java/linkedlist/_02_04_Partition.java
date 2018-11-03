package linkedlist;

/**
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
class _02_04_Partition {

    LinkedListNode partition(LinkedListNode head, int x) {

        LinkedListNode leftPart = null;
        LinkedListNode rightPart = null;
        LinkedListNode rightPartHead = null;
        LinkedListNode leftPartHead = null;

        while (head != null) {
            LinkedListNode next = head.next;
            head.next = null;

            if (head.val < x){
                if (leftPart == null) {
                    leftPart = head;
                    leftPartHead = head;
                } else {
                    leftPart.next = head;
                    leftPart = leftPart.next;
                }
            } else {
                if (rightPart == null) {
                    rightPart = head;
                    rightPartHead = head;
                } else {
                    rightPart.next = head;
                    rightPart = rightPart.next;
                }
            }
            head = next;
        }
        if (leftPart != null) {
            leftPart.next = rightPartHead;
        } else {
            leftPartHead = rightPartHead;
        }

        return leftPartHead;
    }
}
