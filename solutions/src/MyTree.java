import java.util.List;

/**
 * @author : dx
 * @date : 2019/3/24
 * Description :
 */
public class MyTree<T> {

    private Node root;

    public class Node{
        T value;
        Node left;
        Node right;

    }

    public MyTree(){}

    public List<T> searchFirst(Node root,List<T> list){

        if(root == null){
            return list;
        }

        list.add(root.value);

        if(root.left != null){
            searchFirst(root.left,list);
        }

        if(root.right != null){
            searchFirst(root.right,list);
        }

        return list;
    }


}
