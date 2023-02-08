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

    static int solutionUsingDp(int[] nums) {
        int pos = 0;
        int answer = 1;
        int[] dpAsc = new int[nums.length];
        dpAsc[0] = 1;
        int[] dpDsc = new int[nums.length];
        dpDsc[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[pos] <= nums[i]) {
                dpAsc[i] = dpAsc[i - 1] + 1;
            } else {
                dpAsc[i] = 1;
            }
            pos += 1;
            answer = Math.max(dpAsc[i], answer);
        }

        pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[pos] >= nums[i]) {
                dpDsc[i] = dpDsc[i - 1] + 1;
            } else {
                dpDsc[i] = 1;
            }
            pos += 1;
            answer = Math.max(dpDsc[i], answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numsStr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solutionUsingDp(numsStr));
    }
}
