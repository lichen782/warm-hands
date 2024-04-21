package cn.lich.itv.one19;

import java.util.*;

/**
 * 给定两个字符串 s 和 t 。返回 s 中包含 t 的所有字符的最短子字符串。如果 s 中不存在符合条件的子字符串，则返回空字符串 "" 。
 * <p>
 * 如果 s 中存在多个符合条件的子字符串，返回任意一个。
 * <p>
 * <p>
 * <p>
 * 注意： 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最短子字符串 "BANC" 包含了字符串 t 的所有字符 'A'、'B'、'C'
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出：""
 * 解释：t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
 *
 * @author lich
 * @date 2024/3/21
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> cnt = createCounter(t);
        Map<Character, Integer> collected = new HashMap<>();
        Set<Character> allChars = new HashSet<>(cnt.keySet());

        int i = 0, j = 0;

        String min = "";

        while (j <= s.length()) {
            if (cnt.isEmpty()) {
                Map<Character, Integer> cnt2 = createCounter(t);
                while (i < j) {
                    char c = s.charAt(i);
                    if (collected.containsKey(c)) {
                        int cn = collected.get(c);
                        removeFrom(collected, c);
                        int diff = cn - cnt2.get(c);
                        if (diff == 0) { // 不再满足一个完整的t
                            if (min.length() == 0 || j - i < min.length()) {
                                min = s.substring(i, j);
                            }
                            cnt.put(c, 1);
                            i++;
                            break;
                        }
                    }
                    i++;
                }
            }
            if (j == s.length()) {
                break;
            }
            if (allChars.contains(s.charAt(j))) {
                collected.put(s.charAt(j), collected.getOrDefault(s.charAt(j), 0) + 1);
            }
            removeFrom(cnt, s.charAt(j));
            j++;
        }
        return min;
    }

    private boolean removeFrom(Map<Character, Integer> cnt, char c) {
        if (cnt.containsKey(c)) {
            int n = cnt.get(c);
            n--;
            if (n == 0) {
                cnt.remove(c);
                return true;
            } else {
                cnt.put(c, n);
            }
        }
        return true;
    }

    private Map<Character, Integer> createCounter(String t) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            cnt.put(t.charAt(i), cnt.getOrDefault(t.charAt(i), 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        MinWindow m = new MinWindow();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(m.minWindow(s, t));
    }
}
