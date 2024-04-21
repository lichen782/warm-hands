package cn.lich.itv.one19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lich
 * @date 2024/3/30
 */
public class FindMinDifference {

    public int findMinDifference(List<String> timePoints) {
        final int total_min = 24 * 60;
        boolean[] minute = new boolean[total_min];
        for (int i = 0; i < timePoints.size(); i++) {
            int offset = tominutes(timePoints.get(i));
            if (minute[offset]) {
                return 0;
            }
            minute[offset] = true;
        }

        int pre = minute[0] ? 0 : -1;
        int first = -1;
        if (pre != -1) {
            first = pre;
        }
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < minute.length; i++) {
            if (pre != -1 && minute[i]) {
                minDiff = Math.min(minDiff, i - pre);
            }
            if (minute[i]) {
                pre = i;
                if (first == -1) {
                    first = i;
                }
            }

        }
        minDiff = Math.min(minDiff, total_min + first - pre);
        return minDiff;
    }

    private int tominutes(String timePoints) {
        String[] arr = timePoints.split(":");
        return Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]);
    }

    public static void main(String[] args) {
        FindMinDifference f = new FindMinDifference();
        List<String> timePoints = Arrays.stream(new String[]{"12:12", "00:13"}).collect(Collectors.toList());
        System.out.println(f.findMinDifference(timePoints));
    }
}
