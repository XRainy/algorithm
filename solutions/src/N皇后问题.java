import java.util.ArrayList;
import java.util.List;

/**
 * @author : dx
 * @date : 2018/11/18
 * Description :
 */
public class N皇后问题 {
    /**
     * 描述
     * n皇后问题是将n个皇后放置在n*n的棋盘上，皇后彼此之间不能相互攻击。
     * <p>
     * 给定一个整数n，返回所有不同的n皇后问题的解决方案。
     * <p>
     * 每个解决方案包含一个明确的n皇后放置布局，其中“Q”和“.”分别表示一个女王和一个空位置。
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 对于4皇后问题存在两种解决的方案：
     * <p>
     * [
     * <p>
     * [".Q..", // Solution 1
     * <p>
     * "...Q",
     * <p>
     * "Q...",
     * <p>
     * "..Q."],
     * <p>
     * ["..Q.", // Solution 2
     * <p>
     * "Q...",
     * <p>
     * "...Q",
     * <p>
     * ".Q.."]
     * <p>
     * ]
     * <p>
     * 挑战
     * 你能否不使用递归完成？
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> resultList = new ArrayList<>();
        if(n<4){
            return resultList;
        }



        return resultList;
    }

    public List<List<String>> recursive(List<List<String>> container,List<String> result,int depth,int n){
        for(int i=0;i<n;i++){
            if(check()){

            }
        }
        return container;
    }

    public Boolean check(){
        return true;
    }
}
