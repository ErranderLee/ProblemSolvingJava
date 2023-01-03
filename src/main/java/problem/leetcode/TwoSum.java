package problem.leetcode;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            answer[0] = i;
            if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != i) {
                answer[1] = hashMap.get(target - nums[i]);
                break;
            }
        }

        return answer;
    }
}
