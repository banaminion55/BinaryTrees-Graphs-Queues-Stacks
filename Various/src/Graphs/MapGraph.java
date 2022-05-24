package Graphs;

/*
numVertices( ) DONE
Returns the number of vertices of the graph.
vertices( ) DONE
Returns an iteration of all the vertices of the graph.
numEdges( ) DONE
Returns the number of edges of the graph.
edges( ) DONE
Returns an iteration of all the edges of the graph.
getEdge(u, v) DONE
Returns the edge from vertex u to vertex v, if one exists; otherwise return null. For an undirected graph, there is no difference between getEdge(u, v) and getEdge(v, u).
endVertices(e) DONE
Returns an array containing the two endpoint vertices of edge e. If the graph is directed, the first vertex is the origin and the second is the destination.
opposite(v, e)
For edge e incident to vertex v, returns the other vertex of the edge; an error occurs if e is not incident to v.
outDegree(v)
Returns the number of outgoing edges from vertex v.
inDegree(v)
Returns the number of incoming edges to vertex v. For an undirected graph, this returns the same value as does outDegree(v).
outgoingEdges(v)
Returns an iteration of all outgoing edges from vertex v.
incomingEdges(v)
Returns an iteration of all incoming edges to vertex v. For an undirected graph, this returns the same collection as does outgoingEdges(v).
insertVertex(x) DONE
Creates and returns a new Vertex storing element x.
insertEdge(u, v, x) DONE
Creates and returns a new Edge from vertex u to vertex v, storing element x; an error occurs if there already exists an edge from u to v.
removeVertex(v)
Removes vertex v and all its incident edges from the graph.
removeEdge(e)
Removes edge e from the graph.

//Good for seeing if data exists in graph
 for(GraphNode n: graph) {
            if(n.getV().getData().compareTo(data) == 0) {
                n.addEdge(u, e);
            }
        }
Assuming that nodes can't have the same data
 */

