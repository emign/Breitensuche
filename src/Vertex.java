/**
 * Vertex.java  Klasse zur Repraesentation eines Knoten
 * Klasse zur Repraesentation eines Knoten
 */
/** Klasse zur Repraesentation eines Knoten                                   */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public boolean breitenSuche(String zielKnoten){
        Queue<Vertex> q = new LinkedList<Vertex>();
        this.seen = true;
        q.add(this);
        return breitenSucheRek(q, zielKnoten);

    }

    public boolean breitenSucheRek(Queue<Vertex> q, String zielKnoten){

        if (q.isEmpty()) {
            System.out.println("Liste leer");
            return false;
        }

        Vertex aktuellerKnoten = q.remove();
        System.out.println("Bearbeite " + aktuellerKnoten.name);
        aktuellerKnoten.seen = true;

            if (aktuellerKnoten.name.equals(zielKnoten)){
                System.out.println("Gefunden");
                return true;
            }
            for (Edge e : aktuellerKnoten.edges){
                if (!e.dest.seen)
                    q.add(e.dest);

          }

            breitenSucheRek(q, zielKnoten);

        return false;
    }
}