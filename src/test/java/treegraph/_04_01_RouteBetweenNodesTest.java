package treegraph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class _04_01_RouteBetweenNodesTest {


    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    Node five = new Node(5);

    @Test
    public void withTwoVertexModified() {
        Graph digraph = new Graph();
        digraph.addNode(one);
        digraph.addNode(two);
        one.addAdjacent(two);
        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes();
        assertTrue(routeBetweenNodes.search(digraph, one, two));
        assertFalse(routeBetweenNodes.search(digraph, two, one));
    }

    @Test
    public void twoSeparateGraphs() {
        Graph digraph = new Graph();
        digraph.addNode(one);
        digraph.addNode(two);
        digraph.addNode(three);
        digraph.addNode(four);
        digraph.addNode(five);

        // 1 -> 2      3->4->5
        one.addAdjacent(two);

        three.addAdjacent(four);
        four.addAdjacent(five);

        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes();
        assertTrue(routeBetweenNodes.search(digraph, three, five));
        assertFalse(routeBetweenNodes.search(digraph, one, five));

        // Link the two graphs
        two.addAdjacent(four);
        assertTrue(routeBetweenNodes.search(digraph, one, five));
    }

    @Test
    public void withTwoVertex() {
        Digraph digraph = new Digraph(2);
        digraph.addEdge(0, 1);
        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes(digraph);
        assertTrue(routeBetweenNodes.hasRoute(0, 1));
        assertFalse(routeBetweenNodes.hasRoute(1, 0));
    }

    @Test
    public void withMoreVertex() {
        Digraph digraph = new Digraph(5);
        digraph.addEdge(0, 1);
        digraph.addEdge(0, 2);
        digraph.addEdge(2, 3);
        digraph.addEdge(2, 4);
        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes(digraph);
        assertTrue(routeBetweenNodes.hasRoute(0, 4));
        assertFalse(routeBetweenNodes.hasRoute(1, 4));
        assertTrue(routeBetweenNodes.hasRoute(0, 0));
    }

    @Test
    public void withCycle() {
        Digraph digraph = new Digraph(3);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 0);
        _04_01_RouteBetweenNodes routeBetweenNodes = new _04_01_RouteBetweenNodes(digraph);
        assertTrue(routeBetweenNodes.hasRoute(0, 1));
        assertTrue(routeBetweenNodes.hasRoute(0, 2));
    }
}