package problem.boj;

import java.util.*;

public class Boj9625 {

    public static Answer solution(int k) {
        Answer[] dp = new Answer[k+1];
        dp[0] = new Answer(1, 0);
        dp[1] = new Answer(0, 1);

        for (int i = 2; i <= k; i++) {
            dp[i] = new Answer(dp[i-1].b, dp[i-1].a + dp[i-1].b);
        }

        return dp[k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Answer answer = solution(scanner.nextInt());
        System.out.println(answer.a + " " + answer.b);
    }

    public static class Answer {
        int a;
        int b;

        public Answer(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
