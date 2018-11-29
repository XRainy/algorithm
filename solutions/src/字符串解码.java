import java.util.Stack;

/**
 * @author : dx
 * @date : 2018/11/27
 * Description :
 */
public class 字符串解码 {
    /**
     * 描述
     * 给出一个表达式 s，此表达式包括数字，字母以及方括号。在方括号前的数字表示方括号内容的重复次数(括号内的内容可以是字符串或另一个表达式)，请将这个表达式展开成一个字符串。
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * S = abc3[a] 返回 abcaaa
     * S = 3[abc] 返回 abcabcabc
     * S = 4[ac]dy 返回 acacacacdy
     * S = 3[2[ad]3[pf]]xyz 返回 adadpfpfpfadadpfpfpfadadpfpfpfxyz
     * <p>
     * 挑战
     * 你可以不通过递归的方式完成展开吗？
     * 标签
     * 递归栈分治法非递归
     */

    public String expressionExpand(String s) {

        Stack<String> stack = new Stack<String>();
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(number + "");
                number = 0;
            } else if (c == ']') {
                String toAdd = popStack(stack);
                int count = Integer.parseInt(stack.pop());
                for (int j = 0; j < count; j++) {
                    stack.push(toAdd);
                }
            } else {
                stack.push(c + "");
            }
        }
        return popStack(stack);
    }

    public String popStack(Stack<String> stack) {
        Stack<String> buffer = new Stack<String>();
        while (!stack.isEmpty() && !Character.isDigit(stack.peek().charAt(0))) {
            buffer.push(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }

        return sb.toString();
    }



}
