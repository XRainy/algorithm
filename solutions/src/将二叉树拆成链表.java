/**
 * @author : dx
 * @date : 2019/6/16
 * Description :
 */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 * public int val;
 * public TreeNode left, right;
 * public TreeNode(int val) {
 * this.val = val;
 * this.left = this.right = null;
 * }
 * }
 * <p>
 * 将一棵二叉树按照前序遍历拆解成为一个 假链表。所谓的假链表是说，用二叉树的 right 指针，来表示链表中的 next 指针。
 * <p>
 * 样例
 * 样例 1：
 * <p>
 * 输入：{1,2,5,3,4,#,6}
 * 输出：{1,#,2,#,3,#,4,#,5,#,6}
 * 解释：
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
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
 * 样例 2：
 * <p>
 * 输入：{1}
 * 输出：{1}
 * 解释：
 * 1
 * 1
 * 挑战
 * 不使用额外的空间耗费。
 * <p>
 * 注意事项
 * 不要忘记将左儿子标记为 null，否则你可能会得到空间溢出或是时间溢出。
 */

public class 将二叉树拆成链表 {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        // write your code here
        search(root);
    }

    public TreeNode search(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }
        TreeNode left = search(root.left);
        TreeNode right = search(root.right);
        root.left = null;
        if (left != null) {
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        } else {
            root.right = right;
        }
        return root;
    }

    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        // connect leftLast to root.right
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightLast != null) {
            return rightLast;
        }

        if (leftLast != null) {
            return leftLast;
        }

        return root;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

}
