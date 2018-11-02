package treegraph;

/**
 * Implement a function to check if a binary tree is balanced.
 * For the purposes of this question, a balanced tree is defined to be a tree such that
 * the heights of the two subtrees of any node never differ by more than one.
 */
class _04_04_CheckBalanced {

    //time o(N) space o(logN)
    boolean isBalanced(BinaryTreeNode root) {
        return isBalanced(root, 0, 0 ,0);
    }

    boolean isBalanced(BinaryTreeNode root, int max, int prevMax, int level) {

        if (root == null) return true;

        if (root.left == null && root.right == null) {
            if (level > max) {
                prevMax = max;
                max = level;
            }
            return max - prevMax < 2;
        }

        return isBalanced(root.left, max, prevMax, level + 1) &&
                isBalanced(root.right, max, prevMax, level + 1);

    }

//    public static boolean isBalanced(BinaryTreeNode tree) {
//        return isBalancedHelper(tree) != -1;
//    }
//
//    private static int isBalancedHelper(BinaryTreeNode tree) {
//        if (tree == null) {
//            return 0;
//        } else {
//            int heightLeft = isBalancedHelper(tree.left);
//            if (heightLeft == -1) {
//                return -1;
//            }
//            int heightRight = isBalancedHelper(tree.right);
//            if (heightRight == -1) {
//                return -1;
//            }
//            if (Math.abs(heightLeft - heightRight) > 1) {
//                return -1;
//            } else {
//                return Math.max(heightLeft, heightRight) + 1;
//            }
//        }
//    }


}
