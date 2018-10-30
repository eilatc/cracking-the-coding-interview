package linkedlist;

import java.util.HashSet;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {

        if (head == null) return head;
        HashSet<Integer> set = new HashSet<>();

        LinkedListNode n = head;
        LinkedListNode prev = n;
        while (n.next != null) {

            if (set.contains(n.val)) {
                // Remove Duplicate
                prev.next = n.next;
            } else {
                set.add(n.val);
            }
            prev = n;
            n = n.next;

        }

        return head;

    }
}
