// Code by Carlos Tabangay - BSCS-2B
import java.util.Scanner;
record MenuItem(String flavor, double cost) {
}

record Order(MenuItem menuItem, int quantity) {
  public double getSubtotal() {
    return menuItem.cost() * quantity;
  }
}

public class Cafe {
  private static final Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    MenuItem[] cupcakes = {
        new MenuItem("CHOCOLATE", 25.0),
        new MenuItem("RAISINS", 50.0),
        new MenuItem("PINEAPPLE", 40.0),
        new MenuItem("APPLE", 30.0),
        new MenuItem("MANGO", 35.0),
        new MenuItem("BANANA", 45.0)
    };

    MenuItem[] drinks = {
        new MenuItem("SOFT-DRINKS", 25.0),
        new MenuItem("ICED TEA", 50.0),
        new MenuItem("COFFEE", 40.0),
        new MenuItem("APPLE JUICE", 30.0),
        new MenuItem("MANGO JUICE", 35.0),
        new MenuItem("PINEAPPLE JUICE", 45.0)
    };

    double foodTotal = 0.0;
    double drinksTotal = 0.0;

    boolean orderMore = true;
    while (orderMore) {
      System.out.println("\tFLAVORED CUP CAKES ");
      System.out.println("FLAVOR\t\t\tCOST");
      for (int i = 0; i < cupcakes.length; i++) {
        if (i == 0 || i == 2) {
          System.out.println("[" + (i+1) + "]\t" + cupcakes[i].flavor() + "\t" + cupcakes[i].cost());
        } else {
          System.out.println("[" + (i+1) + "]\t" + cupcakes[i].flavor() + "\t\t" + cupcakes[i].cost());
        }
      }

      Order cupcakeOrder = getOrder(cupcakes, "CUP CAKE");
      foodTotal += cupcakeOrder.getSubtotal();

      System.out.println("\tGLASS OF DRINKS ");
      System.out.println("FLAVOR\t\t\t\tCOST");
      for (int i = 0; i < drinks.length; i++) {
        if (i == 2) {
          System.out.println("[" + (i + 1) + "]\t" + drinks[i].flavor() + "\t\t\t" + drinks[i].cost());
        } else if (i == 5) {
          System.out.println("[" + (i + 1) + "]\t" + drinks[i].flavor() + "\t" + drinks[i].cost());
        } else {
          System.out.println("[" + (i + 1) + "]\t" + drinks[i].flavor() + "\t\t" + drinks[i].cost());
        }
      }

      Order drinkOrder = getOrder(drinks, "DRINK");
      drinksTotal += drinkOrder.getSubtotal();

      System.out.print("ANOTHER [Y/N]: ");
      String choice = scanner.nextLine().toUpperCase();
      orderMore = choice.equalsIgnoreCase("y");
    }

    System.out.println("\t\tSUMMARY");
    System.out.println("FOOD\t\t\t" + foodTotal);
    System.out.println("DRINKS\t\t\t" + drinksTotal);
    System.out.println("--------------------------------");
    System.out.println("AMOUNT DUE:\t\t" + (foodTotal + drinksTotal));
  }

  public static Order getOrder(MenuItem[] menu, String item) {
    boolean orderMore = true;
    Order order = null;
    while (orderMore) {
      System.out.print("CHOOSE " + item + ": ");
      int choice;
      if (scanner.hasNextInt()) {
        choice = scanner.nextInt() - 1;
        scanner.nextLine();
      } else {
        scanner.nextLine();
        System.out.println("Invalid input. Please enter a number.");
        continue;
      }

      if (choice < 0 || choice >= menu.length) {
        System.out.println("Invalid choice. Please choose a valid flavor.");
        continue;
      }

      System.out.print("QUANTITY: ");
      int quantity;
      if (scanner.hasNextInt()) {
        quantity = scanner.nextInt();
        scanner.nextLine();
      } else {
        scanner.nextLine();
        System.out.println("Invalid input. Please enter a number.");
        continue;
      }

      order = new Order(menu[choice], quantity);

      System.out.println("SUBTOTAL: " + order.getSubtotal());

      System.out.print("ANOTHER [Y/N]: ");
      String more = scanner.nextLine().toUpperCase();
      orderMore = more.equalsIgnoreCase("y");
    }
    return order;
  }
}

