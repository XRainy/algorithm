import java.util.Arrays;

/**
 * @author : dx
 * @date : 2019/12/25
 * Description :给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * <p>
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * 注意:
 * <p>
 * 给定数组的长度不会超过50000。
 * 输入数组中的所有数字都在32位整数的表示范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode493翻转对 {
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int n = nums.length;
        return mergeSort(nums, Arrays.copyOf(nums, n), 0, n - 1);
    }

    private static int mergeSort(int[] nums, int[] tmps, int lo, int hi) {
        if (lo >= hi) {
            return 0;
        }
        int mid = (lo + hi) >> 1;
        int lc = mergeSort(tmps, nums, lo, mid);
        int rc = mergeSort(tmps, nums, mid + 1, hi);
        int i = lo, j = mid + 1, cnt = 0;
        while (i <= mid && j <= hi) {
            if (tmps[i] > 2.0 * tmps[j]) {
                cnt += mid - i + 1;
                ++j;
            } else {
                ++i;
            }
        }
        i = lo;
        j = mid + 1;
        int pos = lo;
        while (i <= mid && j <= hi) {
            nums[pos++] = tmps[i] < tmps[j] ? tmps[i++] : tmps[j++];
        }
        while (i <= mid) {
            nums[pos++] = tmps[i++];
        }
        while (j <= hi) {
            nums[pos++] = tmps[j++];
        }
        return lc + rc + cnt;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 4, 3, 2, 1, 3, 6, 7, 1};
        reversePairs(nums);

    }

}
