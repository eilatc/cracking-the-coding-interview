package treegraph;

/**
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */
class _04_02_MinimalTree {

    BinaryTreeNode buildMinimalTree(int[] vals) {
        return buildMinimalTree(0, vals.length - 1, vals);
    }

    BinaryTreeNode buildMinimalTree(int start, int end, int[] vals) {
        if (end < start) return null;

        int midpoint = (end + start) / 2;
        BinaryTreeNode head = new BinaryTreeNode(vals[midpoint]);
        head.left = buildMinimalTree(start, midpoint - 1, vals);
        head.right = buildMinimalTree(midpoint + 1, end, vals);
        return head;
    }


}
