package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/2/12
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1) {
            return findTopK(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2);
        } else {
            int s1 = findTopK(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2 - 1);
            int s2 = findTopK(nums1, 0, nums2, 0, (nums1.length + nums2.length) / 2);
            return ((double)(s1 + s2)) / 2.0d;
        }
    }

    private int findTopK(int[] nums1, int l1, int[] nums2, int l2, int k) {

        if (l1 >= nums1.length || l2 >= nums2.length) {
            if (l1 >= nums1.length) {
                return nums2[l2 + k];
            } else {
                return nums1[l1 + k];
            }
        }

        if (k == 0) {
            return Math.min(nums1[l1], l2 < nums2.length ? nums2[l2] : Integer.MAX_VALUE);
        }

        if (nums1[l1] >= nums2[l2]) {
            return findTopK(nums1, l1, nums2, l2 + 1, k - 1);
        }

        if (nums1[Math.min(l1 + k, nums1.length - 1)] <= nums2[l2]) {
            if (l1 + k < nums1.length) {
                return nums1[l1 + k];
            } else {
                return nums2[l2 + l1 + k - nums1.length];
            }
        } else {
            int l2idx = binarySearch(nums1, nums2[l2]);
            k -= l2idx - l1;
            return findTopK(nums1, l2idx, nums2, l2, k);
        }
    }

    private int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays f = new FindMedianSortedArrays();

        int[] nums1 = {1,3};
        int[] nums2 = {2};

        /*
        f.findTopK(nums1, 0, nums2, 0, 2);

        for (int i = 0; i < nums1.length + nums2.length; i++) {
            System.out.println(i + ": " + f.findTopK(nums1, 0,  nums2, 0, i));
        }*/
        System.out.println(f.findMedianSortedArrays(nums1, nums2));
    }
}
