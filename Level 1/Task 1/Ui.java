public class Ui {
    public static void welcomeMessage() {
        System.out.println("""
                    ============================================================
                    Which method do you want to use?
                     1. Addition
                     2. Subtraction
                     3. Multiplication
                     4. Division
                     5. Exit""");
    }

    public static void errorChoice() {
        System.out.println("Choose a number between 1 and 5");
    }

    public static void errorInput(){
        System.out.println("Enter Just Numbers .. Letters are not allowed");
    }
}
