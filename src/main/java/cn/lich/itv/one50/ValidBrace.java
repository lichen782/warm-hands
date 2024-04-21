package cn.lich.itv.one50;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 * @author lich
 * @date 2024/1/17
 */
public class ValidBrace {


    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char nxt = stack.pop();
                    if (nxt != pairOf(c)) {
                        return false;
                    }
                    break;
                default:
                    //do nothing
                    break;
            }
        }
        return stack.isEmpty();
    }
    private char pairOf(char c) {
        switch (c) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
            default:
                return 'x';
        }
    }

    public static void main(String[] args) {
        ValidBrace v = new ValidBrace();
        System.out.println(v.isValid("]"));
    }
}
