package cn.lich.itv.one50;

/**
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 输入：nums1 = [1,2,3], m = 3, nums2 = [2,5,6,0,0,0], n = 3
 * [2,5,6,0,0,0] [1, 2, 3]
 * [0, 0, 0, 0, 0, 0]
 * [1, 2, 2, 3, 5, 6]
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 *
 * @author lich
 * @date 2023/12/26
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] a = new int[m + n];
        int im = 0;
        int in = 0;
        int ia = 0;
        while (im < m && in < n) {
            if (nums1[im] < nums2[in]) {
                a[ia++] = nums1[im++];
            } else {
                a[ia++] = nums2[in++];
            }
        }
        int[] leftover = im >= m ? nums2 : nums1;
        int leftIndex = im >= m ? in : im;
        for (int i = ia; i < nums1.length; i++) {
            a[i] = leftover[leftIndex++];
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = a[i];
        }

    }

    public static void main(String[] args) {
        MergeSortedArray m = new MergeSortedArray();
        int[] nums1 = {1,3,0,0,0,0};
        int[] nums2 = {2,9,10,100};
        m.merge(nums1, 2, nums2, 4);

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i] + ",");
        }
    }
}
