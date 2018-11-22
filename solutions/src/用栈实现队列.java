import java.util.Stack;

/**
 * @author : dx
 * @date : 2018/11/19
 * Description :
 */
public class 用栈实现队列 {
    /**
     * 描述
     * 正如标题所述，你需要使用两个栈来实现队列的一些操作。
     * <p>
     * 队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。
     * <p>
     * pop和top方法都应该返回第一个元素的值。
     * <p>
     * 您在真实的面试中是否遇到过这个题？
     * 样例
     * 比如push(1), pop(), push(2), push(3), top(), pop()，你应该返回1，2和2
     * <p>
     * 挑战
     * 仅使用两个栈来实现它，不使用任何其他数据结构，push，pop 和 top的复杂度都应该是均摊O(1)的
     * tag:栈，队列
     */

    Stack<Integer> stack1;

    Stack<Integer> stack2;
    public 用栈实现队列(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int element) {
        // write your code here
        stack2.push(element);
    }

    public void convertStack2ToStack1(){
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    public int pop() {
        // write your code here
        if(stack1.isEmpty()){
            convertStack2ToStack1();
        }
        return stack1.pop();
    }

    public int top() {
        if(stack1.isEmpty()){
            convertStack2ToStack1();
        }
        return stack1.peek();
    }
}
