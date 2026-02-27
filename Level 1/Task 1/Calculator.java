public class Calculator{

    public static String calculate(int operator, double firstNumber, double secondNumber){
        if (secondNumber == 0 && operator == 4)
            return "You cannot divide on Zero '0'";

        return "Result is: " + switch (operator) {
            case 1 -> String.valueOf(firstNumber + secondNumber);
            case 2 -> String.valueOf(firstNumber - secondNumber);
            case 3 -> String.valueOf(firstNumber * secondNumber);
            case 4 -> String.valueOf(firstNumber / secondNumber);
            default -> "Invalid Operator";
        };
    }
}