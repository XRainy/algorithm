import java.util.HashMap;
import java.util.Map;

/**
 * @author : dx
 * @date : 2019/12/15
 * Description :
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lru-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode146LRU缓存机制 {

    private Map<Integer, LinkedNode> map;

    private int capacity;

    class LinkedNode {
        LinkedNode pre;
        LinkedNode next;
        Integer key;
        Integer val;

        public LinkedNode(Integer key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    private LinkedNode head;
    private LinkedNode tail;

    public LeetCode146LRU缓存机制(int capacity) {
        this.head = new LinkedNode(null, null);
        this.tail = new LinkedNode(null, null);
        head.next = tail;
        tail.pre = head;
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public Integer get(Integer key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        LinkedNode val = map.get(key);
        remove(val);
        addLinkedNodeToHead(val);
        return val.val;
    }

    public void put(Integer key, Integer value) {
        if (map.containsKey(key)) {
            LinkedNode val = map.get(key);
            val.val = value;
            remove(val);
            addLinkedNodeToHead(val);
            return;
        }
        LinkedNode linkedNode = new LinkedNode(key, value);
        addLinkedNodeToHead(linkedNode);
        map.put(key, linkedNode);
        if (map.size() > capacity) {
            map.remove(tail.pre.key);
            remove(tail.pre);
        }
    }

    private void addLinkedNodeToHead(LinkedNode linkedNode) {
        linkedNode.next = head.next;
        linkedNode.pre = head;
        head.next.pre = linkedNode;
        head.next = linkedNode;
    }

    private void remove(LinkedNode linkedNode) {
        linkedNode.pre.next = linkedNode.next;
        linkedNode.next.pre = linkedNode.pre;
    }

}
