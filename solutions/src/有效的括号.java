import java.util.*;

/**
 * @author : dx
 * @date : 2019/5/15
 * Description :
 */
public class 有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Set set = new HashSet<>();
        set.addAll(Arrays.asList('(', '{', '['));
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty() || !map.get(s.charAt(i)).equals(stack.pop())) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
