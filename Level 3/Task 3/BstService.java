import java.util.Scanner;

public class BstService {

    BinarySearchTree bst = new BinarySearchTree();

    public void insert(Scanner scanner){
        System.out.print("Enter the value to insert: ");
        int data = scanner.nextInt();
        bst.insert(data);
    }

    public void search(Scanner scanner){
        System.out.print("Enter the value to search: ");
        int data = scanner.nextInt();
        System.out.println(bst.search(data));
    }

    public void remove(Scanner scanner){
        System.out.print("Enter the value to remove: ");
        int data = scanner.nextInt();
        bst.remove(data);
    }

    public void traversal(Scanner scanner){
        System.out.printf("1. inorder \n2. preorder \n3. postorder\n");
        System.out.print("Choose order type: ");
        try {
            int order = scanner.nextInt();
            switch (order){
                case 1: bst.inorder(); break;
                case 2: bst.preorder(); break;
                case 3: bst.postorder(); break;
                default: System.out.println("Invalid Value!"); break;
            }
        } catch (Exception e) {
            System.out.println("Invalid Input!");
        }

    }

}
