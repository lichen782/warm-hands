package cn.lich.itv.one50;

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * @author lich
 * @date 2023/12/30
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[] maxAfterI = new int[prices.length];
        maxAfterI[prices.length - 1] = 0;
        for (int i = prices.length - 2 ; i >= 0; i--) {
            maxAfterI[i] = Integer.max(maxAfterI[i + 1], prices[i + 1]);
        }

        int profit = 0;

        for (int i = 0; i < prices.length; i++) {
            profit = Integer.max(maxAfterI[i] - prices[i], profit);
        }

        return profit;
    }

    public static void main(String[] args) {
        MaxProfit m = new MaxProfit();
        int[] prices = {1, 4, 2};
        System.out.println(m.maxProfit(prices));
    }
}
