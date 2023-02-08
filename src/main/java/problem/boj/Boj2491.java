package problem.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj2491 {

    static int solution(int[] nums) {
        // 0은 커지는 것, 1은 작아지는 것
        int state = -1;
        int answer = 1;
        int sameStack = 1;
        int now = nums[0];
        int compareAnswer = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == now) {
                sameStack += 1;
                compareAnswer += 1;
            } else if (nums[i] > now) {
                if (state == -1) {
                    state = 0;
                    compareAnswer += 1;
                } else if (state == 0) {
                    compareAnswer += 1;
                } else {
                    state = 0;
                    compareAnswer = sameStack + 1;
                }
                sameStack = 1;
            } else {
                if (state == -1) {
                    state = 1;
                    compareAnswer += 1;
                } else if (state == 0) {
                    state = 1;
                    compareAnswer = sameStack + 1;
                } else {
                    compareAnswer += 1;
                }
                sameStack = 1;
            }
            now = nums[i];
            answer = Math.max(answer, compareAnswer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numsStr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(numsStr));
    }
}
