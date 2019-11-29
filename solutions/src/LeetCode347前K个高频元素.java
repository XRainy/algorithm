import java.util.*;

/**
 * @author : dx
 * @date : 2019/11/29
 * Description :
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode347前K个高频元素 {
    static class Result implements Comparable {
        int key;
        int value;

        public Result(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            return this.key == ((Result) obj).key;
        }

        @Override
        public int compareTo(Object o) {
            return this.value > ((Result) o).value ? -1 : 1;
        }
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        TreeSet<Result> set = new TreeSet<>();
        map.forEach((key, value) -> {
            Result result = new Result(key, value);
            set.add(result);
        });
        List<Integer> res = new ArrayList<>();
        int i = 0;
        for (Result result : set) {
            res.add(result.key);
            if (i == k - 1) {
                return res;
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2};
        topKFrequent(nums, 2);
    }
}
