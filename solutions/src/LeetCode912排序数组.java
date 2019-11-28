import java.util.ArrayList;
import java.util.List;

/**
 * @author : dx
 * @date : 2019/11/28
 * Description :
 * 给定一个整数数组 nums，将该数组升序排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：[5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode912排序数组 {
    public List<Integer> sortArray(int[] nums) {
        findPosition(0, nums.length - 1, nums);
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    public int findPosition(int left, int right, int[] nums) {
        if (left >= right) {
            return 0;
        }
        int nextL = left;
        int nextR = right;
        int temp = nums[left];
        while (left < right) {
            while (nums[right] >= temp && left < right) {
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= temp && left < right) {
                left++;
            }
            nums[right] = nums[left];
            if (right == left) {
                nums[right] = temp;
            }
        }
        findPosition(nextL, left - 1, nums);
        findPosition(left + 1, nextR, nums);
        return left;
    }
}
