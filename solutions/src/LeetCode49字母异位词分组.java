import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : dx
 * @date : 2019/11/29
 * Description :
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode49字母异位词分组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> strMap = help(str);
            if (map.containsKey(strMap)) {
                map.get(strMap).add(str);
            } else {
                ArrayList<String> arrayList = new ArrayList();
                arrayList.add(str);
                map.put(strMap, arrayList);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static Map<Character, Integer> help(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return map;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"};
        groupAnagrams(strs);
    }


}
