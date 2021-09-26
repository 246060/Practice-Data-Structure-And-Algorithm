package Baekjoon.simulation;

import java.time.LocalDate;
import java.util.Scanner;

public class 기념일_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        LocalDate start = LocalDate.of(2014, 4, 2);
        System.out.println(start.plusDays(N - 1));
    }
}
