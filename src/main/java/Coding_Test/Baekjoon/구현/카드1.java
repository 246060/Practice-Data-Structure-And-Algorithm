package Coding_Test.Baekjoon.구현;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            q.offer(i);

        ArrayList<Integer> drop = new ArrayList<>();
        while (!q.isEmpty()) {
            drop.add(q.poll());
            if (q.isEmpty()) {
                break;
            } else {
                q.offer(q.poll());
            }
        }

        for (int card : drop)
            System.out.print(card + " ");
    }
}
