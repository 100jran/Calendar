package baek.calendar;

import java.util.Scanner;

public class Prompt {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {
			
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			int year = scanner.nextInt();
			
			if (year == -1) {
				break;
			}

			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			int month = scanner.nextInt();
			
			if (month > 12) {
				System.out.println();
				continue;
			}
			cal.printCalendar(year, month);
		}
		
		System.out.println("종료");
		scanner.close();
	}
}
