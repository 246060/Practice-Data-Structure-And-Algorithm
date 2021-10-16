package concept_study.algorithm.Graph.Flow_Network.Bipartite_Matching;

import java.util.*;

public class Bipartite_Matching2 {
    /* MaxFlow 를 이용한 풀이 */

/*
5
1 3 5 7 9
5
2 4 6 8 10
11
1 2
1 6
2 3
3 6
3 10
4 5
4 9
5 8
6 7
7 8
9 10
* */

    static int[][] rn = new int[100][100];
    static boolean[] check = new boolean[100];
    static ArrayList<Integer> man = new ArrayList<>();
    static ArrayList<Integer> woman = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();
    static HashMap<Integer, Integer> place = new HashMap<>(), fn = new HashMap<>();
    static int total;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b, i;

        n = sc.nextInt();
        while (n-- > 0) {
            a = sc.nextInt();
            place.put(a, 0);
            man.add(a);
        }

        n = sc.nextInt();
        while (n-- > 0) {
            a = sc.nextInt();
            place.put(a, 1);
            woman.add(a);
        }

        n = sc.nextInt();
        while (n-- > 0) {
            a = sc.nextInt();
            b = sc.nextInt();

            if (place.containsKey(a))
                rn[a][b] = 1;
            else
                rn[b][a] = 1;
        }

        for (i = 0; i < man.size(); i++)
            rn[0][man.get(i)] = 1;

        total = man.size() + woman.size() + 1;

        for (i = 0; i < woman.size(); i++)
            rn[woman.get(i)][total] = 1;

        BipariteMatching();

        man.sort(Integer::compareTo);

        for (i = 0; i < man.size(); i++)
            if (fn.containsKey(man.get(i)))
                System.out.println(man.get(i) + " : " + fn.get(man.get(i)));
    }

    static boolean DFS(int x) {
        int i;

        if (x == total) {

            for (i = 0; i < path.size() - 1; i++) {

                if (man.contains(path.get(i))) {
                    fn.put(path.get(i), path.get(i + 1));
                }

                rn[path.get(i)][path.get(i + 1)] -= 1;
                rn[path.get(i + 1)][path.get(i)] += 1;
            }

            path.clear();
            path.add(0);
            return true;
        }

        for (i = 1; i <= total; i++) {
            if (rn[x][i] == 1 && check[i] == false) {
                check[i] = true;
                path.add(i);

                if (DFS(i) == true) return true;

                path.removeLast();
                check[i] = false;
            }
        }
        return false;
    }

    static void BipariteMatching() {
        path.add(0);

        while (DFS(0)) {
            Arrays.fill(check, false);
            check[0] = true;
        }
    }
}
