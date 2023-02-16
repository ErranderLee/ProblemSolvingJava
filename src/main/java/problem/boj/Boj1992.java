package problem.boj;

import java.util.*;

public class Boj1992 {
    static StringBuilder answer = new StringBuilder();

    static boolean checkCompress(int n, int x, int y, int[][] arr) {
        int sum = 0;
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                sum += arr[i][j];
            }
        }
        return (double) sum == Math.pow(n, 2.0) || sum == 0;
    }

    static void solution(int n, int x, int y, int[][] arr) {
        if (checkCompress(n, x, y, arr)) {
            answer.append(arr[x][y]);
            return;
        }
        int nextN = n / 2;
        answer.append('(');
        solution(nextN, x, y, arr);
        solution(nextN,  x, y + nextN, arr);
        solution(nextN, x + nextN, y, arr);
        solution(nextN, x + nextN, y + nextN, arr);
        answer.append(')');
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] nums = scanner.nextLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(nums[j]);
            }
        }
        solution(n, 0, 0, arr);
        System.out.println(answer);
    }

}
