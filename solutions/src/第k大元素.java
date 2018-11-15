/**
 * @author : dx
 * @date : 2018/11/15
 * Description :
 */
public class 第k大元素 {
    /**
     * 描述
     * 在数组中找到第k大的元素
     * <p>
     * 你可以交换数组中的元素的位置
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 给出数组 [9,3,2,4,8]，第三大的元素是 4
     * <p>
     * 给出数组 [1,2,3,4,5]，第一大的元素是 5，第二大的元素是 4，第三大的元素是 3，以此类推
     * <p>
     * 挑战
     * 要求时间复杂度为O(n)，空间复杂度为O(1)
     * tag:排序，快速排序
     */

    public int kthLargestElement(int n, int[] nums) {
        return getResult(nums, 0, nums.length - 1, n);
    }

    public int getResult(int[] arr, int left, int right, int n) {

        int pos = findPosition(arr, left, right);
        if ((n - 1) == pos) {
            return arr[pos];
        } else if ((n - 1) < pos) {
            return getResult(arr, left, pos - 1, n);
        } else {
            return getResult(arr, pos + 1, right, n);
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
