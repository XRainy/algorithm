/**
 * @author : dx
 * @date : 2019/11/21
 * Description :
 * 给定一个二叉树，原地将它展开为链表。
 * <p>
 * 例如，给定二叉树
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * 将其展开为：
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode114二叉树展开为链表 {
    public void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode leftRight = root.left;
                while (leftRight.right != null) {
                    leftRight = leftRight.right;
                }
                leftRight.right = root.right;
                root.right = root.left;
            }
            root.left = null;
            root = root.right;
        }
    }

    private TreeNode pre = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }



}
