package cn.lich.itv.one19;

import java.util.*;

/**
 * 给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "google"
 * 输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
 * 示例 2：
 *
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出：[["a"]]
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 *
 * @author lich
 * @date 2024/5/5
 */
public class Partition {

    private Map<Integer, LinkedHashSet<Integer>> hwMap;

    private String s;

    private Deque<String> path;

    private List<String[]> ans;

    public String[][] partition(String s) {
        hwMap = hwDetect(s);
        this.s = s;
        path = new ArrayDeque<>();
        ans = new ArrayList<>();

        dfs(0);

        return ans.toArray(new String[ans.size()][]);
    }

    private void dfs(int from) {
        if (from == s.length()) {
            ans.add(path.toArray(new String[path.size()]));
            return;
        }

        if (!hwMap.containsKey(from)) {
            return;
        }

        for (Integer next: hwMap.get(from)) {
            path.add(s.substring(from, next));
            dfs(next);
            path.removeLast();
        }

    }

    private Map<Integer, LinkedHashSet<Integer>> hwDetect(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        Map<Integer, LinkedHashSet<Integer>> map = new HashMap<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (j == i) {
                    dp[i][j] = true;
                    setHwPos(map, i, j);
                } else {
                    dp[i][j] = (i + 1 == j | dp[i + 1][j - 1]) && s.charAt(i) == s.charAt(j);
                    if (dp[i][j]) {
                        setHwPos(map, i, j);
                    }
                }
            }
        }
        return map;
    }

    private void setHwPos(Map<Integer, LinkedHashSet<Integer>> map, int i, int j) {
        LinkedHashSet<Integer> s = map.getOrDefault(i, new LinkedHashSet<>());
        s.add(j + 1);
        map.put(i, s);
    }

    public static void main(String[] args) {
        Partition p = new Partition();
        String s = "aab";
        String[][] ans = p.partition(s);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + ",");
            }
            System.out.println();
        }
    }
}
