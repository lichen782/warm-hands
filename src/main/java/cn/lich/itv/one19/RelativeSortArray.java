package cn.lich.itv.one19;

import cn.lich.itv.utils.Utils;

import java.util.*;

/**
 *
 * 给定两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * @author lich
 * @date 2024/4/29
 */
public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> v2pos = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            v2pos.put(arr2[i], i);
        }

        Integer[] arr = new Integer[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }

        Arrays.sort(arr, Comparator.comparing(a -> {
            if (v2pos.containsKey(a)) {
                return v2pos.get(a);
            }
            return v2pos.size() + a;
        }));

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arr[i];
        }
        return arr1;
    }


    public static void main(String[] args) {
        RelativeSortArray r = new RelativeSortArray();
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        int [] arr3 = r.relativeSortArray(arr1, arr2);
        Utils.print(arr3);
    }
}
