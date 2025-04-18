package Array;
import java.util.Arrays;
import java.util.Scanner;
public class array {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        
        int[] myArray = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            myArray[i] = scanner.nextInt();
        }

        System.out.println("Original array: " + Arrays.toString(myArray));

        Arrays.sort(myArray);
        System.out.println("Sorted array: " + Arrays.toString(myArray));

        int sum = 0;
        for (int num : myArray) {
            sum += num;
        }
        double average = (double) sum / n;

        System.out.println("Sum of elements: " + sum);
        System.out.println("Average value: " + average);

        scanner.close();
    }
}
