package Coding_Test.Baekjoon.구현;

import java.io.*;

public class 노솔브_방지문제야 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == (a & -a)) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
