/**
 * @author : dx
 * @date : 2018/11/15
 * Description :
 */
public class 尾部的零 {
    /**
     * 描述
     * 设计一个算法，计算出n阶乘中尾部零的个数
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 11! = 39916800，因此应该返回 2
     * <p>
     * 挑战
     * O(logN)的时间复杂度
     * <p>
     * tag:数学
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long sum = 0;
        while (n >= 5) {
            n = n / 5;
            sum += n;
        }
        return sum;
    }
}
