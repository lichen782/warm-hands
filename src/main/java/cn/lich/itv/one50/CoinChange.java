package cn.lich.itv.one50;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author lich
 * @date 2024/2/22
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> caches = new HashMap<>();
        caches.put(0, 0);
        return coinChangeInternal(coins, amount, caches);
    }

    private int coinChangeInternal(int[] coins, int amount, Map<Integer, Integer> caches) {
        if (caches.containsKey(amount)) {
            return caches.get(amount);
        }

        int changeMin = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int next = amount - coins[i];
            if (next < 0) {
                continue;
            }
            int count = coinChangeInternal(coins, next, caches);
            if (count != -1) {
                changeMin = Math.min(count + 1, changeMin);
            }
        }

        if (changeMin == Integer.MAX_VALUE) {
            changeMin = -1;
        }

        caches.put(amount, changeMin);
        return changeMin;
    }

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(c.coinChange(coins, amount));
    }
}
