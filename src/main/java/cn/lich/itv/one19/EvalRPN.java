package cn.lich.itv.one19;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 根据 逆波兰表示法，求该后缀表达式的计算结果。
 *
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 *
 *
 *
 * 说明：
 *
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *
 *
 * 示例 1：
 *
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 *
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * @author lich
 * @date 2024/3/31
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String op = tokens[i];
            switch (op) {
                case "+":
                case "-":
                case "*":
                case "/":
                    int op1 = stack.pop();
                    int op2 = stack.pop();
                    stack.push(compute(op2, op1, op));
                    break;
                default:
                    stack.push(Integer.valueOf(op));
                    break;
            }
        }
        return stack.peek();
    }

    private int compute(int op1, int op2, String operator) {
        switch (operator) {
            case "/":
                return op1 / op2;
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            default:
                throw new RuntimeException("invalid operator");
        }
    }

    public static void main(String[] args) {
        EvalRPN e = new EvalRPN();
        String[] tokens = {
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        };
        System.out.println(e.evalRPN(tokens));
    }
}
