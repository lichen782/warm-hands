package cn.lich.itv.one50;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lich
 * @date 2024/3/5
 */
public class Calculate {

    public int calculate(String s) {
        String[] tokens = tokenize(s);
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (!t.equals(")")) {
                stack.push(t);
                continue;
            }
            List<String> ops = new ArrayList<>();
            while (!stack.isEmpty()) {
                String tk = stack.pop();
                if (tk.equals("(")) {
                    break;
                }
                ops.add(tk);
            }
            if (ops.get(ops.size() - 1).equals("-")) {
                ops.add("0");
            }
            int result = Integer.valueOf(ops.get(ops.size() - 1));
            boolean plus = true;
            for (int j = ops.size() - 2; j >=0 ; j--) {
                if (ops.get(j).equals("+")) {
                    plus = true;
                    continue;
                }
                if (ops.get(j).equals("-")) {
                    plus = false;
                    continue;
                }
                int num = Integer.valueOf(ops.get(j));
                if (plus) {
                    result += num;
                } else {
                    result -= num;
                }
            }
            stack.push(String.valueOf(result));
        }
        return Integer.valueOf(stack.peek());
    }

    private String[] tokenize(String s) {
        s = "(" + s.trim() + ")";
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (isDigital(c)) {
                sb.append(c);
                continue;
            }

            if (c == '(' || c == ')' || isOp(c) || c == ' ') {
                if (sb.length() > 0) {
                    ans.add(sb.toString());
                    sb.delete(0, sb.length());
                }
                if (c != ' ') {
                    ans.add(String.valueOf(c));
                }
            }

        }
        if (sb.length() > 0) {
            ans.add(sb.toString());
        }
        return ans.toArray(new String[ans.size()]);
    }

    private boolean isDigital(char c) {
        return c >= '0' && c <= '9';
    }

    private boolean isOp(char c) {
        return c == '+' || c == '-';
    }

    public static void main(String[] args) {
        Calculate c = new Calculate();
        String s = " -3 + 9";
        String[] tks = c.tokenize(s);
        for (String t: tks) {
            System.out.print(t + " ");
        }
        System.out.println();
        System.out.println(c.calculate(s));
    }

}
