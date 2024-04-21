package cn.lich.itv.one50;

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * 示例 2：
 *
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 *      随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * @author lich
 * @date 2024/2/28
 */
public class MaxProfitIV {

    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k];

        for (int i = 0; i < k; i++) {
            dp[0][2 * i] = -prices[0]; // 偶数：买股票，手上一定有股票
            dp[0][2 * i + 1] = 0;      // 奇数：卖股票，手上一定没股票
        }

        for (int i = 1; i < prices.length; i++) {
            // 首次购买是发生在第i天或者发生在前面某一天
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);

            // 首次卖出是发生在第i天还是发生在前面某一天
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);

            for (int j = 1; j < k; j++) {
                // 一共进行了2 * j + 1次买卖，当前手上有一个股票 (次数是奇数，但是index是偶数）
                // 1. 可能是之前购买的
                // 2. 或者是第i天当天购买的
                dp[i][2 * j] = Math.max(dp[i - 1][2 * j], dp[i - 1][2 * j - 1] - prices[i]);

                // 一共进行了2 * j + 2次买卖，所以成对了，手上没有股票
                // 1. 可能是之前卖掉了
                // 2. 或者就是今天卖掉的
                dp[i][2 * j + 1] = Math.max(dp[i - 1][2 * j + 1], dp[i - 1][2 * j] + prices[i]);
            }
        }

        return dp[prices.length - 1][2*k - 1];
    }

    public static void main(String[] args) {
        MaxProfitIV m = new MaxProfitIV();
        int k = 2;
        int[] prices = {3,2,6,5,0,3};
        System.out.println(m.maxProfit(k, prices));
    }
}
