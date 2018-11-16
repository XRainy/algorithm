import java.util.HashMap;
import java.util.Map;

/**
 * @author : dx
 * @date : 2018/11/16
 * Description :
 */
public class 两数之和 {
    /**
     * 描述
     * 给一个整数数组，找到两个数使得他们的和等于一个给定的数 target。
     * <p>
     * 你需要实现的函数twoSum需要返回这两个数的下标, 并且第一个下标小于第二个下标。注意这里下标的范围是 0 到 n-1。
     * <p>
     * 你可以假设只有一组答案。
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 给出 numbers = [2, 7, 11, 15], target = 9, 返回 [0, 1].
     * <p>
     * 挑战
     * Either of the following solutions are acceptable:
     * <p>
     * O(n) Space, O(nlogn) Time
     * O(n) Space, O(n) Time
     */


    public int[] twoSum(int[] numbers, int target) {
        if (null == numbers || numbers.length <= 1) {
            return null;
        }
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            Integer num = map.get(temp);
            if (null != num) {
                result[0] = i;
                result[1] = num;
                break;
            }
        }
        return result;

    }

    public int[] twoSumSolutionTwo(int[] numbers, int target) {
        if (null == numbers || numbers.length <= 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]), i};
                return result;
            }
            map.put(target - numbers[i], i);
        }
        return new int[0];
    }
}
