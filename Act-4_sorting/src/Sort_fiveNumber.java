import java.util.Scanner;
public class Sort_fiveNumber {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int[] numbers = new int[5];
    System.out.println("Enter five numbers:");
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = input.nextInt();
    }

    System.out.println("Before sorting: ");
    printArray(numbers);

    bubbleSort(numbers, true);
    System.out.println("After sorting in ascending order: ");
    printArray(numbers);

    bubbleSort(numbers, false);
    System.out.println("After sorting in descending order: ");
    printArray(numbers);
  }

  public static void bubbleSort(int[] arr, boolean isAscending) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        boolean shouldSwap =
            isAscending ? (arr[j] > arr[j + 1]) : (arr[j] < arr[j + 1]);
        if (shouldSwap) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void printArray(int[] arr) {
    for (int num : arr) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}