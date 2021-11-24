package solve_practice_problems.Baekjoon.구현;

import java.util.HashMap;
import java.util.Scanner;

public class 이름궁합_테스트_17269 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String[] names = sc.nextLine().split(" ");

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('A', 3);
        map.put('B', 2);
        map.put('C', 1);
        map.put('D', 2);
        map.put('E', 4);
        map.put('F', 3);
        map.put('G', 1);
        map.put('H', 3);
        map.put('I', 1);
        map.put('J', 1);
        map.put('K', 3);
        map.put('L', 1);
        map.put('M', 3);
        map.put('N', 2);
        map.put('O', 1);
        map.put('P', 2);
        map.put('Q', 2);
        map.put('R', 2);
        map.put('S', 1);
        map.put('T', 2);
        map.put('U', 1);
        map.put('V', 1);
        map.put('W', 1);
        map.put('X', 2);
        map.put('Y', 2);
        map.put('Z', 1);

        int n = N + M;
        int[] arr = new int[n];

        for (int cur = 0, i = 0, j = 0; cur < n; ) {
            if (i < N) arr[cur++] = map.get(names[0].charAt(i++));
            if (j < M) arr[cur++] = map.get(names[1].charAt(j++));
        }

        while (arr.length != 2) {
            int[] tmp = new int[arr.length - 1];
            for (int i = 0, j = 0; i < arr.length - 1; i++) {
                tmp[j++] = (arr[i] + arr[i + 1]) % 10;
            }
            arr = tmp;
        }

        System.out.println(String.format("%d%%", Integer.parseInt(arr[0] + "" + arr[1])));
    }
}
