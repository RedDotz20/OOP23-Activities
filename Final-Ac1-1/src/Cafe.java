import java.util.Scanner;
abstract class Menu {
  protected String[] flavor;
  protected double[] cost;
  Menu(String[] flavor, double[] cost) {
    this.flavor = flavor;
    this.cost = cost;
  }
  abstract String getMenuName();
  void displayMenu() {
    System.out.println("\t\t" + getMenuName() + "\nFLAVOR\t\t\t\tCOST");
    for(int i = 0; i < flavor.length; i++) {
      System.out.printf("[%d]\t%-20s\t%.2f\n", i+1, flavor[i], cost[i]);
    }
  }
  double getCost(int choice, int quantity) {
    return cost[choice-1] * quantity;
  }
}

class CupcakeMenu extends Menu {
  CupcakeMenu(String[] flavor, double[] cost) {
    super(flavor, cost);
  }
  @Override
  String getMenuName() {
    return "FLAVORED CUP CAKES";
  }
}
class DrinksMenu extends Menu {
  DrinksMenu(String[] flavor, double[] cost) {
    super(flavor, cost);
  }
  @Override
  String getMenuName() {
    return "GLASS OF DRINKS";
  }
}
public class Cafe {
  public static void main(String[] args) {
    String[] cupcakeFlavor = {"CHOCOLATE", "RAISINS", "PINEAPPLE", "APPLE", "MANGO", "BANANA"};
    double[] cupcakeCost = {25.0, 50.0, 40.0, 30.0, 35.0, 45.0};
    CupcakeMenu cupcakeMenu = new CupcakeMenu(cupcakeFlavor, cupcakeCost);

    String[] drinksFlavor =
        {"SOFTDRINKS", "ICED TEA", "COFFEE", "APPLE JUICE", "MANGO JUICE", "PINEAPPLE JUICE"};
    double[] drinksCost = {25.0, 50.0, 40.0, 30.0, 35.0, 45.0};
    DrinksMenu drinksMenu = new DrinksMenu(drinksFlavor, drinksCost);

    Scanner scanner = new Scanner(System.in);

    double foodTotal = 0.0;
    double drinksTotal = 0.0;

    while (true) {
      cupcakeMenu.displayMenu();
      System.out.print("CHOOSE FLAVOR: ");
      int cupcakeChoice = scanner.nextInt();
      System.out.print("QUANTITY: ");
      int cupcakeQuantity = scanner.nextInt();
      double cupcakeSubtotal = cupcakeMenu.getCost(cupcakeChoice, cupcakeQuantity);
      System.out.printf("SUBTOTAL: %.2f\n", cupcakeSubtotal);
      foodTotal += cupcakeSubtotal;
      System.out.print("ANOTHER [Y/N]: ");
      String anotherOrder = scanner.next();
      if (anotherOrder.equalsIgnoreCase("N")) {
        break;
      }
    }

    while (true) {
      drinksMenu.displayMenu();
      System.out.print("CHOOSE FLAVOR: ");
      int drinksChoice = scanner.nextInt();
      System.out.print("QUANTITY: ");
      int drinksQuantity = scanner.nextInt();
      double drinksSubtotal = drinksMenu.getCost(drinksChoice, drinksQuantity);
      System.out.printf("SUBTOTAL: %.2f\n", drinksSubtotal);
      drinksTotal += drinksSubtotal;
      System.out.print("ANOTHER [Y/N]: ");
      String anotherOrder = scanner.next();
      if (anotherOrder.equalsIgnoreCase("N")) {
        break;
      }
    }

    System.out.printf("""
        \t\tSUMMARY
        FOOD\t\t\t\t%.2f
        DRINKS\t\t\t\t%.2f
        --------------------------------
        AMOUNT DUE:\t\t\t%.2f""", foodTotal, drinksTotal, foodTotal + drinksTotal
    );
  }
}