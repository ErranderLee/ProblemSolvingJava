package problem.boj;

import java.util.*;

public class Boj2630 {

    static int checkSameColor(int[][] paper, int bx, int by, int ex, int ey) {
        int temp = paper[bx][by];

        for (int i = bx; i < ex + 1; i++) {
            for (int j = by; j < ey + 1; j++) {
                if (temp != paper[i][j]) {
                    return -1;
                }
            }
        }

        return temp;
    }

    static void rec(int[][] paper, int bx, int by, int ex, int ey, int num, int[] answer) {

        int result = checkSameColor(paper, bx, by, ex, ey);
        if (result == 0) {
            answer[0] += 1;
        } else if(result == 1) {
            answer[1] += 1;
        } else {
            rec(paper, bx, by, ex - num, ey - num, num / 2, answer);
            rec(paper, bx, by + num, ex - num, ey, num / 2, answer);
            rec(paper, bx + num , by, ex, ey - num, num / 2, answer);
            rec(paper, bx + num, by + num, ex, ey, num / 2, answer);
        }
    }

    static int[] solution(int[][] paper) {
        // index 0 : white, index 1 : blue
        int[] answer = new int[2];
        rec(paper, 0, 0, paper.length - 1, paper.length - 1, paper.length / 2, answer);
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        int[] answer = solution(paper);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
