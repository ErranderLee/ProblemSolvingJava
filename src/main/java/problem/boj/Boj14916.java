package problem.boj;

import java.util.Scanner;

public class Boj14916 {

    static int solution(int n) {
        int[] dp = new int[100001];
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (dp[i - 5] != -1) {
                dp[i] = dp[i - 5] + 1;
            } else {
                dp[i] = i / 2;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
