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
	
	public int parseDay(String weekday) {
		switch(weekday) {
		case "SU" :
			return 0;
		case "MO" :
			return 1;
		case "TU" :
			return 2;
		case "WE" :
			return 3;
		case "TH" :
			return 4;
		case "FR" :
			return 5;
		case "SA" :
			return 6;
		default :
			return 0;
		}
	}

	public void runPrompt() throws ParseException {

		printMenu();

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();

		boolean isLoop = true;
		while (isLoop) {

			System.out.println("# 명령 = a, b, c, d, q");
	
			String cmd = scanner.next();
			switch(cmd) {
			case "a" :
				cmdRegister(scanner, cal);
				break;
			case "b" :
				cmdSearch(scanner, cal);
				break;
			case "c" :
				cmdCal(scanner, cal);
				break;
			case "d" :
				printMenu();
				break;
			case "q" :
				isLoop = false;
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

	private void cmdSearch(Scanner scan, Calendar cal) {

		System.out.println("일정검색");

		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = scan.next();
		PlanItem plan;
		plan = cal.searchPlan(date);
		
		if (plan != null) {
			System.out.println(plan.detail);
		} else {
			System.out.println("일정이 없습니다.");
		}
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
