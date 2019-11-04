import java.util.ArrayList;
import java.util.List;

/**
 * @author : dx
 * @date : 2019/6/27
 * Description :
 * 给定一个数字列表，返回其所有可能的排列。
 *
 * 你可以假设没有重复数字。
 *
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1：
 *
 * 输入：[1]
 * 输出：
 * [
 *   [1]
 * ]
 * 样例 2：
 *
 * 输入：[1,2,3]
 * 输出：
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 挑战
 * 使用递归和非递归分别解决。
 */
public class 全排列 {
    public static List<List<Integer>> permute(int[] nums) {
        if (null == nums ) {
            return new ArrayList<>();
        }
        if(nums.length == 0){
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> lists= new ArrayList<>();
            lists.add(list);
            return lists;
        }
        List<List<Integer>> result = new ArrayList();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        result.add(list);
        for (int i = 1; i < nums.length; i++) {
            while (result.get(0).size()<=i) {
                List<Integer> temp = result.remove(0);
                for (int j = 0; j <= temp.size(); j++) {
                    List<Integer> temp2 = new ArrayList<>(temp);
                    temp2.add(j,nums[i]);
                    result.add(temp2);
                }

            }
        }
        return result;
    }
}
