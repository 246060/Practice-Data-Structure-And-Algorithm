import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = N + (N - 1);

        Stack<String> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(" ");
            }

            for (int j = i; j < M - i; j++) {
                if (i == 0) {
                    sb.append("*");
                } else {
                    if (j != i && j != M - i - 1) {
                        sb.append(" ");
                    } else {
                        sb.append("*");
                    }
                }
            }
            st.push(sb.toString());
        }

        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
