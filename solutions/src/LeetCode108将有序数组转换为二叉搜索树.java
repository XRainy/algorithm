/**
 * @author : dx
 * @date : 2019/11/22
 * Description :
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * <p>
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * <p>
 * 示例:
 * <p>
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode108将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(0, nums.length - 1, nums);
    }

    public TreeNode sortedArrayToBST(int left, int right, int[] nums) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        if (left > right) {
            return null;
        }
        int mid = ((right + left) + 1) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(left, mid - 1, nums);
        treeNode.right = sortedArrayToBST(mid + 1, right, nums);
        return treeNode;
    }
}
