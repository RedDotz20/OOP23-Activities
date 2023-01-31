// Code by Carlos Tabangay - BSCS-2B
import java.util.Scanner;
public class Convert_to_binary {
    public static void main(String[] args) {
        Scanner integerValue = new Scanner(System.in);

        // Get Input value
        System.out.print("Enter an Integer value: ");
        int inputValue = integerValue.nextInt();

        // Convert Input Value to binary as String
        String binary = Integer.toBinaryString(inputValue);
        System.out.println("The Binary Representation of " + inputValue + " is " + binary);
    }
}
