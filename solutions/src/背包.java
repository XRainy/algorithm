/**
 * @author : dx
 * @date : 2019/5/30
 * Description :
 */
public class 背包 {
    /**
     * @param s: The capacity of backpack
     * @param v: The value of goods
     * @param c: The capacity of goods
     * @return: The answer
     */
    //递归
    public long getMaxValue(int s, int[] v, int[] c) {
        return getValue(s, v, c, c.length - 1);
    }

    long getValue(int s, int[] v, int[] c, int index) {
        if (index < 0 || s <= 0) {
            return 0;
        }
        long res = getValue(s, v, c, index - 1);

        if (c[index] <= s) {
            res = Math.max(res, v[index] + getValue(s - c[index], v, c, index - 1));
        }
        return res;
    }

}
