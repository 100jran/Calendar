package baek.calendar;

import java.util.Scanner;

public class Prompt {

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
			cal.printCalendar(month);
		}
		
		System.out.println("종료");
		scanner.close();
	}
}
