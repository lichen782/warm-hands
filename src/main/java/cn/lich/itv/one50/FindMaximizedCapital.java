package cn.lich.itv.one50;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 *
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 *
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 *
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 *
 * 答案保证在 32 位有符号整数范围内。
 * @author lich
 * @date 2024/2/14
 */
public class FindMaximizedCapital {

    class ProfitWithCapital implements Comparable<ProfitWithCapital> {

        int index;
        int profit;

        int capital;

        ProfitWithCapital(int index, int profit, int capital) {
            this.index = index;
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public int compareTo(ProfitWithCapital o) {
            if (profit == o.profit) {
                return o.capital - capital;
            }
            return o.profit - profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<ProfitWithCapital> pq = createPQ(profits, capital);
        Deque<ProfitWithCapital> stack = new ArrayDeque<>();
        while (k > 0) {
            if (pq.isEmpty()) {
                break;
            }
            ProfitWithCapital profitWithCapital = pq.remove();
            if (profitWithCapital.capital > w) {
                stack.push(profitWithCapital);
            } else {
                w += profitWithCapital.profit;
                pq.addAll(stack);
                k--;
                stack.clear();
            }
        }
        return w;
    }

    private PriorityQueue<ProfitWithCapital> createPQ(int[] profits, int[] capital) {
        PriorityQueue<ProfitWithCapital> pq = new PriorityQueue(profits.length);
        for (int i = 0; i < profits.length; i++) {
            pq.add(new ProfitWithCapital(i, profits[i], capital[i]));
        }
        return pq;
    }

    public static void main(String[] args) {
        FindMaximizedCapital f = new FindMaximizedCapital();
        int k = 2;
        int w = 0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        System.out.println(f.findMaximizedCapital(k, w, profits, capital));
    }
}
