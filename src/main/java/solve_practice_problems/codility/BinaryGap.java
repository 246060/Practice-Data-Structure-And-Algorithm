package solve_practice_problems.codility;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);

        for (int i = 1; i < 1000000; i++) {
            System.out.print(i + " / ");
            System.out.print(Integer.toBinaryString(i) + " / ");
            System.out.println(solution(i));
        }
    }

    public static int solution(int N) {
        int max = 0;
        char[] bin = Integer.toBinaryString(N).toCharArray();

        for (int i = 0; i < bin.length; i++) {
            int cnt = 0;
            boolean flag = false;

            int k = i;
            while (k < bin.length && bin[k] != '1') {
                k++;
            }

            for (int j = k + 1; j < bin.length; j++) {
                if (bin[j] == '1') {
                    flag = true;
                    break;
                }
                cnt++;
            }


            if (flag && cnt != 0) {
                max = Math.max(max, cnt);
            }
        }

        return max;
    }
}
