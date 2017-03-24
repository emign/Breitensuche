/**************************** Result.java *************************************/

import AlgoTools.IO;

/**
 * Routinen zum Anzeigen der Loesungen, kodiert in den Arbeitsvariablen
 */

public class Result {

    private static void printPath(Vertex dest) {
        if (dest.prev != null) {
            printPath(dest.prev);
            IO.print(" -> ");
        }
        IO.print(dest.name);
    }

    public static void printPath(Graph g, Vertex w) {
        if (w.dist == Double.MAX_VALUE) IO.println(w.name + " nicht erreichbar");
        else {
            IO.println("Der kuerzeste Weg (mit Gesamtkosten " + w.dist + ") lautet: ");
            printPath(w);
        }
        IO.println();
        IO.println();
    }

    public static void printHamilton(Graph g, Vertex last) {
        if (last == null) IO.println("Graph hat keinen Hamiltonkreis");
        else {
            IO.println("Der Hamiltonkreis lautet:");
            printPath(last);
        }
        IO.println();
        IO.println();
    }

    public static void printTopo(Graph g) {
        boolean erfolgreich = true;
        for (Vertex v : g.vertices())
            if (v.nr < 0) erfolgreich = false;
        if (erfolgreich) {
            IO.println("Die Sortierung lautet:");
            for (Vertex v : g.vertices())
                IO.println("Knoten " + v.name + " erhaelt Nr. " + v.nr);
        } else IO.println("Graph kann nicht topologisch sortiert werden");
        IO.println();
    }

    public static void printTraverse(Graph g) {
        IO.println("Traversierungsreihenfolge:");
        for (Vertex v : g.vertices()) {
            IO.println(v.name + " erhaelt Nr. " + v.nr);
        }
        IO.println();
    }
}