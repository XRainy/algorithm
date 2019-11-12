import java.util.Stack;

/**
 * @author : dx
 * @date : 2019/11/9
 * Description :
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * <p>
 * 例如：
 * <p>
 * 输入: 二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode538把二叉搜索树转换为累加树 {
    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        convertBST(root.right);
        num = num + root.val;
        root.val = num;
        convertBST(root.left);
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.right;
            }
            temp = stack.pop();
            num = num + temp.val;
            temp.val = num;
            temp = temp.left;
        }
        return root;
    }
}
