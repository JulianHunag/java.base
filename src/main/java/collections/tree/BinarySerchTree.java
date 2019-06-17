package collections.tree;

public class BinarySerchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;

    public BinarySerchTree() {
        root = null;
    }

    public void insert(T x) {
        root = insert(x, root);
    }


    public void printTree() {
        if(isEmpty()){
            System.out.println("empty tree");
        }else{
            printTree(root);
        }
    }

    private void printTree(BinaryNode<T> t) {

        if(t != null){
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }

    }

    public boolean isEmpty() {
        return root == null;
    }


    private BinaryNode<T> insert(T x, BinaryNode<T> t) {

        if (t == null) {
            return new BinaryNode<T>(x, null, null);
        }

        int compareResutl = x.compareTo(t.element);

        if (compareResutl < 0) {
            t.left = insert(x, t.left);
        } else if (compareResutl > 0) {
            t.right = insert(x, t.right);
        } else {
            //do nothing
        }

        return t;


    }


    public static void main(String[] args) {
        BinarySerchTree<Integer> btree = new BinarySerchTree<>();
        btree.insert(4);
        btree.insert(7);
        btree.insert(2);
        btree.insert(6);
        btree.printTree();

    }

    private static class BinaryNode<T> {
        BinaryNode(T theElement) {
            this(theElement, null, null);
        }

        BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }


        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
    }

}
