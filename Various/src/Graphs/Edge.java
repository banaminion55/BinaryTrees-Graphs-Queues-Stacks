package Graphs;

public class Edge<E extends Comparable<E>> {
    E data;
    public Edge(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "data=" + data +
                '}';
    }
}
