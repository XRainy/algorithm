import java.util.Stack;

/**
 * @author : dx
 * @date : 2019/11/12
 * Description :
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode155最小栈 {
    Stack<Integer> stackVal = new Stack();
    Stack<Integer> stackMin = new Stack();
    public LeetCode155最小栈() {
        // do intialization if necessary
    }

    public void push(int number) {
        stackVal.push(number);
        if(stackMin.isEmpty() || stackMin.peek() >= number){
            stackMin.push(number);
        }
    }
    public int top() {
        return stackVal.peek();
    }

    public int pop() {
        // write your code here
        if(stackVal.isEmpty()){
            throw new RuntimeException();
        }
        int element = stackVal.pop();
        if(element == stackMin.peek()){
            stackMin.pop();
        }
        return element;
    }


    public int getMin() {
        // write your code here
        if(this.stackVal.isEmpty()){
            throw new RuntimeException();
        }
        return stackMin.peek();
    }
}
