package problem.boj;

import java.util.*;

public class Boj17626 {

    static int solution(int n) {
        int[] dp = new int[50001];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int minCompare = 5;
            for (int j = 1; j <= (int) Math.sqrt((double) i); j++) {
                minCompare = Math.min(minCompare, dp[i - j * j] + 1);
            }
            dp[i] = minCompare;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(solution(scanner.nextInt()));
    }
}
