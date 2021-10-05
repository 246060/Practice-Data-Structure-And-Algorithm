package Coding_Test.Baekjoon.구현;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 저항 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String color1 = sc.nextLine();
        String color2 = sc.nextLine();
        String color3 = sc.nextLine();

        Map<String, Integer> colorsIdx = new HashMap<>();
        colorsIdx.put("black", 0);
        colorsIdx.put("brown", 1);
        colorsIdx.put("red", 2);
        colorsIdx.put("orange", 3);
        colorsIdx.put("yellow", 4);
        colorsIdx.put("green", 5);
        colorsIdx.put("blue", 6);
        colorsIdx.put("violet", 7);
        colorsIdx.put("grey", 8);
        colorsIdx.put("white", 9);

        int[] multi = new int[10];
        int s = 1;
        for (int i = 0; i < 10; i++) {
            multi[i] = s;
            s *= 10;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(colorsIdx.get(color1));
        sb.append(colorsIdx.get(color2));
        sb.append(String.valueOf(multi[colorsIdx.get(color3)]).substring(1));
        System.out.println(Long.parseLong(sb.toString()));
    }
}
