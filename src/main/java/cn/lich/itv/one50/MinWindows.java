package cn.lich.itv.one50;

import java.util.*;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * @author lich
 * @date 2024/3/5
 */
public class MinWindows {

    public String minWindow(String s, String t) {
        Map<Character, Integer> ct = count(t);
        Set<Character> ks = new HashSet<>(ct.keySet());
        int i = 0;
        String minWin = "";
        Deque<Integer> queue = new ArrayDeque<>();
        while (i < s.length()) {
            if (remove(ct, s.charAt(i))) { // match some c in t
                if (ct.isEmpty()) {
                    // at i, satisfy the t
                    int len = queue.isEmpty() ? 1 : i - queue.peek() + 1;
                    if (minWin.length() == 0 || len < minWin.length()) {
                        minWin = s.substring(i - len + 1, i + 1);
                    }
                    add(ct, s.charAt(i - len + 1));
                    if (!queue.isEmpty()) {
                        queue.poll();
                    }
                }
                queue.add(i);
            } else if (ks.contains(s.charAt(i))) {
                if (!queue.isEmpty()) {
                    int pp = -1;
                    for (Integer p: queue) {
                         if (s.charAt(p) == s.charAt(i)) {
                             pp = p;
                             break;
                         }
                    }
                    queue.remove(pp);
                    queue.add(i);
                }
            }
            i++;
        }

        return minWin;
    }

    private boolean remove(Map<Character, Integer> counter, char c) {
        if (counter.containsKey(c)) {
            int ct = counter.get(c) - 1;
            if (ct == 0) {
                counter.remove(c);
            } else {
                counter.put(c, ct);
            }
            return true;
        }
        return false;
    }

    private void add(Map<Character, Integer> counter, char c) {
        counter.put(c, counter.getOrDefault(c, 0) + 1);
    }

    private Map<Character, Integer> count(String t) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char c : t.toCharArray()) {
            add(counter, c);
        }
        return counter;
    }

    public static void main(String[] args) {
        MinWindows m = new MinWindows();
        String s = "acbbaca";
        String t = "aba";
        System.out.println(m.minWindow(s, t));
    }
}
