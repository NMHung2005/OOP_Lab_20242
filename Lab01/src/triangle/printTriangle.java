package triangle;
import java.util.Scanner;

public class printTriangle {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the height of the triangle (n): ");
	        int n = scanner.nextInt();

	        for (int i = 1; i <= n; i++) {
	            // In khoảng trắng phía trước
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print(" ");
	            }
	            for (int j = 1; j <= (2 * i - 1); j++) {
	                System.out.print("*");
	            }
	            System.out.println(); 
	        }
	        scanner.close();
	    }
}
