package cn.lich.itv.one19;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.*;

/**
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 *
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 *
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 *
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 *
 * 提示：
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * @author lich
 * @date 2024/3/30
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for (String str: strs) {
            String key = counter(str);
            if (!m.containsKey(key)) {
                m.put(key, new ArrayList<>());
            }
            m.get(key).add(str);
        }

        return new ArrayList<>(m.values());
    }

    private String counter(String s) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int offset = s.charAt(i) - 'a';
            counter[offset]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter.length; i++) {
            sb.append(counter[i] + ".");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = g.groupAnagrams(strs);
        for (List<String> line: ans) {
            for (String w: line) {
                System.out.print(w + ",");
            }
            System.out.println();
        }
    }
}
