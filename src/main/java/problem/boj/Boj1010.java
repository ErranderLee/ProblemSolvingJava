package problem.boj;

import java.util.Scanner;

public class Boj1010 {

    static int solution(int n, int m) {
        if (n == 1) return m;
        if (n == m) return 1;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= m; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= m; j++) {
                if (i == j) dp[i][j] = 1;
                else {
                    for (int k = i - 1; k < j; k++) {
                        dp[i][j] += dp[i-1][k];
                    }
                }
            }
        }

        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            System.out.println(solution(scanner.nextInt(), scanner.nextInt()));
        }
    }
}
