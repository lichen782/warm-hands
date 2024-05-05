package cn.lich.itv.one19;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
 *
 * candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
 *
 *
 *
 * 示例 1：
 *
 * 输入: candidates = [2,3,6,7], target = 7
 * 输出: [[7],[2,2,3]]
 * 示例 2：
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 *
 * 输入: candidates = [2], target = 1
 * 输出: []
 * 示例 4：
 *
 * 输入: candidates = [1], target = 1
 * 输出: [[1]]
 * 示例 5：
 *
 * 输入: candidates = [1], target = 2
 * 输出: [[1,1]]
 *
 * @author lich
 * @date 2024/5/4
 */
public class CombinationSum {

    private int[] candidates;

    private LinkedList<Integer> path;

    private List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.ans = new ArrayList<>();
        this.path = new LinkedList<>();

        dfs(0, target);

        return this.ans;
    }

    private void dfs(int from, int tgt) {
        if (tgt <= 0) {
            if (tgt == 0) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = from; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(i, tgt - candidates[i]);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {1};
        int target = 2;
        List<List<Integer>> ans = cs.combinationSum(candidates, target);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.join(",", ans.get(i).stream().map(String::valueOf).collect(Collectors.toList())));
        }
    }

}
