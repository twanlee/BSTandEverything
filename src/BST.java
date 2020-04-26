public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BST() {
    }

    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }
@Override
public boolean insert(E e) {
    if (root == null)
        root = createNewNode(e);
    else {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else
                return false;
        }
        if (e.compareTo(parent.element) < 0)
            parent.left = createNewNode(e);
        else
            parent.right = createNewNode(e);
    }
    size++;
    return true;
}

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }
    @Override
    public int getSize(){
        return size;
    }
    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }
    public Boolean search(E data){
        TreeNode<E> current = root;
        if (root==null) return false;
        if(data.compareTo(root.element)==0) return true;
        else {
            while (current != null) {
                if (data.compareTo(current.element) > 0) {
                    current = current.right;
                    if(current.element.compareTo(data)==0) return true;
                }else if(data.compareTo(current.element)<0){
                    current=current.left;
                    if(current.element.compareTo(data)==0)return true;
                }
            }
        }return false;
    }
    public E findTheMostOfLeft(TreeNode<E> root){
        while (root.left != null){
            root = root.left;
        }
        return root.element;
    }

    public TreeNode<E> deleteRec(TreeNode<E> root, E data){
        if( root == null)
            return null;
        if( data.compareTo(root.element)<0){
            root.left = root;
        } else if(data.compareTo(root.element)>0)
            root.right = root;
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.element = findTheMostOfLeft(root.right);
            root.right = deleteRec(root.right, root.element);
        }
        return root;
    }
    public void delete(E data){
        root= (TreeNode<E>) deleteRec(root,data);
    }
    public void postorder(TreeNode<E> root){
            if(root==null) return;
            postorder(root.left);
            postorder(root.right);
        System.out.println(root.element + " ");
    }
    public void preorder(TreeNode<E> root){
        if(root==null){
            return;
        }
        System.out.println(root.element+ " ");
        preorder(root.left);
        preorder(root.right);
    }
    public void printPostorder(){
        preorder(root);
    }public void printPreorder(){
        preorder(root);
    }

}
