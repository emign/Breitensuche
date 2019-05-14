/************************* GraphTest.java *************************************/

/**
 * testet die Graph-Algorithmen
 */

public class GraphTest {

    static Graph g = GraphIO.readGraph();             // Graph einlesen

    public static void main(String[] argv) {

        GraphIO.printGraph(g);                     // Graph ausgeben

        System.out.println("Breitensuche iterativ");
        BreitensucheIterativ.breitensuche(g, "Hamburg",  "Muenchen");
        System.out.println("---------------------");
        System.out.println("Breitensuche rerkursiv");
        g.breitenSucheRekursiv("Hamburg", "Muenchen");
    }




}