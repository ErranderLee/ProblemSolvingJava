package problem.leetcode;

public class MaximumSubarray {
    // With O(n) solution => Kadane Algorithm
    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) return nums[0];

        int answer = nums[0]; // max sum in entire array
        int temp = nums[0]; // max sum at a moment

        for (int i = 1; i < nums.length; i++) {
            temp = Math.max(temp + nums[i], nums[i]);
            answer = Math.max(answer, temp);
        }

        return answer;
    }
}
