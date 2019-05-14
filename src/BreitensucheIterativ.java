import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nicolaiemig on 24.03.17.
 */
public class BreitensucheIterativ {
    public static void breitensuche (Graph g, String start, String gesuchterKnoten){
        Queue<Vertex> s = new LinkedList<Vertex>();
        Vertex aktuellerKnoten;

        s.add(g.getVertex(start));

        while(!s.isEmpty()){
            aktuellerKnoten = s.remove();
            System.out.println("Bearbeite: " +aktuellerKnoten.name);
            if (aktuellerKnoten.name.equals(gesuchterKnoten)){
                System.out.println("Ziel " + gesuchterKnoten + " gefunden");
                break;
            }
            for (Edge kanteZuNachbarn : aktuellerKnoten.edges){
                s.add(kanteZuNachbarn.dest);
            }
        }

    }
}
