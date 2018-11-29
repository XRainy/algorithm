import java.util.HashMap;
import java.util.Map;

/**
 * @author : dx
 * @date : 2018/11/29
 * Description :
 */
public class 滑动窗口内唯一元素数量和 {
    /**
     * 描述
     * 给一个数组和一个滑动窗口的大小, 求每一个窗口内唯一元素的个数和
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 给一个数组 nums = [1, 2, 1, 3, 3] 和 k = 3
     * 第一个窗口为 [1, 2, 1], 只有 2 是唯一的, 计数为 1.
     * 第二个窗口为 [2, 1, 3], 所有的元素都是唯一的, 计数为 3.
     * 第三个窗口为 [1, 3, 3], 只有 1 是唯一的, 计数为 1.
     * 总数为 1 + 3 + 1 = 5
     * 返回 5
     */
    public int slidingWindowUniqueElementsSum(int[] nums, int k) {
        // write your code here
        if (nums == null || k <= 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0; // count of unique elems in current window
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) { // Case 1: found a new (unique) key
                map.put(nums[i], 1);
                count++;
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) == 2) { // Case 2: a unique elem is not unique any longer
                    count--;
                }
            }

            if (i >= k - 1) { // Per valid window
                sum += count;

                // Removes current window head for the next window and updates count of unique elems.
                map.put(nums[i + 1 - k], map.get(nums[i + 1 - k]) - 1);
                if (map.get(nums[i + 1 - k]) == 1) { // Case 3: a duplicate elem is now unique
                    count++;
                } else if (map.get(nums[i + 1 - k]) == 0) { // Case 4: the unique elem to be removed
                    map.remove(nums[i + 1 - k]);
                    count--;
                }
            }
        }

        // Corner case: nums.length < k
        if (nums.length < k) {
            return count;
        }

        return sum;
    }

}
