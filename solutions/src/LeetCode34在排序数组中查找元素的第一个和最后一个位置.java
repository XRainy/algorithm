/**
 * @author : dx
 * @date : 2019/12/21
 * Description :
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode34在排序数组中查找元素的第一个和最后一个位置 {
    int start = -1;
    int end = -1;

    public int[] searchRange(int[] nums, int target) {
        searchRange(nums, 0, nums.length - 1, target);
        return new int[]{start, end};
    }

    public void searchRange(int[] nums, int left, int right, int target) {
        if (right < left) {
            return;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            searchRange(nums, left, mid - 1, target);
        }
        if (nums[mid] < target) {
            searchRange(nums, mid + 1, right, target);
        }
        if (nums[mid] == target) {
            if (start == -1) {
                start = mid;
            }
            start = Math.min(start, mid);
            end = Math.max(end, mid);
            searchRange(nums, left, mid - 1, target);
            searchRange(nums, mid + 1, right, target);
        }
    }
}
