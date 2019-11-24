/**
 * @author : dx
 * @date : 2019/11/24
 * Description :根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode105从前序与中序遍历序列构造二叉树 {
    private int[] preorder;
    private int[] inorder;
    private int count = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return buildTree(0, preorder.length);
    }

    public TreeNode buildTree(int left, int right) {
        if (left == right) {
            return null;
        }
        int rootValue = preorder[count];
        TreeNode root = new TreeNode(rootValue);
        count++;
        int index = findIndex(inorder, rootValue);
        root.left = buildTree(left, index);
        root.right = buildTree(index + 1, right);
        return root;
    }

    private int findIndex(int[] nums, int value) {
        for (int i = 0; i < nums.length; i++) {
            if (value == nums[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 9, 20, 15, 7};
        int[] b = new int[]{9, 3, 15, 20, 7};
        LeetCode105从前序与中序遍历序列构造二叉树 temp = new LeetCode105从前序与中序遍历序列构造二叉树();
        temp.buildTree(a, b);
    }
}

