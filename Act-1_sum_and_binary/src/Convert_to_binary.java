// Code by Carlos Tabangay - BSCS-2B
import java.util.Scanner;
public class Convert_to_binary {
    public static void main(String[] args) {
        Scanner values = new Scanner(System.in);

        // Get First Input Value (integer)
        System.out.print("Enter The First Value: ");
        int firstInputValue = values.nextInt();

        // Get Second Input Value (integer)
        System.out.print("Enter The Second Value: ");
        int secondInputValue = values.nextInt();

        // Convert Result to binary as String
        int intResult = firstInputValue + secondInputValue;
        String binary = Integer.toBinaryString(intResult);
        System.out.println(intResult + " = " + binary);
    }
}
