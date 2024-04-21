package cn.lich.itv.one50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 *
 * @author lich
 * @date 2024/2/5
 */
public class GenerateParenthesis {

    private Deque<String> path;

    private List<String> ans;

    public List<String> generateParenthesis(int n) {
        init();

        dfs("(", n - 1, n);

        return ans;
    }

    private void dfs(String brace, int leftRemain, int rightRemain) {

        path.add(brace);

        /*System.out.println(path.stream().collect(
                StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());*/

        if (leftRemain == 0 && rightRemain == 0) {
            if (valid()) {
                ans.add(path.stream().collect(
                        StringBuilder::new, StringBuilder::append, StringBuilder::append).toString());
            }
            path.removeLast();
            return;
        }

        for (String b : new String[]{"(", ")"}) {
            if (b.equals("(") && leftRemain > 0) {
                dfs(b, leftRemain - 1, rightRemain);
            } else if (b.equals(")") && rightRemain > 0) { // )
                dfs(b, leftRemain, rightRemain - 1);
            }
        }

        path.removeLast();

    }

    private boolean valid() {
        Deque<String> stack = new ArrayDeque<>();
        for (String b : path) {
            if (b.equals("(")) {
                stack.push(b);
                continue;
            }

            // meet )
            String bb = stack.peek();
            if (bb != null && bb.equals("(")) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private void init() {
        path = new ArrayDeque<>();
        ans = new ArrayList<>();
    }

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        List<String> ans = g.generateParenthesis(3);
        for (String an : ans) {
            System.out.println(an);
        }
    }
}
