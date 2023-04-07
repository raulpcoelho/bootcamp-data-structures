import com.types.BST;

public class Main {
    public static void main(String[] args) throws Exception {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        tree.insert(12);
        tree.insert(6);
        tree.insert(20);
        tree.insert(18);

        tree.inOrder();
        System.out.println(tree.size());

        tree.remove(15);
        tree.inOrder();
        System.out.println(tree.size());


    }
}
