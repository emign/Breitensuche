/************************* Dijkstra.java **************************************/

import java.util.PriorityQueue;

/**
 * implementiert den single source shortest path Algorithmus nach Dijkstra
 */
/*                                                                            */
/*  Es sind nur nichtnegative Kantenkosten zugelassen                         */
/*                                                                            */
/*  Verwendet wird eine Priority-Queue der Knoten, gewichtet mit den Kosten   */
/*  des vorlaeufig kuerzesten Weges vom Startknoten bis zu diesem Knoten      */

public class Dijkstra {

    public static void dijkstra(Graph g, Vertex start) {

        PriorityQueue<Vertex> p =
                new PriorityQueue<Vertex>();

        for (Vertex v : g.vertices()) {
            v.dist = Double.MAX_VALUE;
            v.seen = false;
            v.prev = null;
        }

        start.dist = 0;
        p.add(start);

        while (!p.isEmpty()) {

            Vertex v = p.poll();
            if (v.seen) continue;
            v.seen = true;

            for (Edge e : v.edges) {
                Vertex w = e.dest;
                double c = e.cost;
                if (c < 0) throw new
                        RuntimeException("Negativ");
                if (w.dist > v.dist + c) {
                    w.dist = v.dist + c;
                    w.prev = v;
                    p.add(w);
                }
            }
        }
    }
}