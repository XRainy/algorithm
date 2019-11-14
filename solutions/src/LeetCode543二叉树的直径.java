/**
 * @author : dx
 * @date : 2019/11/15
 * Description :
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
