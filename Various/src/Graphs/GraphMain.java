package Graphs;

import java.util.HashMap;
import java.util.ArrayList;

public class GraphMain {

    public static void main(String[] args) {

        //Can you get keys from values??

        //add exception that does not allow the same data to be added again
        MapGraph<String, String> graph = new MapGraph();
        String[] vertices = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        for(String a: vertices) {
            graph.addVertex(a);
        }

        graph.insertEdge("a", "b", "1");
        graph.insertEdge("a", "e", "2");
        graph.insertEdge("a", "f", "3");
        graph.insertEdge("b", "f", "4");
        graph.insertEdge("b", "c", "5");
        graph.insertEdge("c", "d", "6");
        graph.insertEdge("c", "g", "7");
        graph.insertEdge("g", "d", "8");
        graph.insertEdge("e", "f", "9");
        graph.insertEdge("e", "i", "10");
        graph.insertEdge("i", "f", "11");
        graph.insertEdge("j", "g", "12");
        graph.insertEdge("g", "l", "13");
        graph.insertEdge("h", "l", "15");
        graph.insertEdge("i", "j", "16");
        graph.insertEdge("j", "k", "17");
        graph.insertEdge("g", "k", "18");
        graph.insertEdge("i", "m", "19");
        graph.insertEdge("i", "n", "20");
        graph.insertEdge("n", "k", "21");
        graph.insertEdge("k", "o", "22");
        graph.insertEdge("l", "p", "23");
        graph.insertEdge("m", "n", "24");





















        /*graph.insertEdge("a", "b", "1");
        graph.insertEdge("b", "c", "2");
        graph.insertEdge("a", "d", "3");
        graph.insertEdge("d", "b", "4");
        graph.insertEdge("d", "e", "5");
        graph.insertEdge("e", "f", "6");
        graph.insertEdge("f", "c", "7");
        graph.insertEdge("g", "e", "8");
        graph.insertEdge("g", "h", "9");
        graph.insertEdge("h", "i", "10");
        graph.insertEdge("i", "f", "11");*/





        System.out.println("Hello World!");

    }
}
