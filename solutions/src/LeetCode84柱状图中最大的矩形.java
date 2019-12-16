import java.util.Stack;

/**
 * @author : dx
 * @date : 2019/12/16
 * Description :
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 * <p>
 *  
 * <p>
 * <p>
 * <p>
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode84柱状图中最大的矩形 {
    public int largestRectangleArea1(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minHeight = Math.min(heights[j], minHeight);
                res = Math.max((j - i + 1) * minHeight, res);
            }
        }
        return res;
    }

    /**
     * 分治通过观察，可以发现，最大面积矩形存在于以下几种情况：
     * <p>
     * 确定了最矮柱子以后，矩形的宽尽可能往两边延伸。
     * <p>
     * 在最矮柱子左边的最大面积矩形（子问题）。
     * <p>
     * 在最矮柱子右边的最大面积矩形（子问题）。
     * <p>
     * 举个例子：
     * <p>
     * [6, 4, 5, 2, 4, 3, 9]
     * 这里最矮柱子高度为 2 。以 2 为高的最大子矩阵面积是 2x7=14 。现在，我们考虑上面提到的第二种和第三种情况。我们对高度为 2 柱子的左边和右边采用同样的过程。在 2 的左边， 4 是最小的，形成区域为 4x3=12 。将左边区域再继续分，矩形的面积分别为 6x1=6 和 5x1=5 。同样的，我们可以求出右边区域的面积为 3x3=9, 4x1=4 和 9x1=9 。因此，我们得到最大面积是 16 。具体过程可参考下图：
     * <p>
     * <p>
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhu-zhuang-tu-zhong-zui-da-de-ju-xing-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        return largestRectangleArea(heights, 0, heights.length - 1);
    }

    public int largestRectangleArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int index = start;
        for (int i = start; i <= end; i++) {
            if (heights[index] > heights[i]) {
                index = i;
            }
        }
        return Math.max(Math.max((end - start + 1) * heights[index], largestRectangleArea(heights, start, index - 1)), largestRectangleArea(heights, index + 1, end));
    }

    public int largestRectangleArea2(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxarea = Math.max(maxarea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxarea;
    }

}
