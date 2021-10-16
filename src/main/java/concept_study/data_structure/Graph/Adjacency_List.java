package concept_study.data_structure.Graph;

import java.util.ArrayList;

public class Adjacency_List {

    public static void main(String[] args) {
        // 공간을` 효율적으로 사용

        int N = 3;
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++)
            graph.add(new ArrayList<>());

        graph.get(1).add(new int[]{2, 4}); // 1 --(cost : 4)-> 2
        graph.get(1).add(new int[]{3, 5}); // 1 --(cost : 5)-> 3
        graph.get(2).add(new int[]{3, 2}); // 2 --(cost : 2)-> 3

        for (int i = 1; i < N + 1; i++) {
            System.out.format("%d : ", i);
            for (int[] adj : graph.get(i)) {
                System.out.format("%d(Cost: %d), ", adj[0], adj[1]);
            }
            System.out.println();
        }
    }
}
