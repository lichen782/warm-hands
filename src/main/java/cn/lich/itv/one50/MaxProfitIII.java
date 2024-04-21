package cn.lich.itv.one50;

/**
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * @author lich
 * @date 2024/2/25
 */
public class MaxProfitIII {

    public int maxProfit(int[] prices) {
        int curMin = prices[0];
        int curMax = prices[prices.length - 1];
        int profitFwd = 0;
        int profitBack = 0;
        int[] maxProfitFwd = new int[prices.length];
        int[] maxProfitBack = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < curMin) {
                curMin = prices[i];
            }

            int j = prices.length - i - 1;
            if (prices[j] > curMax) {
                curMax = prices[j];
            }
            profitFwd = Math.max(prices[i] - curMin, profitFwd);
            profitBack = Math.max(curMax - prices[j] , profitBack);
            maxProfitFwd[i] = profitFwd;
            maxProfitBack[j] = profitBack;
        }

        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(maxProfitFwd[i] + maxProfitBack[i], profit);
        }

        return profit;
    }


    public static void main(String[] args) {
        MaxProfitIII m = new MaxProfitIII();
        int[] prices = {3,3,5,0,0,3,1,4};
        System.out.println(m.maxProfit(prices));
    }
}
