/**
 * @author : dx
 * @date : 2019/6/22
 * Description :
 * 描述
 * 中文
 * English
 * 给定一个字符串（以字符数组的形式给出）和一个偏移量，根据偏移量原地旋转字符串(从左向右旋转)
 * <p>
 * offset >= 0
 * str的长度 >= 0
 * <p>
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例 1:
 * <p>
 * 输入:  str="abcdefg", offset = 3
 * 输出:  str = "efgabcd"
 * 样例解释:  注意是原地旋转，即str旋转后为"efgabcd"
 * 样例 2:
 * <p>
 * 输入: str="abcdefg", offset = 0
 * 输出: str = "abcdefg"
 * 样例解释: 注意是原地旋转，即str旋转后为"abcdefg"
 * 样例 3:
 * <p>
 * 输入: str="abcdefg", offset = 1
 * 输出: str = "gabcdef"
 * 样例解释: 注意是原地旋转，即str旋转后为"gabcdef"
 * 样例 4:
 * <p>
 * 输入: str="abcdefg", offset =2
 * 输出: str = "fgabcde"
 * 样例解释: 注意是原地旋转，即str旋转后为"fgabcde"
 * 样例 5:
 * <p>
 * 输入: str="abcdefg", offset = 10
 * 输出: str = "efgabcd"
 * 样例解释: 注意是原地旋转，即str旋转后为"efgabcd"
 * 挑战
 * 在数组上原地旋转，使用O(1)的额外空间
 */
public class 旋转字符串 {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0)
            return;

        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    public void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

}
