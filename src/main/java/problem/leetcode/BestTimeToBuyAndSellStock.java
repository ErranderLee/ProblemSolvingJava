package problem.leetcode;

import java.lang.*;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProfit = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            profit = prices[i] - mini;
            maxProfit = Math.max(profit, maxProfit);
            mini = Math.min(mini, prices[i]);
        }

        return maxProfit;
    }
}
