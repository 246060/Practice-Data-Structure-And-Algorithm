package algorithm.Graph.Articulation_Point;

import java.util.HashMap;

public class AP {
    /*
     * 단절정 특징
     * 1. 투르인 경우 자식이 2개 이상이면, AP가 된다.
     * 2. 자식 노드가 존재하며, 자식이 자신보다 조상 노드에 연결되지 못한 경우 자신은 AP가 된다.
     * */
    static boolean[][] a = new boolean[26][26];
    static boolean[] ap = new boolean[26];
    static int[] check = new int[26];

    static int n, cnt, order, child;

    static HashMap<Character, Integer> v = new HashMap<>();
    static HashMap<Integer, Character> c = new HashMap<>();

    public static void main(String[] args) {
        int[] first = {6, 6};
        String[][] edges = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"D", "E"}, {"D", "F"}, {"E", "F"}};

        n = first[0];
        int m = first[1];

        for (int i = 0; i < m; i++) {
            String[] edge = edges[i];

            char x = edge[0].charAt(0);
            char y = edge[1].charAt(0);

            int ix = getVertex(x);
            int iy = getVertex(y);

            // 양방향 연결 정보 저장
            a[ix][iy] = a[iy][ix] = true;
        }

        // 루트 지정: 0
        AP(0);

        // AP 특징 중 루트의 자식 2개 이상인지 확인
        if (child > 1)
            ap[0] = true;

        for (int i = 0; i < n; i++)
            if (ap[i])
                System.out.println(c.get(i));
    }

    static int getVertex(char ch) {
        if (!v.containsKey(ch)) {
            v.put(ch, cnt); // 문자 대응 인덱스 저장
            c.put(cnt, ch); // 인덱스 대응 문자 저장
            cnt++;
        }
        return v.get(ch);
    }

    static int AP(int s) {

        check[s] = ++order;
        int mn = order;

        for (int i = 0; i < n; i++) {

            if (a[s][i]) { // 현재 지점에서 연결된 지점으로 이동

                if (check[i] == 0) { // 자식을 방문하지 않은 경우
                    if (s == 0) // 다시 루트와 연결된 자식인 경우 자식 개수를 1 증가 시킨다.
                        ++child;

                    int x = AP(i); // 자식이 갈 수 있는 가장 높은 조상
                    if (mn > x) // 자신이 직접 갈 수 있는 조상보다 자식을 통해 갈 수 있는 조상이 더 높으면 업데이트
                        mn = x;

                    // 선조랑 연결되는 자식이 없다면 현재 점은 AP가 된다.
                    // 단, 이전에 AP로 체크되었는지, 출발점인지를 검사한다.
                    if (x >= check[s] && s != 0 && !ap[s])
                        ap[s] = true;

                } else if (mn > check[i]) { // 방문된 자식인 경우 최소 방문 회수를 구한다.
                    mn = check[i];
                }
            }
        }
        return mn;
    }
}
