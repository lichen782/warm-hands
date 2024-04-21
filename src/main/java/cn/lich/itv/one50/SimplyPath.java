package cn.lich.itv.one50;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * @author lich
 * @date 2024/1/17
 */
public class SimplyPath {

    public String simplifyPath(String path) {
        List<String> folders = Arrays.stream(path.split("/"))
                .filter(s -> s.length() > 0 && !s.equals("."))
                .collect(Collectors.toList());

        Stack<String> stack = new Stack<>();
        for (String f: folders) {
            if (f.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else {
                if (!f.equals("..")) {
                    stack.push(f);
                }
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        SimplyPath sp = new SimplyPath();
        String[] cases = {
                "/home/", "/../", "/home//foo/", "/a/./b/../../c/"
        };
        for (String cse: cases) {
            System.out.println(cse + ": " + sp.simplifyPath(cse));
        }
    }
}
