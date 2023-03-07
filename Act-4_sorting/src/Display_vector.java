public class Display_vector {
  public static void main(String[] args) {
    int[] numbers = {20, 25, 75, 30, 100};
    int[] vector = numbers.clone();

    System.out.print("Vector: [");
    for (int i = 0; i < vector.length; i++) {
      System.out.print(vector[i]);
      System.out.print(i < vector.length - 1 ? ", " : "");
    }
    System.out.println("]");
  }
}