import java.awt.font.GraphicAttribute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MapGraph<T extends Comparable<T>, E extends Comparable<E>> {

    //How does T and E work??
    LinkedList<GraphNode<T, E>> graph = new LinkedList();
    int numEdges = 0;

    /*public Vertex<T> findVertexNode(T v1) {
        for(GraphNode<T,E> g: graph) {
            if(g.getV().getData().compareTo(v1) == 0) {
                return g.getV();
            }
        }
    }*/

    public GraphNode<T, E> findNode(T data) {
        for(GraphNode n: graph) {
            if (n.getV().getData().compareTo(data) == 0) {
                return n;
            }
        }
        return null;
    }

    public void addVertex(T data) {
        GraphNode<T, E> node = new GraphNode(new Vertex(data));
        graph.add(node);
    }

    /*pass in vertex v??
    public void addEdge(Vertex v, Vertex u, Edge e) {
        for(GraphNode n: graph) {
            if(n.getV() == v) {
                n.addEdge(u, e);
            }
        }
    }*/

    //which addEdge method makes more sense??
    /*public void insertEdge(T data, Vertex<T> u, Edge<E> e) {
        GraphNode<T, E> g = null;
        for(GraphNode n: graph) {
            if(n.getV().getData().compareTo(data) == 0) {
                g = n;
                n.addEdge(u, e);
                numEdges++;
            }
        }
        GraphNode<T, E> node = findNode(u.getData());
        node.addEdge(g.getV(),e);
    }*/

    public void insertEdge(T v1, T v2, E e1) {
        GraphNode<T,E> node1 = findNode(v1);
        GraphNode<T,E> node2 = findNode(v2);
        if(node2 == null || node1 == null) {
            System.out.println("Error: Nodes do not exist!");
        }
        else {
            numEdges++;
            Edge<E> e = new Edge(e1);
            Vertex<T> vObj1 = node1.getV();
            Vertex<T> vObj2 = node2.getV();
            node1.addEdge(vObj2,e);
            node2.addEdge(vObj1,e);
        }
    }

    public int numVertices() {
        int n = 0;
        for(GraphNode<T, E> g: graph) {
            n++;
        }
        return n;
    }

    public int numEdges() {
        return numEdges;
    }

    public List vertices() {
        ArrayList<Vertex<T>> list = new ArrayList();
        for(GraphNode<T, E> g: graph) {
            Vertex<T> v = g.getV();
            list.add(v);
        }
        return list;
    }

    public List edges() {
        ArrayList<Edge<E>> list = new ArrayList();
        for(GraphNode<T, E> g: graph) {
            HashMap<Vertex<T>, Edge<E>> map = g.getMap();
            for(Edge<E> e: map.values()) {
                if(!(list.contains(e))) {
                    list.add(e);
                }
            }
        }
        return list;
    }

    //Is keyset a list?
    //getEdge(u, v)
    //Returns the edge from vertex u to vertex v, if one exists; otherwise return null. For an undirected graph, there is no difference between getEdge(u, v) and getEdge(v, u).
    public Edge<E> getEdge(T v1, T v2) {
        GraphNode<T, E> node = findNode(v1);
        for(Vertex<T> x: node.getMap().keySet()) {
            if(x.getData().compareTo(v2) == 0) {
                return node.getMap().get(x);
            }
        }
        return null;
    }

    //Way to get map from vertex?? Or have to go through graphNode??
    //endVertices(e)
    //Returns an array containing the two endpoint vertices of edge e. If the graph is directed, the first vertex is the origin and the second is the destination.
    public List endVertices(E data) {
        ArrayList<Vertex<T>> list = new ArrayList();
        for (GraphNode<T, E> g : graph) {
            HashMap<Vertex<T>, Edge<E>> map = g.getMap();
            for (Vertex<T> v : map.keySet()) {
                if (map.get(v).getData().compareTo(data) == 0) {
                    list.add(g.getV());
                    list.add(v);
                }
            }
        }
        return list;
    }

    //opposite(v, e)
    //For edge e incident to vertex v, returns the other vertex of the edge; an error occurs if e is not incident to v.
    /*public Vertex<T> opposite(T tData, E eData) {
        GraphNode<T, E> node = findNode(tData);
        for()

    }*/

    public Vertex<T> opposite(T v1, E e1) {
        GraphNode<T, E> node = findNode(v1);
        for (Vertex<T> v : node.getMap().keySet()) {
            if (node.getMap().get(v).getData().compareTo(e1) == 0) {
                return v;
            }
        }
        return null;
    }

    public int outDegree(T v1) {
        int count = 0;
        GraphNode<T, E> node = findNode(v1);
        for(Edge<E> e: node.getMap().values()) {
            count++;
        }
        return count;
    }

    public int inDegree(T v1) {
        return outDegree(v1);
    }

    public List outgoingEdges(T v1) {
        ArrayList<Edge<E>> list = new ArrayList();
        GraphNode<T, E> node = findNode(v1);
        for(Edge<E> e: node.getMap().values()) {
            list.add(e);
        }
        return list;
    }

    public List incomingEdges(T v1) {
        return outgoingEdges(v1);
    }

    /*public void removeVertex(T v1) {
        GraphNode<T, E> node = findNode(v1);
        for (GraphNode<T, E> g : graph) {
            HashMap<Vertex<T>, Edge<E>> map = g.getMap();
            for (int i = 0; i < map.size(); i++) {
                Edge<E> e =
                if(v.getData().compareTo(v1) == 0) {
                    map.remove(v);
                }
            }
        }
        node = null;
    }*/

    public void removeVertex(T v1) {
        GraphNode<T, E> node = findNode(v1);
        for(Vertex<T> v: node.getMap().keySet()) {
            GraphNode<T, E> temp = findNode(v.getData());
            temp.getMap().remove(node.getV());
        }
        numEdges -= outDegree(v1);
        graph.remove(node);
    }

    public void removeEdge(E e1) {
        ArrayList<Vertex<T>> vList = (ArrayList<Vertex<T>>)endVertices(e1);
        GraphNode<T, E> node1 = findNode(vList.get(0).getData());
        GraphNode<T, E> node2 = findNode(vList.get(1).getData());
        node1.getMap().remove(node2.getV());
        node2.getMap().remove(node1.getV());
        numEdges --;
    }


}
