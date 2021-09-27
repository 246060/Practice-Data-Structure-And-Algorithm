import java.util.Arrays;

public class Main3 {
    public static void main(String[] args) {

        String s = "(da(";
        System.out.println(new StringBuilder(s).reverse());

        System.out.println(Integer.toBinaryString(29));
        System.out.println(Integer.parseInt("11101", 2));
        System.out.println(Integer.toBinaryString(29 & (~1 << 3)));

        System.out.println(Integer.toBinaryString(29 >> 2));
        System.out.println(Integer.toBinaryString(29 >>> 2));

        int N = 3;
        int[] arr = new int[N];

        for (int i = 0; i < 1 << N; i++) {
            int[] abc = new int[N];

            int bit = i;
            for (int j = 0; bit != 0; j++, bit >>= 1) {
                if ((1 & bit) == 0) {
                    continue;
                }
                abc[j] = 1;
            }

//            for (int k = N - 1; k >= 0; k--) {
//                System.out.print(abc[k] + " ");
//            }
            System.out.println(Arrays.toString(abc));
        }

        int i, j;
        char[] arr1 = {'a', 'b', 'c', 'd'};
        int n = 4;

        for (i = 0; i < (1 << (n)); i++) {
            for (j = 0; j < n; j++) {
                if ((i & (1 << j)) == 1) {
//                    System.out.printf("%c ", arr1[j]);
                }
            }
//            System.out.println();
        }
    }
}
