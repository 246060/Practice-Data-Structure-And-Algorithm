package concept_study.algorithm.etc;

import java.io.*;
import java.util.ArrayList;

public class Baekjoon_11729_Hanoi_Tower_Transfer_Order {

    static ArrayList<String> paths = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 2, 3);

        bw.write(paths.size() + "\n");
        for (String path : paths) {
            bw.write(path);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    private static void hanoi(int n, int src, int mid, int dest) {
        if (n == 1) {
            paths.add(src + " " + dest);
        } else {
            hanoi(n - 1, src, dest, mid);
            paths.add(src + " " + dest);
            hanoi(n - 1, mid, src, dest);
        }
    }
}
