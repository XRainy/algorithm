/**
 * @author : dx
 * @date : 2019/5/31
 * Description :
 * 描述
 * 中文
 * English
 * 给定一个正整数，输出它的补数。补数是将原先数字的二进制表示按位取反，再换回十进制后得到的新数。
 *
 * 给定的整数保证在32位有符号整数的范围内。
 * 假设一个正整数的二进制表示不包含前导零。
 * 您在真实的面试中是否遇到过这个题？
 * 样例
 * 样例1：
 *
 * 输入：5
 * 输出：2
 * 说明：5的二进制表示为101（不包含前导零），它的补数为010，因此你需要输出2。
 * 样例2：
 *
 * 输入：1
 * 输出：0
 * 说明：1的二进制表示为1（不包含前导零），它的补数为0，因此你需要输出0。
 */

public class 补数 {
    public static int findComplement(int num) {
        int res=0;
        int x=1;
        for(int i=0;i<32;i++){
            if((num&1)==0)
                res+=x;
            x=x*2;
            if(num==1)
                break;
            num=num>>1;
        }
        return res;
    }

    public static void main(String[] args) {
        findComplement(5);
    }
}
