package problem.boj;

import java.util.Scanner;

public class Boj9655 {

    public static String solution(int k) {
        // 0 : SK, 1 : CY
        int[] dp = new int[1001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;

        for (int i = 4; i <= k; i++) {
            dp[i] = (dp[i - 3] + 1) % 2;
        }

        if (dp[k] == 0) {
            return "SK";
        }

        return "CY";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
/*
dp[1] = s
dp[2] = c
dp[3] = s
dp[4] = dp[1]^
dp[5] = dp[2]^
dp[6] = dp[3]^
 */
