package org.example.leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int buyTime = 0;
        int next = 0;
        boolean found = false;
        int maxProfit = 0;

        while (buyTime < prices.length && !found) {
            if (buyTime + 1 < prices.length) {
                next = buyTime + 1;
            }

            for (int i = next; i < prices.length; i++) {
                if (prices[buyTime] > prices[i]) {
                    break;
                } else {
                    int margin = prices[i] - prices[buyTime];
                    if (margin > maxProfit) {
                        maxProfit = margin;
                    }
                }

                if (i == prices.length - 1) {
                    found = true;
                }
            }

            buyTime++;
        }

        return maxProfit;
    }

    public int enhancedMaxProfit(int[] prices) {
        int next = 0;
        int buyTime = 0;
        int maxProfit = 0;
        while (buyTime < prices.length) {
            if (buyTime + 1 < prices.length) {
                next = buyTime + 1;
            }

            if (prices[buyTime] < prices[next]) {
                int margin = prices[next] - prices[buyTime];
                maxProfit += margin;
            }

            buyTime++;
        }

        return maxProfit;
    }
}
