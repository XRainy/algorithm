/**
 * @author : dx
 * @date : 2019/11/15
 * Description :
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 *
 * 示例 :
 * 给定二叉树
 *
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode543二叉树的直径 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = depth(root.left) + depth(root.right);
        result = Math.max(diameterOfBinaryTree(root.left), result);
        result = Math.max(diameterOfBinaryTree(root.right), result);
        return result;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        if (root.left != null) {
            depth = 1 + depth(root.left);
        }
        if (root.right != null) {
            depth = Math.max(1 + depth(root.right), depth);
        }
        return depth;
    }

    int ans;
    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth1(root);
        return ans - 1;
    }
    public int depth1(TreeNode node) {
        if (node == null) return 0;
        int L = depth1(node.left);
        int R = depth1(node.right);
        ans = Math.max(ans, L+R+1);
        return Math.max(L, R) + 1;
    }

}
