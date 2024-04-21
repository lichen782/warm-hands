package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 *
 * @author lich
 * @date 2024/2/24
 */
public class TriangleMinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < triangle.size(); i++) {
            int pre = Integer.MAX_VALUE;
            for (int j = 0; j < i + 1; j++) {
                int temp = dp[j];
                dp[j] = Math.min(dp[j], pre) + triangle.get(i).get(j);
                pre = temp;
            }
        }
        return Arrays.stream(dp).min().getAsInt();
    }

    public static void main(String[] args) {
        TriangleMinimumTotal t = new TriangleMinimumTotal();
        int[][] nums = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3},
        };
        System.out.println(t.minimumTotal(makeTriangle(nums)));
    }

    private static List<List<Integer>> makeTriangle(int[][] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> row = new ArrayList<>(nums[i].length);
            for (int j = 0; j < nums[i].length; j++) {
                row.add(nums[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}
