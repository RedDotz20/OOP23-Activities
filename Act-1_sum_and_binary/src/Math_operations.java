// Code by Carlos Tabangay - BSCS-2B
import java.util.Scanner;
public class Math_operations {
    public static void operations(int firstNum, int secondNum) {
       int add = firstNum + secondNum,
               subtract =  firstNum - secondNum,
               multiply = firstNum * secondNum,
               divide = firstNum / secondNum,
               modulo = firstNum % secondNum;

       System.out.println(
               firstNum + " + " + secondNum + " = " + add       +'\n'+
               firstNum + " - " + secondNum + " = " + subtract  +'\n'+
               firstNum + " * " + secondNum + " = " + multiply  +'\n'+
               firstNum + " / " + secondNum + " = " + divide    +'\n'+
               firstNum + " mod " + secondNum + " = " + modulo
       );
    }

    public static void main(String[] args) {
        Scanner values = new Scanner(System.in);

        // Get First Input Value (integer)
        System.out.print("Enter The First Value: ");
        int firstInputValue = values.nextInt();

        // Get Second Input Value (integer)
        System.out.print("Enter The Second Value: ");
        int secondInputValue = values.nextInt();

        // Display / Print output (operations method)
        operations(firstInputValue, secondInputValue);
    }
}