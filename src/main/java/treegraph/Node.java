package treegraph;

import java.util.HashSet;

public class Node {

    HashSet<Node> adjacent = new HashSet<>();;
    public int val;

    Node (int val) {
        this.val = val;
    }

    public HashSet<Node> getAdjacent() {
        return adjacent;
    }
    public boolean addAdjacent(Node n) {return adjacent.add(n);}
    public int getValue(){return val;}
}
