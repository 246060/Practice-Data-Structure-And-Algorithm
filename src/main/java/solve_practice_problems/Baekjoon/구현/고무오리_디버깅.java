package solve_practice_problems.Baekjoon.구현;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 고무오리_디버깅 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> q = new LinkedList<>();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("고무오리 디버깅 시작")) {
                continue;
            } else if (str.equals("고무오리 디버깅 끝")) {
                break;
            }

            if (str.equals("문제")) {
                q.offer(str);
            } else {
                if (q.isEmpty()) {
                    q.offer("문제");
                    q.offer("문제");
                } else {
                    q.poll();
                }
            }
        }

        if(q.isEmpty()){
            System.out.println("고무오리야 사랑해");
        }else{
            System.out.println("힝구");
        }
    }
}
