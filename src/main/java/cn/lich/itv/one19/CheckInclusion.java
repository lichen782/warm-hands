package cn.lich.itv.one19;

import java.util.*;

/**
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 *
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 *
 * @author lich
 * @date 2024/3/18
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int i = 0, j = 0;
        Map<Character, Integer> m = createMap(s1);
        Set<Character> allChars = new HashSet<>(m.keySet());

        while (j < s2.length()) {
            if (m.isEmpty()) {
                return true;
            }
            if (m.containsKey(s2.charAt(j))) {
                int c = m.get(s2.charAt(j));
                c -= 1;
                if (c > 0) {
                    m.put(s2.charAt(j), c);
                } else {
                    m.remove(s2.charAt(j));
                }
                j++;
                continue;
            }
            if (allChars.contains(s2.charAt(j))){
                while (i < j) {
                    m.put(s2.charAt(i), m.getOrDefault(s2.charAt(i), 0) + 1);
                    i++;
                    if (m.containsKey(s2.charAt(j))) {
                        break;
                    }
                }
                // 一定会出现j所指向的字符
            } else {
                m = createMap(s1);
                j++;
                i = j;
            }

        }
        return m.isEmpty();
    }

    private Map<Character, Integer> createMap(String s1) {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int cnt = m.getOrDefault(s1.charAt(i), 0);
            m.put(s1.charAt(i), cnt + 1);
        }
        return m;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckInclusion c = new CheckInclusion();
        String s1 = "adc", s2 = "dcda";
        System.out.println(c.checkInclusion2(s1, s2));
    }
}
