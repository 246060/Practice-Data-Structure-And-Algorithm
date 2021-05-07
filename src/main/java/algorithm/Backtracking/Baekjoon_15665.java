package algorithm.Backtracking;

import java.io.*;
import java.util.*;

public class Baekjoon_15665 {

    static int[] arr;
    static int N;
    static int M;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N + 1];
        for (int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        backtracking(1, new ArrayList<>());
        for (String an : ans) {
            bw.write(an);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void backtracking(int level, ArrayList<Integer> result) {
        if (result.size() == M) {
            StringBuilder sb = new StringBuilder();
            for (int o : result)
                sb.append(arr[o]).append(" ");

            ans.add(sb.toString());
            return;
        }

        for (int i = level; i < arr.length; i++) {
            result.add(i);
            backtracking(i, result);
            result.remove(result.size() - 1);
        }
    }
}