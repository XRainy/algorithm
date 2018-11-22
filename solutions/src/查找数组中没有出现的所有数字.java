import java.util.ArrayList;
import java.util.List;

/**
 * @author : dx
 * @date : 2018/11/21
 * Description :
 */
public class 查找数组中没有出现的所有数字 {
    /**
     * 描述
     * 给定一个整数数组，其中1 ≤ a[i] ≤ n (n =数组的大小)，一些元素出现两次，其他元素出现一次。
     * <p>
     * 找到 [1,n] 中所有没有出现在此数组中的元素。
     * <p>
     * 你可以在没有额外空间和O(n)运行时的情况下完成吗？ 您可以认为返回的列表不计为额外空间。
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * <p>
     * 输出:
     * [5,6]
     * 思路：在数组中下标从0开始，本题下标范围为0-7，而数组元素的值范围为1-8，所以想着如果能把数组元素的值与下标联系起来。通过遍历数组，将每个数组元素设为负值，在遍历的整个过程中，如果有重复元素的话，那么数组肯定有正值，而正值的下标加1就是所没有出现的数字。
     */

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // write your code here

        List<Integer> result = new ArrayList<>();
        if (null == nums || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])- 1] = -Math.abs(nums[Math.abs(nums[i])- 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 2, 5, 10, 9, 1, 1, 4, 3, 7};
        findDisappearedNumbers(a).forEach(integer -> System.out.println(integer));
    }
}
