package Graphs;

import java.util.ArrayList;

public class Pathfinder<T extends Comparable<T>, E extends Comparable<E>> {

    private ArrayList<Vertex<T>> path = new ArrayList<>();
    private MapGraph<T,E> graph;

    private Pathfinder(MapGraph<T, E> graph) {
        this.graph = graph;
    }

    public ArrayList<Vertex<T>> depthFirstSearch(T v1) {


    }


    public ArrayList<Vertex<T>> getPath() {
        return path;
    }

    public void setPath(ArrayList<Vertex<T>> path) {
        this.path = path;
    }
}
