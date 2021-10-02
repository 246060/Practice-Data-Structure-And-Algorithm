package algorithm.Graph.Flow_Network.Ford_Fulkerson;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * In computer science, the Edmonds–Karp algorithm is an implementation of the Ford–Fulkerson method for
 * computing the maximum flow in a flow network in O(V*E^2) time.
 * <p>
 * http://en.wikipedia.org/wiki/Edmonds%E2%80%93Karp_algorithm
 * <br>
 *
 * @author Mateusz Cianciara <e.cianciara@gmail.com>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */

public class Edmonds_Karp {
    // https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/graph/EdmondsKarp.java

    private long[][] flow; //max flow beetween i and j verticles
    private long[][] capacity; // edge capacity
    private int[] parent; //parent
    private boolean[] visited; //just for checking if visited
    private int n, m;

    public Edmonds_Karp(int numOfVerticles, int numOfEdges) {
        this.n = numOfVerticles;
        this.m = numOfEdges;
        this.flow = new long[n][n];
        this.capacity = new long[n][n];
        this.parent = new int[n];
        this.visited = new boolean[n];
    }

    public void addEdge(int from, int to, long capacity) {
        assert capacity >= 0;
        this.capacity[from][to] += capacity;
    }

    /**
     * Get maximum flow.
     *
     * @param s source
     * @param t target
     * @return maximum flow
     */
    public long getMaxFlow(int s, int t) {

        int max_flow = 0;

        while (true) {
            Queue<Integer> Q = new ArrayDeque<>();
            Q.offer(s);

            Arrays.fill(visited, false);
            visited[s] = true;

            while (!Q.isEmpty()) {
                int current = Q.poll();
                for (int i = 0; i < n; ++i) {
                    if (!visited[i] && capacity[current][i] > flow[current][i]) {
                        visited[i] = true;
                        parent[i] = current;
                        Q.offer(i);
                    }
                }
                if (visited[t]) break;
            }

            if (!visited[t]) break;

            long temp = Long.MAX_VALUE;
            for (int i = t; i != s; i = parent[i]) {
                temp = Math.min(temp, (capacity[parent[i]][i] - flow[parent[i]][i]));
            }

            for (int i = t; i != s; i = parent[i]) {
                flow[parent[i]][i] += temp;
                flow[i][parent[i]] -= temp;
            }

            max_flow += temp;
        }

        return max_flow;
    }
}
