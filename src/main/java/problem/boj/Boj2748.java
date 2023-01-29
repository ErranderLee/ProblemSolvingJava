package problem.boj;

import java.util.Scanner;

public class Boj2748 {

    static long solution(int n) {
        long[] dp = new long[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
