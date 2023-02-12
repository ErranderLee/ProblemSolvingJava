package problem.boj;

import java.util.Scanner;

public class Boj24417 {
    static int[] solution(int n) {
        int[] answer = new int[2];
        if (n == 1 || n == 2) {
            answer[0] = 1;
            return answer;
        }

        answer[1] = n - 2 % 1000000007;

        int temp1 = 1;
        int temp2 = 1;
        int temp = 0;
        for (int i = 3; i <= n; i++) {
            temp = temp1 % 1000000007;
            temp1 = temp2 % 1000000007;
            temp2 = (temp + temp2) % 1000000007;
        }
        answer[0] = temp2;

        return answer;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] answer = solution(scanner.nextInt());
        System.out.println(answer[0] + " " + answer[1]);
    }
}
