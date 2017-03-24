/**
 * Edge.java *  Klasse zur Repraesentation einer Kante
 */

/**
 * Klasse zur Repraesentation einer Kante
 */

public class Edge {

    public Vertex dest;                 // Zielknoten, zu dem die Kante fuehrt
    public double cost;                 // Kosten dieser Kante

    public Edge(Vertex d, double c) {  // Konstruktor fuer Kante
        dest = d;                         // initialisiere Zielknoten
        cost = c;                         // initialisiere Kantenkosten
    }
}