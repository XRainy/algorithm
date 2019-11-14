/**
 * @author : dx
 * @date : 2019/11/14
 * Description :
 */
public class LeetCode70爬楼梯 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 2;
        for (int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
