package problem;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2) -> p1.frequency - p2.frequency);

        for (int num: nums) {
            if (hashMap.containsKey(num)) {
                hashMap.put(num, hashMap.get(num) + 1);
            } else {
                hashMap.put(num, 1);
            }
        }

        for (Integer keys: hashMap.keySet()) {
            queue.add(new Pair(keys, hashMap.get(keys)));
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] answer = new int[k];
        int i = 0;
        while (queue.size() > 0) {
            answer[i++] = queue.poll().key;
        }
        return answer;
    }

    public static class Pair {
        int key;
        int frequency;

        public Pair(int key, int frequency) {
            this.key = key;
            this.frequency = frequency;
        }
    }
}


