/**
 * @author : dx
 * @date : 2019/11/28
 * Description :
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * <p>
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        return getResult(nums, 0, nums.length - 1, k);
    }

    public int getResult(int[] arr, int left, int right, int n) {
        int pos = findPosition(arr, left, right);
        if ((n - 1) == pos) {
            return arr[pos];
        }else if((n - 1) < pos){
            return getResult(arr,left,pos-1,n);
        }else {
            return getResult(arr,pos+1,right,n);
        }
    }

    public int findPosition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (arr[right] <= temp && left < right) {
                right--;
            }
            arr[left] = arr[right];
            while (arr[left] >= temp && left < right) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

}
