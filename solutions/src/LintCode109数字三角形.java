/**
 * @author : dx
 * @date : 2019/12/8
 * Description :
 * 描述
 * 中文
 * English
 * 给定一个数字三角形，找到从顶部到底部的最小路径和。每一步可以移动到下面一行的相邻数字上。
 * <p>
 * 如果你只用额外空间复杂度O(n)的条件下完成可以获得加分，其中n是数字三角形的总行数。
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1
 * <p>
 * 输入下列数字三角形：
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 输出： 11
 * 解释： 从顶到底部的最小路径和为11 ( 2 + 3 + 5 + 1 = 11)。
 * 样例 2
 * <p>
 * 输入下列数字三角形：
 * [
 * [2],
 * [3,2],
 * [6,5,7],
 * [4,4,8,1]
 * ]
 * 输出： 12
 * 解释： 从顶到底部的最小路径和为12 ( 2 + 2 + 7 + 1 = 12)。
 */
public class LintCode109数字三角形 {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                } else {
                    triangle[i][j] = Math.min(triangle[i - 1][j] + triangle[i][j], triangle[i - 1][j - 1] + triangle[i][j]);
                }
                if (i == triangle.length - 1) {
                    min = Math.min(min, triangle[i][j]);
                }
            }
        }
        return min;
    }
}
