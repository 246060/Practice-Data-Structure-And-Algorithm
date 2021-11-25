package solve_practice_problems.Baekjoon.구현;

import java.util.Scanner;

public class 이름_궁합_15312 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        char[] name1 = sc.nextLine().toCharArray();
        char[] name2 = sc.nextLine().toCharArray();

        int n = name1.length + name2.length;
        int[] nums = new int[n];

        for (int i = 0, cur = 0; i < name1.length; i++) {
            nums[cur++] = arr[name1[i] - 'A'];
            nums[cur++] = arr[name2[i] - 'A'];
        }

        while (nums.length != 2) {
            int[] tmp = new int[nums.length - 1];
            for (int i = 0; i < nums.length - 1; i++) {
                tmp[i] = (nums[i] + nums[i + 1]) % 10;
            }
            nums = tmp;
        }

        System.out.println(nums[0] + "" + nums[1]);

    }
}
