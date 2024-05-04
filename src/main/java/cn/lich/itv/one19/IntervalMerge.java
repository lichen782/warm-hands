package cn.lich.itv.one19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 *
 * @author lich
 * @date 2024/4/27
 */
public class IntervalMerge {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

        List<int[]> ans = new ArrayList<>();
        int rightMost = intervals[0][1];
        ans.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= ans.get(ans.size() - 1)[1]) {
                rightMost = Math.max(rightMost, intervals[i][1]);
                ans.get(ans.size() - 1)[1] = rightMost;
            } else {
                ans.add(intervals[i]);
                rightMost = intervals[i][1];
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        IntervalMerge i = new IntervalMerge();
        int[][] intervals = {{4, 5}, {2, 4}, {4, 6}, {3, 4}, {0, 0}, {1, 1}, {3, 5}, {2, 2}};
        int[][] ans = i.merge(intervals);
        for (int j = 0; j < ans.length; j++) {
            System.out.print("[" + ans[j][0] + ", " + ans[j][1] + "], ");
        }
    }
}
