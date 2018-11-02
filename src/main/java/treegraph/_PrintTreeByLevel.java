package treegraph;

import java.util.LinkedList;
import java.util.Queue;

public class _PrintTreeByLevel {
    public static void printTreeByLevel(BinaryTreeNode head){
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(head);
        int i = 1;
        while(!q.isEmpty()) {
            Queue<BinaryTreeNode> temp = new LinkedList<>();
            System.out.println("Level " + i + ":");
            while (!q.isEmpty()) {
                BinaryTreeNode n = q.poll();
                System.out.print(n.val + " ");

                if (n.left != null) {
                   temp.offer(n.left);
                }

                if (n.right != null) {
                    temp.offer(n.right);
                }
            }
            System.out.println();
            q = temp;
            i++;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode n1 = new BinaryTreeNode(1);
        BinaryTreeNode n2 = new BinaryTreeNode(2);
        BinaryTreeNode n3 = new BinaryTreeNode(3);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(5);
        BinaryTreeNode n6 = new BinaryTreeNode(6);
        BinaryTreeNode n7 = new BinaryTreeNode(7);

        n4.left = n2;
        n4.right = n6;

        n2.left = n1;
        n2.right = n3;

        n6.left = n5;
        n6.right = n7;

        printTreeByLevel(n4);


    }
}
