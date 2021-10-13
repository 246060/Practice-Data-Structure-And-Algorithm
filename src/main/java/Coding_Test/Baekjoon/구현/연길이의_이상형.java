package Coding_Test.Baekjoon.구현;

import java.util.HashMap;
import java.util.Scanner;

public class 연길이의_이상형 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<String, String> map = new HashMap<>();
        add(map, "E", "I");
        add(map, "S", "N");
        add(map, "T", "F");
        add(map, "J", "P");

        String[] arr = str.split("");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(map.get(arr[i]));
        }
    }

    static void add(HashMap<String, String> map, String str1, String str2) {
        map.put(str1, str2);
        map.put(str2, str1);
    }
}
