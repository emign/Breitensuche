/************************* GraphTest.java *************************************/

/**
 * testet die Graph-Algorithmen
 */

public class GraphTest {

    static Graph g = GraphIO.readGraph();             // Graph einlesen

    public static void main(String[] argv) {

        GraphIO.printGraph(g);                     // Graph ausgeben

        Breitensuche.breitensuche(g, "Hamburg",  "Muenchen");

    }

    public static void breitenSuche (String startKnoten, String gesuchterKnoten){
        Breitensuche.breitensuche(g,startKnoten,gesuchterKnoten);
    }


}