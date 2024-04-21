package cn.lich.itv.one50;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lich
 * @date 2024/1/14
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> matching = new HashMap<>();
        Map<String, Character> revertMatch = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (matching.containsKey(pattern.charAt(i))) {
                String word = matching.get(pattern.charAt(i));
                if (!words[i].equals(word)) {
                    return false;
                }
            } else if (revertMatch.containsKey(words[i])){
                char c = revertMatch.get(words[i]);
                if (c != pattern.charAt(i)) {
                    return false;
                }
            } else {
                matching.put(pattern.charAt(i), words[i]);
                revertMatch.put(words[i], pattern.charAt(i));
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wp = new WordPattern();
        System.out.println(wp.wordPattern("abba", "dog cat cat dog"));
    }
}
