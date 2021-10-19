package concept_study.algorithm.graph.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Basic_DFS_BFS_GraphSearch {

    private static int N;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {

        N = 8;
        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);
        graph.get(2).add(1);
        graph.get(2).add(7);
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);
        graph.get(4).add(3);
        graph.get(4).add(5);
        graph.get(5).add(3);
        graph.get(5).add(4);
        graph.get(6).add(7);
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);
        graph.get(8).add(1);
        graph.get(8).add(7);

        int start = 1;

        System.out.println("recursiveDFS");
        // 1 2 7 6 8 3 4 5
        visited = new boolean[N + 1];
        recursiveDFS(start);
        System.out.println();

        System.out.println("DFS");
        // 1 8 7 6 2 3 5 4
        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();

        System.out.println("BFS");
        // 1 2 3 8 7 4 5 6
        visited = new boolean[N + 1];
        BFS(start);
    }

    private static void DFS(int source) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;

                // 방문하지 않은 인접 노드를 스택에 넣는다.
                for (int adj : graph.get(v)) {
                    if (!visited[adj])
                        stack.push(adj);
                }
            }
        }
    }

    private static void BFS(int source) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            if (!visited[v]) {
                System.out.print(v + " ");
                visited[v] = true;

                // 방문하지 않은 인접 노드를 큐에 넣는다.
                for (int adj : graph.get(v)) {
                    if (!visited[adj])
                        queue.offer(adj);
                }
            }
        }
    }

    private static void recursiveDFS(int source) {
        visited[source] = true;
        System.out.print(source + " ");

        for (int adj : graph.get(source)) {
            if (!visited[adj])
                recursiveDFS(adj);
        }
    }
}
