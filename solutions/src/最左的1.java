/**
 * @author : dx
 * @date : 2018/11/30
 * Description :
 */
public class 最左的1 {
    /**
     * 描述
     * 一个二维数组，每一行都只有0和1，前面部分是0，后一部分是1，找到数组里面所有行中最左边的1所在的列数。
     * <p>
     * 数组的行数，列数不超过1000
     * 为了约束时间复杂度，你的程序将会运行50000次
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 给出 arr = [[0,0,0,1],[1,1,1,1]], 返回 0。
     * <p>
     * 解释：
     * arr[1][0]为所有行中最左边的1，其所在的列为0。
     * 给出 arr = [[0,0,0,1],[0,1,1,1]], 返回 1。
     * <p>
     * 解释：
     * arr[1][1]为所有行中最左边的1，其所在的列为1。
     */

    public int getColumn(int[][] arr) {
        // Write your code here
        int n = arr.length;
        int m = arr[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if (arr[0][i] == 1) {
                ans = i;
                break;
            }
        }
        for (int i = 1; i < n; i++) {
            if (arr[i][ans] == 0) {
                continue;
            }
            while (ans > 0 && arr[i][ans - 1] == 1) {
                ans--;
            }
        }
        return ans;
    }
}
