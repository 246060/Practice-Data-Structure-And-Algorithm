package solve_practice_problems.Baekjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_15651 {

    static int[] arr;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

//        N = 3;
//        M = 3;

        arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++)
            arr[i] = i;

        backtracking(1, new ArrayList<>());

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void backtracking(int level, ArrayList<Integer> result) {
        if (result.size() == M) {
            for (int o : result)
                sb.append(o).append(" ");
            sb.append("\n");
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            if (i >= level) {
                result.add(i);
                backtracking(i, result);
                result.remove(result.size() - 1);
            }
        }
    }
}
