package problem.boj;

import java.util.Scanner;

public class Boj15489 {
    static int solution(int r, int c, int w) {
        int answer = 0;
        int[][] arr = new int[r + w - 1][r + w - 1];
        for (int i = 0; i < r + w - 1; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
        }

        for (int i = 2; i < r + w - 1; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        int pos = 1;
        for (int i = r - 1; i < r + w - 1; i++) {
            for (int j = 0; j < pos; j++) {
                answer += arr[i][j + c - 1];
            }
            pos += 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int w = scanner.nextInt();
        System.out.println(solution(r, c, w));
    }
}
