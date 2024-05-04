package cn.lich.itv.one19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 *
 *
 * 示例 1:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 示例 2:
 *
 * 输入: n = 1, k = 1
 * 输出: [[1]]
 *
 *
 * 提示:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @author lich
 * @date 2024/5/4
 */
public class Combine {

    private int n;

    private List<List<Integer>> ans;

    private List<Integer> path;

    private int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.ans = new ArrayList<>();
        this.k = k;
        this.path = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            dfs(i);
        }

        return this.ans;
    }

    private void dfs(int from) {

        path.add(from);

        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        for (int i = from + 1; i <= n; i++) {
            dfs(i);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        Combine c = new Combine();
        List<List<Integer>> ans = c.combine(1, 1);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.join(",", ans.get(i).stream().map(String::valueOf).collect(Collectors.toList())));
        }
    }
}
