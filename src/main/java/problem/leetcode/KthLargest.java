package problem.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
  PriorityQueue<Integer> queue = new PriorityQueue<>();
  int k;

  public KthLargest(int k, int[] nums) {
    this.k = k;
    for (int num: nums) {
      queue.add(num);
    }
  }

  public int add(int val) {
    queue.add(val);
    while (queue.size() > k) {
      queue.poll();
    }
    return queue.peek();
  }
}
