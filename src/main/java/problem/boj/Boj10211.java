package problem.boj;

import java.util.Arrays;
import java.util.Scanner;

public class Boj10211 {
    static int solution(int[] nums) {
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Integer.max(nums[i - 1] + nums[i], nums[i]);
            answer = Integer.max(answer, nums[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            scanner.nextLine();
            String[] numsStr = scanner.nextLine().split(" ");
            System.out.println(solution(Arrays.stream(numsStr).mapToInt(Integer::parseInt).toArray()));
        }
    }
}
