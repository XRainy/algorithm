/**
 * @author : dx
 * @date : 2019/11/14
 * Description :
 */
public class LeedCode53最大子序和 {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int temp = 0;
        for (int num : nums) {
            temp += num;
            result = Math.max(result, temp);
            if (temp < 0) {
                temp = 0;
            }
        }
        return result;
    }
}
