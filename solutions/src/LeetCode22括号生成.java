import java.util.ArrayList;
import java.util.List;

/**
 * @author : dx
 * @date : 2019/11/19
 * Description :
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode22括号生成 {
    public List<String> generateParenthesis(int n) {
        dfs(0, 0, "", n);
        return res;
    }

    List<String> res = new ArrayList<String>();

    //递归函数
    void dfs(int left, int right, String tmp, int n) {
        //递归函数的终止条件
        if (left == n && right == n) {
            res.add(tmp);
            return;
        }
        //注意左括号的数量要小于参数n，即输入的n为3时
        //最多只能生成3个左括号
        if (left < n) {
            dfs(left + 1, right, tmp + "(", n);
        }
        //右括号的数量也要小于n，左括号的数量要 大于 右括号数量
        //因为 ((( 是合法的(假设程序还没处理完)
        //而),)),)))都是不合法的
        if (left > right && right < n) {
            dfs(left, right + 1, tmp + ")", n);
        }
    }

}
