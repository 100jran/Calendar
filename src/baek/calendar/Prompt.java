package baek.calendar;

import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

	public void printMenu() {

		System.out.println("# a = 일정등록");
		System.out.println("# b = 일정검색");
		System.out.println("# c = 달력보기");
		System.out.println("# d = 도움말");
		System.out.println("# q = 종료");
	}

	public void runPrompt() throws ParseException {

		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		while (true) {

			System.out.println("# 명령 = a, b, c, d, q");

			String cmd = scanner.next();
			if (cmd.equals("a")) {
				cmdRegister(scanner, cal);
			} else if (cmd.equals("b")) {
				cmdSearch(scanner, cal);
			} else if (cmd.equals("c")) {
				cmdCal(scanner, cal);
			} else if (cmd.equals("d")) {
				printMenu();
			} else if (cmd.equals("q")) {
				break;
			}
		}

		System.out.println("종료");
	}

	private void cmdCal(Scanner scan, Calendar cal) {

		int year = 0;
		int month = 0;

		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = scan.nextInt();

		System.out.println("월을 입력하세요.");
		System.out.print("MONTH> ");
		month = scan.nextInt();
		System.out.println();

		if (month > 12 || month < 1) {
			System.out.println("입력오류");
			System.out.println();
			return;
		}

		cal.printCalendar(year, month);
	}

	private void cmdSearch(Scanner scan, Calendar cal) throws ParseException {

		System.out.println("일정검색");

		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = scan.next();
		String plan = cal.searchPlan(date);
		System.out.println(plan);

	}

	private void cmdRegister(Scanner scan, Calendar cal) throws ParseException {

		System.out.println("new-일정등록");

		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = scan.next();
		
		String text = "";
		scan.nextLine();
		System.out.println("일정을 입력 해 주세요.");
		text = scan.nextLine();
		
		cal.registerPlan(date, text);

	}

	public static void main(String[] args) throws ParseException {

		Prompt prt = new Prompt();

		prt.runPrompt();
	}
}
