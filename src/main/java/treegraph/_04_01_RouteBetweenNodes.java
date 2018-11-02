package treegraph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph, design an algorithm to find out whether
 * there is a route between two nodes.
 */
class _04_01_RouteBetweenNodes {

    private final Digraph digraph;


    _04_01_RouteBetweenNodes() {
        digraph = new Digraph(5);
    }

    _04_01_RouteBetweenNodes(Digraph digraph) {
        this.digraph = digraph;
    }

    boolean hasRoute(int source, int target) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            if (node == target) return true;

            Iterable<Integer> it = digraph.adjacent(node);

            for (Integer i : it){
                queue.offer(i);
            }
        }
        return false;
    }

    boolean search(Graph g, Node start, Node end){
        if (start == end) return true;
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        while (!q.isEmpty()) {
            Node n = q.poll();
            if (n == end) return true;

            for (Node u: n.getAdjacent()) {
                if (!visited.contains(u)) {
                    q.offer(u);
                    visited.add(u);
                }
            }
        }
        return false;
    }

}
