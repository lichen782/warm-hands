package cn.lich.itv.one50;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 * <p>
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * -在x = 6处射出箭，击破气球[2,8]和[1,6]。
 * -在x = 11处发射箭，击破气球[10,16]和[7,12]。
 * 示例 2：
 * <p>
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 解释：每个气球需要射出一支箭，总共需要4支箭。
 * 示例 3：
 * <p>
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：气球可以用2支箭来爆破:
 * - 在x = 2处发射箭，击破气球[1,2]和[2,3]。
 * - 在x = 4处射出箭，击破气球[3,4]和[4,5]。
 *
 * @author lich
 * @date 2024/1/17
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points.length <= 1) {
            return 1;
        }

        Arrays.sort(points, Comparator.comparing(p -> p[0]));

        int rightBorder = points[0][1];
        int total = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= rightBorder) {
                rightBorder = Math.min(points[i][1], rightBorder);
                continue;
            }
            rightBorder = points[i][1];
            total++;
        }

        return total;
    }

    public static void main(String[] args) {
        FindMinArrowShots f = new FindMinArrowShots();
        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};//{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};//{{1, 2}, {3, 4}, {5, 6}, {7, 8}};//{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(f.findMinArrowShots(points));
    }
}
