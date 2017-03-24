/********************** GraphIO.java ******************************************/

import AlgoTools.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Routinen zum Einlesen eines gerichteten Graphen
 */
/*  Der Graph wird realisiert durch eine HashMap, welche                      */
/*  den Namen des Knoten auf den Knoten abbildet                              */

public class GraphIO {

    public static Graph readGraph() {   // liest Graph aus Datei ein
        Graph g = new Graph();
        try {
            BufferedReader f = new BufferedReader(new FileReader("src/graph.dat"));
            String zeile;
            while ((zeile = f.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(zeile);
                String source = st.nextToken();
                String dest = st.nextToken();
                double cost = Double.parseDouble(st.nextToken());
                g.addEdge(source, dest, cost);
            }
        } catch (Exception e) {
            IO.println(e);
        }
        return g;
    }

    public static void printGraph(Graph g) { // gibt Graph aus
        IO.println("Adjazenzlisten des Graphen:");
        for (Vertex v : g.vertices()) {
            for (Edge e : v.edges) {
                IO.print("(" + v.name + "," + e.dest.name + ")" + e.cost + "  ");
            }
            IO.println();
        }
        IO.println();
    }
}