import java.util.Stack;

/**
 * @author : dx
 * @date : 2019/11/12
 * Description :
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
