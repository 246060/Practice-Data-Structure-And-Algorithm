package algorithm.Two_Point;

import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baekjoon_15565_귀여운_라이언 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> lionIdxs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int cur = sc.nextInt();
            if (cur == 1) lionIdxs.add(i);
        }

        if (lionIdxs.size() < K) {
            System.out.println(-1);
            return;
        }

        int lastIndex = lionIdxs.size() - 1;
        if (lionIdxs.size() == K) {
            System.out.println(lionIdxs.get(lastIndex) - lionIdxs.get(0) + 1);
            return;
        }

        int s = 0, e = 0;
        int count = 1;
        int min = Integer.MAX_VALUE;
        while (true) {
            if (count >= K) {
                s++;
                count--;
            } else if (e >= lastIndex) {
                break;
            } else {
                e++;
                count++;
            }

            if (count == K) {
                min = Math.min(lionIdxs.get(e) - lionIdxs.get(s) + 1, min);
            }
        }

        System.out.println(min);

    }
}
