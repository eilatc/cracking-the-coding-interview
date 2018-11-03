package linkedlist;

/**
 * Implement an algorithm to delete a node in the
 * middle(i.e., any node but the first and last node, not necessarily the exact middle)
 * of a singly linked list, given only access to that node.
 */
// 5 -> 6 -> 7 -> null
class _02_03_DeleteMiddleNode {

    boolean deleteMiddleNode(LinkedListNode node) {

        if (node == null || node.next == null) return false;
        LinkedListNode prev = node;
        while (node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
        return true;
    }
}
