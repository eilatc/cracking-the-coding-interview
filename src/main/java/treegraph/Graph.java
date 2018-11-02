package treegraph;

import java.util.HashSet;

public class Graph {
    private final HashSet<Node> allNodes = new HashSet<>();
    public boolean addNode(Node n) { return allNodes.add(n);}
    public boolean removeNode(Node n) { return allNodes.remove(n);}
    public HashSet<Node> getNodes() { return allNodes; }

}
