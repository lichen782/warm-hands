package cn.lich.itv.one50;

/**
 * @author lich
 * @date 2024/1/7
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int minIdx = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < strs[minIdx].length()) {
                minIdx = i;
            }
        }

        int prefixLen = 0;
        while (prefixLen < strs[minIdx].length()) {
            char candidate = strs[minIdx].charAt(prefixLen);
            for (String s: strs) {
                if (s.charAt(prefixLen) != candidate) {
                    return s.substring(0, prefixLen);
                }
            }
            prefixLen++;
        }
        return strs[minIdx].substring(0, prefixLen);
    }

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        String[] strs = {"dog","racecar","car"};
        System.out.println(l.longestCommonPrefix(strs));
    }
}
