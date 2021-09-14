package algorithm.Number_Theory;

import java.util.LinkedList;

public class Permutation {
    // https://yongku.tistory.com/entry/%EC%9E%90%EB%B0%94Java-%EC%88%9C%EC%97%B4Permutation%EA%B3%BC-%EC%A1%B0%ED%95%A9Combination
    // https://bgpark.tistory.com/89
    // https://bcp0109.tistory.com/14

    public static void main(String[] args) {
        int n = 5;
        int r = 3;

        //순열
        Permutation(n, r, new LinkedList<Integer>(), new int[n]);

        //중복순열
        Repermutation(n, r, new LinkedList<Integer>());
    }

    //순열
    public static void Permutation(int n, int r, LinkedList<Integer> perArr, int[] Check) {
        if (perArr.size() == r) {
            System.out.println(perArr);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (Check[i] == 0) {
                perArr.add(i);
                Check[i] = 1;
                Permutation(n, r, perArr, Check);
                Check[i] = 0;
                perArr.removeLast();
            }
        }
    }

    //중복순열
    public static void Repermutation(int n, int r, LinkedList<Integer> rePerArr) {
        if (rePerArr.size() == r) {
            System.out.println(rePerArr);
            return;
        }

        for (int i = 0; i < n; i++) {
            rePerArr.add(i);
            Repermutation(n, r, rePerArr);
            rePerArr.removeLast();
        }
    }

}
