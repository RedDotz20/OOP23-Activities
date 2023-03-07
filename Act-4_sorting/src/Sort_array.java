import java.util.Arrays;
public class Sort_array {
  public static void main(String[] args) {
    char[] ch = {'D', 'Z', 'H', 'Y', 'X', 'V', 'W'};
    System.out.println("Before sorting: " + Arrays.toString(ch));
    bubbleSort(ch);
    System.out.println("After sorting: " + Arrays.toString(ch));
  }

  public static void bubbleSort(char[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          char temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }
}