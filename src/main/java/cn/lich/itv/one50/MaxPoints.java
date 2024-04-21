package cn.lich.itv.one50;

import java.util.*;

/**
 * @author lich
 * @date 2024/2/20
 */
public class MaxPoints {

    class Line {
        int[] rate;

        Set<Integer> points = new HashSet<>();

        Line(int[] rate, int... pos) {
            this.rate = rate;
            for (Integer i : pos) {
                points.add(i);
            }
        }
    }

    public int maxPoints(int[][] points) {
        List<Line> lines = new ArrayList<>();
        Map<String, Map<Integer, Line>> rate2lines = new HashMap<>();
        int maxValue = 1;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] rate = rate(points, j, i);
                String rateKey = rateKey(rate);
                Line thisLine;
                if (rate2lines.containsKey(rateKey) && rate2lines.get(rateKey).containsKey(i)) {
                    thisLine = rate2lines.get(rateKey).get(i);
                    thisLine.points.add(j);
                    maxValue = Math.max(maxValue, thisLine.points.size());
                } else {
                    thisLine = newLine(rate, i, j);
                    lines.add(thisLine);
                    maxValue = Math.max(maxValue, 2);
                }
                if (!rate2lines.containsKey(rateKey)) {
                    rate2lines.put(rateKey, new HashMap<>());
                }
                rate2lines.get(rateKey).put(j, thisLine);
                rate2lines.get(rateKey).put(i, thisLine);
            }
        }
        return maxValue;
    }

    private Line newLine(int[] rate, int i, int j) {
        return new Line(rate, i, j);
    }

    private String rateKey(int[] rate) {
        return String.format("%s-%s", rate[0], rate[1]);
    }

    private int[] rate(int[][] points, int j, int i) {
        int up = points[j][1] - points[i][1];
        int down = points[j][0] - points[i][0];
        int gcd = findGCD(up, down);
        return new int[]{up/gcd, down/gcd};
    }

    private static int findGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return findGCD(num2, num1 % num2);
    }

    public static void main(String[] args) {
        MaxPoints m = new MaxPoints();
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        System.out.println(m.maxPoints(points));
    }

}
