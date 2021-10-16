package concept_study.data_structure.Graph;

import java.util.ArrayList;

public class Edge_List {

    public static void main(String[] args) {

        ArrayList<int[]> edges = new ArrayList<>();

        edges.add(new int[]{1, 2, 4}); // 연결 : 1 -> 2, 비용 : 4
        edges.add(new int[]{1, 3, 5}); // 연결 : 1 -> 3, 비용 : 5
        edges.add(new int[]{2, 3, 2}); // 연결 : 2 -> 3, 비용 : 2

    }
}
