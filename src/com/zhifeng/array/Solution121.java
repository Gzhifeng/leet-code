package com.zhifeng.array;

/**
 * 121. 买卖股票的最佳时机
 * @author ganzhifeng
 * @date 2022/4/19
 */
public class Solution121 {

    /**
     * 暴力破解
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    /**
     * 一次遍历
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit){
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int maxProfit1 = maxProfit1(prices);
        int maxProfit2 = maxProfit2(prices);
        System.out.println(maxProfit1);
        System.out.println(maxProfit2);
    }
}
