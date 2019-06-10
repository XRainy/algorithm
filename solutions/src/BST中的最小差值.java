import java.util.LinkedList;

/**
 * @author : dx
 * @date : 2019/6/9
 * Description :
 * 给定一个确定根的二叉搜索树，返回树中任意两个不同节点的值的最小差。
 * <p>
 * 样例
 * 样例1:
 * <p>
 * 输入: root = {4,2,6,1,3,#,#}
 * 输出: 1
 * 解释:
 * 请留意，root是一个树节点的结构，而非一个普通数组。
 * <p>
 * 给定的树{4,2,6,1,3,#,#}的样子如下图：
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * 在这棵树中，最小数值差距为 1, 它出现在node 1 与 node 2 之间, 也同时存在 node 3 与 node 2之间
 * 样例2:
 * <p>
 * 输入: root = {5,1,8}
 * 输出: 3
 * 解释:
 * 请留意，root是一个树节点的结构，而非一个普通数组。
 * <p>
 * 给定的树{5,1,8}的样子如下图：
 * <p>
 * 5
 * /   \
 * 1      8
 * <p>
 * 在这棵树中，最小数值差距为 3, 它出现在node 5与node 8之间.
 * 注意事项
 * 1.这棵二叉搜索树的大小在 2 到100之间。
 * 2.这棵二叉搜索树是存在的，每个点的数值是一个整数，而且每个点的数值将会是不同的。
 */
public class BST中的最小差值 {
    public int minDiffInBST(TreeNode root) {
        // Write your code here
        int min = Integer.MAX_VALUE;
        LinkedList<TreeNode> nodes = new LinkedList();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
            min = Math.min(getMin(node), min);
        }
        return min;
    }

    public int getMin(TreeNode node) {
        int min = Integer.MAX_VALUE;
        if (node == null) {
            return min;
        }
        if (node.left != null) {
            min = Math.min(node.val - node.left.val, min);
        }
        if (node.right != null) {
            min = Math.min(node.right.val - node.val, min);
        }
        return min;
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    Integer res = Integer.MAX_VALUE, pre = null;

    public int minDiffInBST1(TreeNode root) {
        // Write your code here
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;
        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return res;
    }

}
