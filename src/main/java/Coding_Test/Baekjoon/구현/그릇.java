package Coding_Test.Baekjoon.구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그릇 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char[] bowers = sc.nextLine().toCharArray();
        Queue<Character> q = new LinkedList<>();

        int n = bowers.length;
        for (int i = 0; i < n; i++) {
            q.offer(bowers[i]);
        }

        char before = q.poll();
        int height = 10;
        while (!q.isEmpty()) {
            char cur = q.poll();
            if (cur == before) {
                height += 5;
            } else {
                height += 10;
            }
            before = cur;
        }

        System.out.println(height);
    }
}
