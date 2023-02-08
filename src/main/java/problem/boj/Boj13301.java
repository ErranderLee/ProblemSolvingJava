package problem.boj;

import java.util.Scanner;

public class Boj13301 {

    static long solution(int n) {
        long[] size = new long[81];
        long[] dp = new long[81];
        size[1] = 1;
        size[2] = 1;
        dp[1] = 4;
        dp[2] = 6;

        for (int i = 3; i <= n; i++) {
            size[i] = size[i - 1] + size[i - 2];
            dp[i] = dp[i - 1] + 2 * size[i];
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
