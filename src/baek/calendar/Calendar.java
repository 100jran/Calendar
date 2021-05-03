package baek.calendar;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		
		System.out.println("두 수를 입력하세요.");
		Scanner scanner = new Scanner(System.in);
		int firstNum 	= scanner.nextInt();
		int secondNum 	= scanner.nextInt();
		
		System.out.printf("두 수의 합은 %d 입니다.", firstNum + secondNum);
	}
}
