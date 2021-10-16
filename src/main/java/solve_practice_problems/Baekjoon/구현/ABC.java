package solve_practice_problems.Baekjoon.구현;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class ABC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" "))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        Arrays.sort(nums);

        char start = 'A';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put((char) (start + i), nums[i]);
        }

        char[] chars = sc.nextLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(map.get(chars[i]) + " ");
        }

    }
}
