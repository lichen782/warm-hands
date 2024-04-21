package cn.lich.itv.one50;

import java.util.*;

/**
 * @author lich
 * @date 2024/2/3
 */
public class Permute {

    private List<List<Integer>> ans = new ArrayList<>();

    private Set<Integer> searchSet = new HashSet<>();

    private int[] nums;

    private Deque<Integer> path;

    public List<List<Integer>> permute(int[] nums) {

        init(nums);

        dfs();

        return ans;
    }

    private void init(int[] nums) {
        searchSet.clear();
        ans.clear();
        for (int n: nums) {
            searchSet.add(n);
        }
        this.path = new ArrayDeque<>();
        this.nums = nums;
    }

    private void dfs() {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (searchSet.remove(nums[i])) {
                path.add(nums[i]);
                dfs();
                path.removeLast();
                searchSet.add(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Permute p = new Permute();
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = p.permute(nums);
        for (List<Integer> ll: ans) {
            for (Integer i: ll) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
