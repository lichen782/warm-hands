package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lich
 * @date 2024/1/16
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int pos = Arrays.binarySearch(intervals, newInterval, Comparator.comparingInt(a -> a[0]));

        if (pos < 0) {
            pos = -(pos + 1);
        }

        int[][] newIntervals = new int[intervals.length + 1][];

        for (int i = 0; i < pos; i++) {
            newIntervals[i] = intervals[i];
        }

        newIntervals[pos] = newInterval;

        for (int i = pos + 1; i < newIntervals.length; i++) {
            newIntervals[i] = intervals[i - 1];
        }

        return merge(newIntervals);
    }

    private int[][] merge(int[][] intervals) {
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
        InsertInterval ii = new InsertInterval();
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};//{{1,3},{6,9}};
        int[] newInterval = {4,8};
        int[][] merged = ii.insert(intervals, newInterval);

        for (int i = 0; i < merged.length; i++) {
            System.out.println("[" + merged[i][0] + "," + merged[i][1] + "]");
        }
    }
}
