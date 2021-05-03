package baek.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int get_maxDayOfMonth(int month) {
		return maxDayOfMonth[month];
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			int month = scanner.nextInt();

			if (month == -1) {
				break;
			}
			
			if (month > 12) {
				System.out.println();
				continue;
			}

			System.out.printf("%d월은 %d일까지 입니다.\n\n", month, cal.get_maxDayOfMonth(month));
		}
		
		System.out.println("종료");
		scanner.close();
	}
}
