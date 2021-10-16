package solve_practice_problems.Baekjoon.구현;

import java.io.*;

public class 뜨거운_붕어빵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1[] = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int M = Integer.parseInt(str1[1]);

        for (int i = 0; i < N; i++) {
            bw.write(new StringBuilder(br.readLine()).reverse().toString());
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }
}
