public class Test {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        System.out.println("Inorder (sorted): ");
        tree.inorder();
        System.out.println("The number of nodes is: " + tree.getSize());
        System.out.println(tree.search(60));
        tree.printPostorder();
    }
}
