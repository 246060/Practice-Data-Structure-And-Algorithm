package algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon_1946 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        String[] t = null;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];

            for (int j = 0; j < N; j++) {
                t = br.readLine().split(" ");
                arr[j][0] = Integer.parseInt(t[0]);
                arr[j][1] = Integer.parseInt(t[1]);
            }

            Arrays.sort(arr, (o1, o2) -> Integer.compare(o1[0], o2[0]));

            int pivot = arr[0][1];
            int count = 1;

            for (int j = 1; j < N; j++) {
                if (arr[j][1] < pivot) {
                    pivot = arr[j][1];
                    count++;
                }
            }
            System.out.println(count);
        }
    }

}
