package cn.lich.itv.one50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lich
 * @date 2024/1/15
 */
public class ContainDupII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], i);
            } else {
                int lastIndex = indexMap.get(nums[i]);
                if (i - lastIndex <= k) {
                    return true;
                }
                indexMap.put(nums[i], i);
            }
        }
        return false;

    }

    public static void main(String[] args) {
        ContainDupII c = new ContainDupII();
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(c.containsNearbyDuplicate(nums, k));
    }
}
