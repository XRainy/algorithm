import java.util.List;

/**
 * @author : dx
 * @date : 2019/12/8
 * Description :
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode120三角形最小路径和 {
    public int minimumTotal1(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row + 1];
        for (int level = row - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i + 1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

    int row;

    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        return helper(0, 0, triangle);
    }

    private int helper(int level, int c, List<List<Integer>> triangle) {
        // System.out.println("helper: level="+ level+ " c=" + c);
        if (level == row - 1) {
            return triangle.get(level).get(c);
        }
        int left = helper(level + 1, c, triangle);
        int right = helper(level + 1, c + 1, triangle);
        return Math.min(left, right) + triangle.get(level).get(c);
    }


}
