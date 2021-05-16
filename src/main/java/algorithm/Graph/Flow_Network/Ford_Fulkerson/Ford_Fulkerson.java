package algorithm.Graph.Flow_Network.Ford_Fulkerson;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ford_Fulkerson {
    // https://www.geeksforgeeks.org/ford-fulkerson-algorithm-for-maximum-flow-problem/

    // Driver program to test above functions
    public static void main(String[] args) throws java.lang.Exception {

        // Let us create a graph shown in the above example
        int[][] graph = new int[][]{
                {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };

        Ford_Fulkerson m = new Ford_Fulkerson();
        System.out.println("The maximum possible flow is " + m.fordFulkerson(graph, 0, 5));
    }

    // Number of vertices in graph
    static final int V = 6;

    boolean dfs(int[][] rGraph, int s, int t, int[] parent) {

        boolean[] visited = new boolean[V];

        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        visited[s] = true;
        parent[s] = -1;

        while (!stack.isEmpty()) {
            int u = stack.pop();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {

                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }

                    stack.push(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        return false;
    }

    // Returns true if there is a path from source 's' to sink 't' in residual graph.
    // Also fills parent[] to store the path
    boolean bfs(int[][] rGraph, int s, int t, int[] parent) {
        // bfs는 edmonds karp 라는데???
        // 그래서 난 ford fulkerson과 edmonds karp를 차이나게 하기 위해 이번 예제에서 DFS를 사용함.
        // https://en.wikipedia.org/wiki/Ford%E2%80%93Fulkerson_algorithm

        // Create a visited array and mark all vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue, enqueue source vertex and mark source vertex as visited
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);
        visited[s] = true;
        parent[s] = -1;

        // Standard BFS Loop
        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {

                    // If we find a connection to the sink node, then there is no point in BFS
                    // anymore We just have to set its parent and can return true
                    if (v == t) {
                        parent[v] = u;
                        return true;
                    }

                    queue.offer(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }

        // We didn't reach sink in BFS starting from source, so return false
        return false;
    }

    // Returns tne maximum flow from s to t in the given graph
    int fordFulkerson(int[][] graph, int s, int t) {
        int u, v;

        // Create a residual graph and fill the residual graph with given capacities in the original graph
        // as residual capacities in residual graph

        // Residual graph where rGraph[i][j] indicates residual capacity of edge from i to j
        // (if there is an edge. If rGraph[i][j] is 0, then there is not)
        int[][] rGraph = new int[V][V];

        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        // This array is filled by BFS and to store path
        int[] parent = new int[V];

        // There is no flow initially
        int max_flow = 0;

        // Augment the flow while tere is path from source to sink
        // while (bfs(rGraph, s, t, parent)) {
        while (dfs(rGraph, s, t, parent)) {

            // Find minimum residual capacity of the edhes along the path filled by BFS.
            // Or we can say find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;

            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }

            // update residual capacities of the edges and reverse edges along the path
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            // Add path flow to overall flow
            max_flow += path_flow;
        }

        // Return the overall flow
        return max_flow;
    }

}
