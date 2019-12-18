/**
 * @author : dx
 * @date : 2019/12/18
 * Description :
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 * <p>
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * <p>
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 * <p>
 * 一共有5种方法让最终目标和为3。
 * 注意:
 * <p>
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode494目标和 {
    /**
     * 递归遍历
     */
    int res;

    public int findTargetSumWays(int[] nums, int S) {
        findTargetSumWays(nums, 0, S);
        return res;
    }

    public void findTargetSumWays(int[] nums, int index, int S) {
        if (index == nums.length) {
            if (S == 0) {
                res++;
            }
            return;
        }
        findTargetSumWays(nums, index + 1, S - nums[index]);
        findTargetSumWays(nums, index + 1, S + nums[index]);
    }

    /**
     * 动态规划
     * 这道题也是一个常见的背包问题，我们可以用类似求解背包问题的方法来求出可能的方法数。
     * <p>
     * 我们用 dp[i][j] 表示用数组中的前 i 个元素，组成和为 j 的方案数。考虑第 i 个数 nums[i]，它可以被添加 + 或 -，因此状态转移方程如下：
     * <p>
     * dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
     * 也可以写成递推的形式：
     * <p>
     * dp[i][j + nums[i]] += dp[i - 1][j]
     * dp[i][j - nums[i]] += dp[i - 1][j]
     * 由于数组中所有数的和不超过 1000，那么 j 的最小值可以达到 -1000。在很多语言中，是不允许数组的下标为负数的，因此我们需要给 dp[i][j] 的第二维预先增加 1000，即：
     * <p>
     * dp[i][j + nums[i] + 1000] += dp[i - 1][j + 1000]
     * dp[i][j - nums[i] + 1000] += dp[i - 1][j + 1000]
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/target-sum/solution/mu-biao-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findTargetSumWays1(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[sum + 1000] > 0) {
                    next[sum + nums[i] + 1000] += dp[sum + 1000];
                    next[sum - nums[i] + 1000] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return S > 1000 ? 0 : dp[S + 1000];
    }


}
