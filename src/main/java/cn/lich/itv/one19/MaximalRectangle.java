package cn.lich.itv.one19;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 注意：此题 matrix 输入格式为一维 01 字符串数组。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = ["10100","10111","11111","10010"]
 * 输出：6
 * 解释：最大矩形如上图所示。
 * 示例 2：
 *
 * 输入：matrix = []
 * 输出：0
 * 示例 3：
 *
 * 输入：matrix = ["0"]
 * 输出：0
 * 示例 4：
 *
 * 输入：matrix = ["1"]
 * 输出：1
 * 示例 5：
 *
 * 输入：matrix = ["00"]
 * 输出：0
 * @author lich
 * @date 2024/4/2
 */
public class MaximalRectangle {

    class Item {

        int index;

        int mostLeft;

        Item(int index, int mostLeft) {
            this.index = index;
            this.mostLeft = mostLeft;
        }
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Item> stack = new ArrayDeque<>();

        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++) {
            Item preItem = null;
            while (!stack.isEmpty() && (i == heights.length || heights[stack.peek().index] > heights[i])) {
                preItem = stack.pop();
                maxArea = Math.max(maxArea, (i - preItem.mostLeft) * heights[preItem.index]);
            }
            if (i < heights.length) {
                Item item = new Item(i, preItem != null ? preItem.mostLeft : i);
                stack.push(item);
            }
        }
        return maxArea;
    }

    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0 || matrix[0].length() == 0) {
            return 0;
        }
        int maxArea = 0;
        int[] heights = new int[matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length(); j++) {
                if (matrix[i].charAt(j) == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            maxArea = Math.max(largestRectangleArea(heights), maxArea);
        }
        return maxArea;
    }


    public static void main(String[] args) {
        MaximalRectangle m = new MaximalRectangle();
        String[] matrix = {
                "10100",
                "10111",
                "11111",
                "10010"};
        int ans = m.maximalRectangle(matrix);
        System.out.println(ans);
    }

}
