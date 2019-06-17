import java.util.*;

/**
 * @author : dx
 * @date : 2019/6/16
 * Description :
 */
public class 二叉树的遍历 {

    List<Integer> result = new ArrayList<>();

    //前序遍历递归
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        if (root != null) {
            result.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return result;
    }

    //前序遍历非递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }

    //中序遍历递归
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        if (root != null) {
            inorderTraversal(root.left);
            result.add(root.val);
            inorderTraversal(root.right);
        }
        return result;
    }


    //中序遍历非递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            root = treeNode.right;
        }
        return result;
    }

    //后序遍历递归
    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            result.add(root.val);
        }
        return result;
    }

    //层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> integers = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                integers.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            lists.add(integers);
        }
        return lists;
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
