package Graphs;

/*
Vertex fields:
*Name (string)
* T data
* map of vertices, edges
(1) class Vertex
(2) class Edge
(3) class Node (Vertex v, map<vertex>, Edge)
(4) LinkedList<Node>
*/

public class Vertex<T extends Comparable<T>> {
    T data;
    public Vertex(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                '}';
    }
}

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
opposite(v, e) DONE
For edge e incident to vertex v, returns the other vertex of the edge; an error occurs if e is not incident to v.
outDegree(v) DONE
Returns the number of outgoing edges from vertex v.
inDegree(v) DONE
Returns the number of incoming edges to vertex v. For an undirected graph, this returns the same value as does outDegree(v).
outgoingEdges(v) DONE
Returns an iteration of all outgoing edges from vertex v.
incomingEdges(v) DONE
Returns an iteration of all incoming edges to vertex v. For an undirected graph, this returns the same collection as does outgoingEdges(v).
insertVertex(x) DONE
Creates and returns a new Vertex storing element x.
insertEdge(u, v, x) DONE
Creates and returns a new Edge from vertex u to vertex v, storing element x; an error occurs if there already exists an edge from u to v.
removeVertex(v) DONE
Removes vertex v and all its incident edges from the graph.
removeEdge(e) DONE
Removes edge e from the graph.
 */