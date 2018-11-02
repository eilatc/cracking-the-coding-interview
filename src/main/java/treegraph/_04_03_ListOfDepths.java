package treegraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class _04_03_ListOfDepths {

    // Given a binary tree, design an algorithm which creates a linked list of all the nodes
    // at each depth (e.g if you have a tree with depth D, you'll have D linked lists.)
    //time o(N) space o(N)
    List<LinkedList<Integer>> create(BinaryTreeNode node) {
        List<LinkedList<Integer>> tree = new ArrayList<>();
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            Queue<BinaryTreeNode> temp = new LinkedList<>();
            LinkedList<Integer> level = new LinkedList<>();
            while (!q.isEmpty()) {
                BinaryTreeNode n = q.poll();
                level.add(n.val);
                if (n.left != null) {
                    temp.offer(n.left);
                }

                if (n.right != null) {
                    temp.offer(n.right);
                }
            }
            tree.add(level);
            q = temp;
        }
        return tree;
    }

}
