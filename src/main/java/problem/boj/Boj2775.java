package problem.boj;

import java.util.Scanner;

public class Boj2775 {

    static int solution(int n, int k) {
        int[][] dp = new int[n+1][k+1];
        int sum = 0;
        for (int i = 1; i <= k; i++){
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n, k;
        while (t > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(solution(n, k));
            t--;
        }
    }
}
