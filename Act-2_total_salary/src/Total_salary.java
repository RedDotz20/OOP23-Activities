// Code by Carlos Tabangay - BSCS-2B
import java.util.Scanner;
public class Total_salary {
  public static int salaryAmount(
      String selectedAmountPerHour,
      int hoursWorkPerDay,
      int daysWorkPerMonth
  ) {
    switch (selectedAmountPerHour.toUpperCase()) {
      case "A" -> { return 100 * hoursWorkPerDay * daysWorkPerMonth; }
      case "B" -> { return 150 * hoursWorkPerDay * daysWorkPerMonth; }
      case "C" -> { return 200 * hoursWorkPerDay * daysWorkPerMonth; }
      default -> {
        System.out.println("Invalid Input");
        return 0;
      }
    }
  }
  public static double calculateTax(int totalSalaryAmount) {
    if (totalSalaryAmount >= 10001 && totalSalaryAmount <= 30000) {
      return totalSalaryAmount * 0.12;
    } else if (totalSalaryAmount >= 30001 && totalSalaryAmount <= 50000) {
      return totalSalaryAmount * 0.15;
    } else if (totalSalaryAmount >= 50001) {
      return totalSalaryAmount * 0.25;
    } else {
      return totalSalaryAmount;
    }
  }
  public static double calculateDeduction(int deduction, double tax) {
    return deduction + tax;
  }
  public static void main(String[] args) {
    System.out.println(
        """
        Choose Amount per Hour
        A. 100.00 PER HOUR
        B. 150.00 PER HOUR
        C. 200.00 PER HOUR"""
    );

    Scanner chooseAmount = new Scanner(System.in);
    System.out.print("Enter Amount: ");
    String selectedAmount = chooseAmount.next();

    Scanner hoursWorkPerDayAmount = new Scanner(System.in);
    System.out.print("Enter Number of Hours work: ");
    int hoursWorkPerDay = hoursWorkPerDayAmount.nextInt();

    Scanner daysWorkPerMonthAmount = new Scanner(System.in);
    System.out.print("Number of Days Taken: ");
    int daysWorkPerMonth = daysWorkPerMonthAmount.nextInt();

    int totalSalary = salaryAmount(selectedAmount,hoursWorkPerDay,daysWorkPerMonth);
    System.out.println("\nTotal Salary: " + totalSalary);
    double totalTax = calculateTax(totalSalary);

    int[] deductionsValue = { 500,300,800 };
    System.out.println(
        """
        
        Choose Deduction
        1. SSS - 500
        2. Phil Health - 300
        3. SSS and Phil Health - 800"""
    );

    Scanner deductionAmount = new Scanner(System.in);
    System.out.print("Enter Deduction: ");
    int deduction = deductionAmount.nextInt();

    System.out.println("\nDeduction: " + deductionsValue[deduction - 1]);
    double totalDeduction = calculateDeduction(deduction, totalTax);
    System.out.println("Total Deduction: " + totalDeduction);
    double netSalary = totalSalary - totalDeduction;
    System.out.println("Net Salary: " + netSalary);
  }
}