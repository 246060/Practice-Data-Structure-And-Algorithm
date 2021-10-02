package algorithm.Graph.Topological_Sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 다음순서__모든_위상정렬구하기 {
    /*
     * 모든 위상정렬 구한다.
     * DFS를 이용한 TP
     * */
    static boolean[][] graph;
    static int[] inDegrees;
    static char[] name, result;
    static int n;

    static HashMap<Character, Integer> alpha = new HashMap<>();

    public static void main(String[] args) {
/*
a b f g
a b b f
v w x y z
v y x v z v w v
* */
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            name = sc.nextLine()
                     .replaceAll(" ", "")
                     .toCharArray();

            n = name.length;
            graph = new boolean[n][n];
            result = new char[n];
            inDegrees = new int[n];

            Arrays.sort(name);
            for (int i = 0; i < n; i++) {
                alpha.put(name[i], i);
            }

            String[] split = sc.nextLine().split(" ");
            for (int i = 0; i < split.length; i++) {
                char a = split[i++].charAt(0);
                char b = split[i].charAt(0);
                
                graph[alpha.get(a)][alpha.get(b)] = true;
                inDegrees[alpha.get(b)]++;
            }

            DFS_TS(0);
        }
    }

    static void DFS_TS(int l) {
        if (l == n) {
            print();
        } else {
            for (int i = 0; i < n; i++) {
                if (inDegrees[i] == 0) {
                    result[l] = name[i];
                    
                    // 재방문 하지 않도록 처리
                    --inDegrees[i];

                    // 현재 변수 다음에 방문해야 하는 변수(현재와 연결된 노드) 정보를 1 감소
                    for (int j = 0; j < n; j++)
                        if (graph[i][j])
                            --inDegrees[j];

                    ++l;
                    DFS_TS(l);
                    --l;

                    for (int j = 0; j < n; j++)
                        if (graph[i][j])
                            ++inDegrees[j];

                    ++inDegrees[i];
                }
            }
        }
    }

    static void print() {
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
        System.out.println();
    }
}
