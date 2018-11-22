import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : dx
 * @date : 2018/11/21
 * Description :
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 0, 4, 5);
        list = list.stream().filter(item -> item > 2).collect(Collectors.toList());
        list.forEach(integer -> System.out.println(integer));

    }
}
