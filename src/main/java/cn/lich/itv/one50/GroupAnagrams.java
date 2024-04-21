package cn.lich.itv.one50;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lich
 * @date 2024/1/15
 */
public class GroupAnagrams {

    private static final String SET = "N/A";

    public List<List<String>> groupAnagrams(String[] strs) {
        int[][] counters = new int[strs.length][];
        for (int i = 0; i < strs.length; i++) {
            counters[i] = getCodes(strs[i]);
        }

        List<List<String>> groups = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            List<String> g = new ArrayList<>();
            if (strs[i].equals(SET)) {
                continue;
            }
            g.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (strs[j].equals(SET)) {
                    continue;
                }
                if (equals(counters[i], counters[j])) {
                    g.add(strs[j]);
                    strs[j] = SET;
                }
            }
            groups.add(g);
        }

        return groups;
    }

    private int[] getCodes(String s) {
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
        return counter;
    }

    private boolean equals(int[] counter1, int[] counter2) {
        for (int i = 0; i < counter1.length; i++) {
            if (counter2[i] != counter1[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> l = g.groupAnagrams(strs);
        for (List<String> ll: l) {
            for (String s : ll) {
                System.out.print(s + ", ");
            }
            System.out.println();
        }
    }

}
