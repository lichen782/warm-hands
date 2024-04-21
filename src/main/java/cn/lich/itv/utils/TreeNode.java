package cn.lich.itv.utils;

/**
 * @author lich
 * @date 2023/8/27
 */
public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      @Override
      public boolean equals(Object another) {
          return (this == another) ||
                  another != null && (another instanceof TreeNode) && (((TreeNode)another).val == this.val);
      }

      @Override
      public int hashCode() {
          return Integer.valueOf(val).hashCode();
      }

      public String toString() {
          return String.valueOf(val);
      }
}
