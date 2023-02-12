package problem.boj;

import java.util.Scanner;

public class Boj14501 {
    static int solution(int[] t, int[] p) {
        int n = t.length;
        int[] dp = new int[n];

        if (t[n - 1] == 1) {
            dp[n - 1] = p[n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            if (i + t[i] > n) {
                dp[i] = dp[i + 1];
            } else if (i + t[i] == n){
                dp[i] = Integer.max(p[i], dp[i + 1]);
            } else {
                dp[i] = Integer.max(p[i] + dp[i + t[i]], dp[i + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] str = scanner.nextLine().split(" ");
            t[i] = Integer.parseInt(str[0]);
            p[i] = Integer.parseInt(str[1]);
        }
        System.out.println(solution(t, p));
    }
}
