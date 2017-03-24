/**
 * Vertex.java  Klasse zur Repraesentation eines Knoten
 * Klasse zur Repraesentation eines Knoten
 */
/** Klasse zur Repraesentation eines Knoten                                   */

import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> { // wegen Priority-Queue

    public String name;          // Name des Knoten               (fix)
    public List<Edge> edges;        // Nachbarn als Kantenliste      (fix)
    public int nr;            // Knotennummer                  (errechnet)
    public int indegree;      // Eingangsgrad                  (errechnet)
    public double dist;          // Kosten fuer diesen Knoten     (errechnet)
    public boolean seen;          // Besuchs-Status                (errechnet)
    public Vertex prev;          // Vorgaenger fuer diesen Knoten (errechnet)

    public Vertex(String s) {      // Konstruktor fuer Knoten
        name = s;                       // initialisiere Name des Knoten
        edges = new LinkedList<Edge>(); // initialisiere Nachbarschaftsliste
    }

    public boolean hasEdge(Vertex w) {// testet, ob Kante zu w besteht
        for (Edge e : edges)            // fuer jede ausgehende Nachbarkante pruefe
            if (e.dest == w)              // falls Zielknoten mit w uebereinstimmt
                return true;                // melde Erfolg
        return false;                   // ansonsten: melde Misserfolg
    }

    public int compareTo(Vertex other) { // vergl. Kosten mit anderem Vertex
        return (int) (dist - other.dist);  // liefert Ergebnis des Vergleichs
    }
}