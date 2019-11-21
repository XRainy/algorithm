import java.util.*;

/**
 * @author : dx
 * @date : 2019/11/20
 * Description :
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode39组合总和 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(candidates, target, new ArrayList<>());
        return res;
    }

    public void combinationSum(int[] candidates, int target, List<Integer> tempMemory) {
        for (Integer item : candidates) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(tempMemory);
            if (tempMemory.size() != 0 && tempMemory.get(tempMemory.size() - 1) < item) {
                return;
            }
            temp.add(item);

            if (target - item == 0) {
                res.add(temp);
                return;
            }
            if (target - item < 0) {
                return;
            }
            combinationSum(candidates, target - item, temp);
            temp.remove(temp.size() - 1);
        }

    }

}
