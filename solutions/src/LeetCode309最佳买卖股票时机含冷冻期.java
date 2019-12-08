/**
 * @author : dx
 * @date : 2019/12/7
 * Description :给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode309最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int pre = 0;
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            pre = maxProfit(prices, 0, i);
            if (prices[i + 2] < prices[i]) {

            }
        }
        return dp[prices.length];
    }

    public int maxProfit(int[] prices, int start, int end) {
        int res = 0;
        int min = prices[start];
        for (int i = start; i <= end; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}
