package Coding_Test.NAVER.NAVER_FINANCIAL;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class Problem3 {

    public static void main(String[] args) {

        String S = "22:22:21";
        String T = "22:22:23";
//        String S = "15:15:00";
//        String T = "15:15:12";
        System.out.println(solution(S, T));
    }

    public static int solution(String S, String T) {
        LocalTime st = LocalTime.parse(S);
        LocalTime et = LocalTime.parse(T);
        long diff = st.until(et, ChronoUnit.SECONDS);
        int count = 0;

        for (long i = 0; i <= diff; i++) {
            LocalTime cur = st.plusSeconds(i);
            String[] arr = cur.format(DateTimeFormatter.ofPattern("HHmmss")).split("");

            HashSet<String> set = new HashSet<>();
            for (String s : arr)
                set.add(s);

            if (set.size() <= 2)
                ++count;
        }
        return count;
    }

}
