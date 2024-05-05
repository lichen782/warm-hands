package cn.lich.itv.one19;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * @author lich
 * @date 2024/5/5
 */
public class GenerateParenthesis {

    private Deque<String> path;

    private int n;

    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        path = new ArrayDeque<>();
        ans = new ArrayList<>();
        this.n = n;

        dfs(0, 0);

        return ans;
    }

    private void dfs(int left, int right) {
        if (left == right) {
            if (left == n) {
                ans.add(String.join("", path));
                return;
            }
            path.add("(");
            dfs(left + 1, right);
            path.removeLast();
            return;
        }

        if (left > right) {
            if (left < n) {
                path.add("(");
                dfs(left + 1, right);
                path.removeLast();
            }

            path.add(")");
            dfs(left, right + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> ans = g.generateParenthesis(3);
        ans.forEach(System.out::println);
    }
}
