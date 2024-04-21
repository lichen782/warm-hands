package cn.lich.itv.one50;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author lich
 * @date 2024/1/17
 */
public class EvalRPN {

    private static Set<String> operators = new HashSet() {{
        add("+");
        add("-");
        add("*");
        add("/");
    }};

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        Arrays.stream(tokens)
                .forEach(token -> {
                    if (operators.contains(token) && stack.size() >= 2) {
                        Integer b = stack.pop();
                        Integer a = stack.pop();
                        stack.push(compute(a, b, token));
                    } else {
                        stack.push(Integer.valueOf(token));
                    }
                });

        return stack.peek();
    }

    private int compute(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("Invalid operators");
        }
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        String[][] tokenss = {
                {"2","1","+","3","*"}, // 9
                {"4","13","5","/","+"},// 6
                {"10","6","9","3","+","-11","*","/","*","17","+","5","+"}, //22
        };
        for (String[] token: tokenss) {
            System.out.println(evalRPN.evalRPN(token));
        }
    }
}
