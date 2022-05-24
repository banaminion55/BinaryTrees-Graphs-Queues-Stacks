package Graphs;

import java.util.HashMap;

public class GraphNode<T extends Comparable<T>, E extends Comparable<E>> {

    Vertex<T> v = null;
    HashMap<Vertex<T>, Edge<E>> map = new HashMap();

    public GraphNode(Vertex v) {
        this.v = v;
    }

    public void addEdge(Vertex v, Edge e) {
        map.put(v, e);
    }

    public Vertex<T> getV() {
        return v;
    }

    public void setV(Vertex<T> v) {
        this.v = v;
    }

    public HashMap<Vertex<T>, Edge<E>> getMap() {
        return map;
    }

    public void setMap(HashMap<Vertex<T>, Edge<E>> map) {
        this.map = map;
    }
}
