public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    // -------------- Insert ---------------- //

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node current, int data) {

        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        }

        else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        }
        
        return current;
    }

    // -------------- Search ---------------- //
    
    public boolean search(int data){
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node current, int data) {

        if (root == null) return false;
        if (data == root.data) return true;
        if (data < current.data) return searchRecursive(current.left, data);
        else return searchRecursive(current.right, data);

    }

    // -------------- Remove ---------------- //

    public void remove(int data){
        root = removeRecursive(root, data);
    }

    public Node removeRecursive(Node current, int data){

        if (current == null)
            return null;

        if (data > current.data) {
            current.right = removeRecursive(current.right, data);
            return current;
        }

        if (data < current.data) {
            current.left = removeRecursive(current.left, data);
            return current;
        }

        if (current.left == null && current.right == null) {
            return null;
        }

        if (current.left == null) {
            return current.right;
        }

        if (current.right == null) {
            return current.left;
        }

        int smallestValue = findMin(current.right);
        current.data = smallestValue;
        current.right = removeRecursive(current.right, smallestValue);

        return current;
    }

    // -------------- TRAVERSAL ---------------- //

    public void inorder() {
        System.out.print("Inorder: ");
        inorderRecursive(root);
        System.out.println();
    }

    private void inorderRecursive(Node node) {
        if (node != null) {
            inorderRecursive(node.left);
            System.out.print(node.data + " ");
            inorderRecursive(node.right);
        }
    }

    public void preorder() {
        System.out.print("Preorder: ");
        preorderRecursive(root);
        System.out.println();
    }

    private void preorderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRecursive(node.left);
            preorderRecursive(node.right);
        }
    }

    public void postorder() {
        System.out.print("Postorder: ");
        postorderRecursive(root);
        System.out.println();
    }

    private void postorderRecursive(Node node) {
        if (node != null) {
            postorderRecursive(node.left);
            postorderRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    // -------------- Helper Method ---------------- //

    private int findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

}