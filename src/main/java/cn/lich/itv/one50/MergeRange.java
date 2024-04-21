package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author lich
 * @date 2024/1/16
 */
public class MergeRange {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparing(i -> i[0]));

        List<int[]> lr = new ArrayList<>();

        int lastLeft = intervals[0][0];
        int lastRight = intervals[0][1];
        lr.add(new int[]{lastLeft, lastRight});
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= lastRight) {
                lastRight = Math.max(intervals[i][1], lastRight);
                lr.get(lr.size() - 1)[1] = lastRight;
            } else {
                lastLeft = intervals[i][0];
                lastRight = intervals[i][1];
                lr.add(new int[]{lastLeft, lastRight});
            }
        }
        int[][] result = new int[lr.size()][];
        for (int i = 0; i < lr.size(); i++) {
            result[i] = lr.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        MergeRange mr = new MergeRange();
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};//{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = mr.merge(intervals);
        for (int i = 0; i < merged.length; i++) {
            System.out.println("[" + merged[i][0] + "," + merged[i][1] + "]");
        }
    }

}
