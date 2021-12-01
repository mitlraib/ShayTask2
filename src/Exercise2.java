import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter number: ");
            array[i] = scanner.nextInt();
            sum += array[i];
        }

        biggerThanAverage(array, (double) sum / array.length);
    }

    public static void biggerThanAverage(int [] array, double average) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= average) {
                System.out.println(array[i]);
            }
        }
    }
}
