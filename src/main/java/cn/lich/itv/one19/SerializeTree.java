package cn.lich.itv.one19;

import cn.lich.itv.utils.TreeNode;
import cn.lich.itv.utils.Utils;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * @author lich
 * @date 2024/4/6
 */
public class SerializeTree {

    private static final TreeNode NULL = new TreeNode();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n != root) {
                sb.append(",");
            }
            sb.append(n == NULL ? "null" : n.val);

            if (n != NULL) {
                q.add(n.left == null ? NULL : n.left);
                q.add(n.right == null ? NULL : n.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        Deque<TreeNode> q = new ArrayDeque<>();

        String[] arr = data.split(",");
        int i = 0;
        TreeNode root = new TreeNode(Integer.valueOf(arr[i]));
        q.add(root);
        i++;

        while (i < arr.length && !q.isEmpty()) {
            TreeNode n = q.poll();

            if (arr[i].equals("null")) {
                n.left = null;
            } else {
                n.left = new TreeNode(Integer.valueOf(arr[i]));
                q.add(n.left);
            }
            i++;
            if (i == arr.length) {
                break;
            }
            if (arr[i].equals("null")) {
                n.right = null;
            } else {
                n.right = new TreeNode(Integer.valueOf(arr[i]));
                q.add(n.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        SerializeTree st = new SerializeTree();
        Integer[] nums = {1,2,3,null,null,4,5};
        TreeNode root = Utils.initTreeNode(nums);

        String s = st.serialize(root);
        System.out.println("serialized: " + s);

        root = st.deserialize(s);
        System.out.print("deserialized: ");
        Utils.print(root);
    }
}
