package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2：
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 * @author lich
 * @date 2024/2/2
 */
public class NKCombines {

    public List<List<Integer>> combine(int n, int k) {
        return accumulate(n, k);
    }

    private List<List<Integer>> accumulate(int n, int k) {
        List<List<Integer>> l = new ArrayList<>();
        if (n <=0 || k <= 0) {
            return l;
        }
        if (n <= k) {
            List<Integer> ll = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ll.add(i + 1);
            }
            l.add(ll);
            return l;
        }

        List<List<Integer>> l1 = accumulate(n - 1, k - 1);
        List<List<Integer>> l2 = accumulate(n - 1, k);

        if (l1.isEmpty()) {
            l1.add(new ArrayList<>());
        }

        for (List<Integer> ll: l1) {
            ll.add(n);
        }

        l.addAll(l1);
        l.addAll(l2);

        return l;
    }

    public static void main(String[] args) {
        NKCombines nkCombines = new NKCombines();
        List<List<Integer>> l = nkCombines.combine(4, 4);
        for (List<Integer> ll: l) {
            for (Integer i: ll) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
