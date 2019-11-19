/**
 * @author : dx
 * @date : 2019/11/19
 * Description :给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/counting-bits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode338比特位计数 {
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = popCount(i);
        }
        return result;
    }

    public int popCount(int num) {
        int result = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                result++;
            }
            num = num >> 1;
        }
        return result;
    }

    /**
     * 方法二：动态规划 + 最高有效位 【通过】
     * 直觉
     *
     * 利用已有的计数结果来生成新的计数结果。
     *
     * 算法
     *
     * 假设有一个整数：
     *
     * x = (1001011101)_2 = (605)_{10}
     * x=(1001011101)
     * 2
     * ​
     *  =(605)
     * 10
     * ​
     *
     *
     * 我们已经计算了从 00 到 x - 1x−1 的全部结果。
     *
     * 我们知道，xx 与 我们计算过的一个数只有一位之差:
     *
     * x' = (1011101)_2 = (93)_{10}
     * x
     * ′
     *  =(1011101)
     * 2
     * ​
     *  =(93)
     * 10
     * ​
     *
     *
     * 它们只在最高有效位上不同。
     *
     * 让我们以二进制形式检查 [0, 3][0,3] 的范围：
     *
     * (0) = (0)_2
     * (0)=(0)
     * 2
     * ​
     *
     *
     * (1) = (1)_2
     * (1)=(1)
     * 2
     * ​
     *
     *
     * (2) = (10)_2
     * (2)=(10)
     * 2
     * ​
     *
     *
     * (3) = (11)_2
     * (3)=(11)
     * 2
     * ​
     *
     *
     * 可以看出， 2 和 3 的二进制形式可以通过给 0 和 1 的二进制形式在前面加上 1 来得到。因此，它们的 pop count 只相差 1。
     *
     * 类似的，我们可以使用 [0, 3][0,3] 作为蓝本来得到 [4, 7][4,7]。
     *
     * 总之，对于pop count P(x)P(x)，我们有以下的状态转移函数：
     *
     * P(x + b) = P(x) + 1, b = 2^m > x
     * P(x+b)=P(x)+1,b=2
     * m
     *  >x
     *
     * 有了状态转移函数，我们可以利用动态规划从 00 开始生成所有结果。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @return
     */

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        if (num == 0) {
            return result;
        }
        result[1] = 1;
        for (int i = 2; i < result.length; i = i << 1) {
            for (int j = 0, end = i; end < result.length; j++, end++) {
                result[end] = result[j] + 1;
            }
        }
        return result;
    }

    /**
     * 方法三：动态规划 + 最低有效位 【通过】
     * 直觉
     *
     * 只要x'x
     * ′
     *   小于 xx，且它们的 pop count 之间存在函数关系，就可以写出其他的状态转移函数。
     *
     * 算法
     *
     * 遵循上一方法的相同原则，我们还可以通过最低有效位来获得状态转移函数。
     *
     * 观察xx 和 x' = x / 2x
     * ′
     *  =x/2 的关系：
     *
     * x = (1001011101)_2 = (605)_{10}
     * x=(1001011101)
     * 2
     * ​
     *  =(605)
     * 10
     * ​
     *
     *
     * x' = (100101110)_2 = (302)_{10}
     * x
     * ′
     *  =(100101110)
     * 2
     * ​
     *  =(302)
     * 10
     * ​
     *
     *
     * 可以发现 x'x
     * ′
     *   与 xx 只有一位不同，这是因为x'x
     * ′
     *   可以看做 xx 移除最低有效位的结果。
     *
     * 这样，我们就有了下面的状态转移函数：
     *
     * P(x) = P(x / 2) + (x \mod 2)
     * P(x)=P(x/2)+(xmod2)
     *
     * Java
     *
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }

    /**
     * 方法四：动态规划 + 最后设置位【通过】
     * 算法
     *
     * 与上述方法思路相同，我们可以利用最后设置位。
     *
     * 最后设置位是从右到左第一个为1的位。使用 x &= x - 1 将该位设置为0，就可以得到以下状态转移函数：
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param num
     * @return
     */
    public int[] countBits3(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }

}
