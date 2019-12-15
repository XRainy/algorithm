import java.util.ArrayList;
import java.util.List;

/**
 * @author : dx
 * @date : 2019/12/15
 * Description :
 * 删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。
 *
 * 说明: 输入可能包含了除 ( 和 ) 以外的字符。
 *
 * 示例 1:
 *
 * 输入: "()())()"
 * 输出: ["()()()", "(())()"]
 * 示例 2:
 *
 * 输入: "(a)())()"
 * 输出: ["(a)()()", "(a())()"]
 * 示例 3:
 *
 * 输入: ")("
 * 输出: [""]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-invalid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
// TODO: 2019/12/15  
public class LeetCode301删除无效的括号 {
    public List<String> removeInvalidParentheses(String s) {
        int leftParentheses = 0;
        int rightParentheses = 0;
        char[] str = s.toCharArray();
        for (char c : str) {
            if (c == '(') {
                leftParentheses += 1;
            } else if (c == ')') {
                if (leftParentheses > 0) {
                    leftParentheses -= 1;
                } else {
                    rightParentheses += 1;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        dfs(s, leftParentheses, rightParentheses, new StringBuilder(s), 0, ans);
        return ans;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count += 1;
            }
            if (c == ')') {
                count -= 1;
            }
            if (count < 0) {
                return false;
            }
        }
        return count == 0;
    }

    private void dfs(String s, int l, int r, StringBuilder sb, int start, List<String> ans) {
        if (l == 0 && r == 0 && isValid(sb.toString())) {
            ans.add(sb.toString());
            return;
        }

        for (int i = start; i < s.length(); i += 1) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                if (r > 0 && s.charAt(i) == ')') {
                    dfs(sb.toString(), l, r - 1, sb, i, ans);
                } else if (l > 0 && s.charAt(i) == '(') {
                    dfs(sb.toString(), l - 1, r, sb, i, ans);
                }
            }
        }
    }
    
}
