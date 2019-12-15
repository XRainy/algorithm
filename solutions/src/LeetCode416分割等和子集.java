import java.util.Arrays;

/**
 * @author : dx
 * @date : 2019/12/15
 * Description :给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode416分割等和子集 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        /**
         * 方便剪枝
         */
        Arrays.sort(nums);
        return helper(nums, target, 0, nums.length - 1);
    }

    private boolean helper(int[] nums, int target, int sum, int start) {
        if (sum == target) {
            return true;
        }
        /**
         * 剪枝
         */
        if (sum > target || (start >= 0 && nums[start] > target)) {
            return false;
        }
        for (int i = start; i >= 0; i--) {
            return helper(nums, target, sum + nums[start], start - 1) || helper(nums, target, sum, start - 1);
        }
        return false;
    }


    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public boolean canPartition1(int[] nums) {
        int size = nums.length;

        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if ((s & 1) == 1) {
            return false;
        }

        int target = s / 2;

        boolean[] dp = new boolean[target + 1];

        for (int i = 0; i < dp.length; i++) {
            if (i == nums[0]) {
                dp[i] = true;
                break;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= 0 && j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }

}

