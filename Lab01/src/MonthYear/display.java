package MonthYear;

import java.util.Scanner;

public class display {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String[] fullMonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] shortMonths = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

		int monthNumber = -1;
		while (monthNumber == -1) {
			System.out.print("Enter the month (full name, abbreviation, or number 1-12): ");
			if (scanner.hasNextInt()) {
				int num = scanner.nextInt();
				if (num >= 1 && num <= 12) {
					monthNumber = num;
				}
			} else {
				String monthInput = scanner.next();
				for (int i = 0; i < 12; i++) {
					if (fullMonths[i].equalsIgnoreCase(monthInput) || shortMonths[i].equalsIgnoreCase(monthInput)) {
						monthNumber = i + 1;
						break;
					}
				}
			}

			if (monthNumber == -1) {
				System.out.println("Invalid month! Please enter again.");
			}
		}

		int year = -1;
		while (year < 0) {
			System.out.print("Enter the year (non-negative integer): ");
			if (scanner.hasNextInt()) {
				year = scanner.nextInt();
				if (year < 0) {
					System.out.println("Invalid year! Please enter again.");
				}
			} else {
				System.out.println("Invalid input! Please enter a valid number.");
				scanner.next();
			}
		}

		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

		int days;
		switch (monthNumber) {
		case 2:
			days = isLeapYear ? 29 : 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		default:
			days = 31;
			break;
		}

		System.out.println("Year " + year + ", Month " + fullMonths[monthNumber - 1] + " has " + days + " days.");

		scanner.close();
	}
}
