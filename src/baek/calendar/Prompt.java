package baek.calendar;

import java.util.Scanner;

public class Prompt {

	public void runPrompt() {
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		
		int year	= 0;
		int month	= 0;

		while (true) {
			
			System.out.println("년도를 입력하세요.(EXIT : -1)");
			System.out.print("YEAR> ");
			year = scanner.nextInt();
			
			if (year == -1) {
				break;
			}

			System.out.println("월을 입력하세요.");
			System.out.print("MONTH> ");
			month = scanner.nextInt();
			System.out.println();
			
			if (month > 12 || month < 1) {
				System.out.println("입력오류");
				System.out.println();
				continue;
			}
			
			cal.printCalendar(year, month);
		}
		
		System.out.println("종료");
		scanner.close();
	}
	
	public static void main(String[] args) {
		
		Prompt prt = new Prompt();
		
		prt.runPrompt();
	}
}
