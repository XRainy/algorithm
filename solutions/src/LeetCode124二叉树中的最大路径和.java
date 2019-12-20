import java.util.HashMap;
import java.util.Map;

/**
 * @author : dx
 * @date : 2019/12/20
 * Description :给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 * 输入: [1,2,3]
 * <p>
 * 1
 * / \
 * 2   3
 * <p>
 * 输出: 6
 * 示例 2:
 * <p>
 * 输入: [-10,9,20,null,null,15,7]
 * <p>
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * <p>
 * 输出: 42
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode124二叉树中的最大路径和 {
    Map<TreeNode, Integer> map = new HashMap();
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        init(root);
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftRes = 0;
        int rightRes = 0;
        if (root.left != null) {
            leftRes = helper(root.left);
        }
        if (root.right != null) {
            rightRes = helper(root.right);
        }
        int a = Math.max(Math.max(res, root.val), root.val + leftRes);
        int b = Math.max(a, root.val + rightRes);
        res = Math.max(b, root.val + rightRes + leftRes);
        return map.get(root);
    }

    public int init(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int res = Math.max(Math.max(init(root.left) + root.val, root.val), init(root.right) + root.val);
        map.put(root, res);
        return res;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-3);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        LeetCode124二叉树中的最大路径和 leetCode124 = new LeetCode124二叉树中的最大路径和();
        leetCode124.maxPathSum(root);
    }
}
