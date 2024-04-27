package cn.lich.itv.one19;

import java.util.Arrays;

/**
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 *
 * arr.length >= 3
 * 存在 i（0 < i < arr.length - 1）使得：
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * 给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i ，即山峰顶部。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：arr = [1,3,5,4,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：arr = [0,10,5,2]
 * 输出：1
 * 示例 4：
 *
 * 输入：arr = [3,4,5,1]
 * 输出：2
 * 示例 5：
 *
 * 输入：arr = [24,69,100,99,79,78,67,36,26,19]
 * 输出：2
 * @author lich
 * @date 2024/4/23
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + ((right - left) / 2);

            if (arr[mid] > arr[mid+1]) {
                right = mid; // move the right pointer to the left
            } else {
                left = mid + 1; // move the left pointer to the right
            }
        }

        return left;
    }


    public static void main(String[] args) {
        PeakIndexInMountainArray p = new PeakIndexInMountainArray();
        int[][] cases = {
//                {0,1,0}, {1},
//                {1,3,5,4,2}, {2},
//                {0,10,5,2}, {1},
//                {3,4,5,1}, {2},
//                {24,69,100,99,79,78,67,36,26,19}, {2},
                {3,5,3,2,0}, {1}
        };
        for (int i = 0; i < cases.length; i += 2) {
            int k = p.peakIndexInMountainArray(cases[i]);
            System.out.println("expected: " + cases[i + 1][0] + ", actual: " + k);
        }
    }
}
