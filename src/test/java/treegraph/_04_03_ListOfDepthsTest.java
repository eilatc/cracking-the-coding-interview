package treegraph;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class _04_03_ListOfDepthsTest {

    private _04_03_ListOfDepths s = new _04_03_ListOfDepths();

    @Test
    public void withOneElement() {
        List<LinkedList<Integer>> linkedLists = s.create(new BinaryTreeNode(1));
        List<LinkedList<Integer>> results = new ArrayList<>();
        results.add(new LinkedList<>(Collections.singletonList(1)));
        assertEquals(results, linkedLists);
    }

    @Test
    public void withTwoElements() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.left = new BinaryTreeNode(2);
        List<LinkedList<Integer>> linkedLists = s.create(node);
        List<LinkedList<Integer>> results = new ArrayList<>();
        results.add(new LinkedList<>(Collections.singletonList(1)));
        results.add(new LinkedList<>(Collections.singletonList(2)));
        assertEquals(results, linkedLists);
    }

    @Test
    public void withThreeElements() {
        BinaryTreeNode node = new BinaryTreeNode(1);
        node.left = new BinaryTreeNode(2);
        node.right = new BinaryTreeNode(3);
        List<LinkedList<Integer>> linkedLists = s.create(node);
        List<LinkedList<Integer>> results = new ArrayList<>();
        results.add(new LinkedList<>(Collections.singletonList(1)));
        results.add(new LinkedList<>(Arrays.asList(2, 3)));
        assertEquals(results, linkedLists);
    }

    //          4
    //      2       6
    //   1    3  5    7
    @Test
    public void withSevenElements() {
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


        List<LinkedList<Integer>> linkedLists = s.create(n4);
        List<LinkedList<Integer>> results = new ArrayList<>();
        results.add(new LinkedList<>(Collections.singletonList(4)));
        results.add(new LinkedList<>(Arrays.asList(2, 6)));
        results.add(new LinkedList<>(Arrays.asList(1, 3, 5, 7)));
        assertEquals(results, linkedLists);
    }
}