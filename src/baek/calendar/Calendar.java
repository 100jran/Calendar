package baek.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public int get_maxDayOfMonth(int month) {
		return maxDayOfMonth[month];
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Calendar cal 	= new Calendar();

		System.out.println("달을 입력하세요.");
		int month = scanner.nextInt();
		
		System.out.printf("%d월은 %d일까지 입니다.", month, cal.get_maxDayOfMonth(month));
		scanner.close();
	}
}
