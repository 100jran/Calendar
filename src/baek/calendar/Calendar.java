package baek.calendar;

public class Calendar {

	public int weekday_Start(String weekday_Str) {

		if (weekday_Str.equals("SU")) {
			return 0;
		} else if (weekday_Str.equals("MO")) {
			return 1;
		} else if (weekday_Str.equals("TU")) {
			return 2;
		} else if (weekday_Str.equals("WE")) {
			return 3;
		} else if (weekday_Str.equals("TH")) {
			return 4;
		} else if (weekday_Str.equals("FR")) {
			return 5;
		} else if (weekday_Str.equals("SA")) {
			return 6;
		} else {
			return 0;
		}

	}

	private static final int[] maxDayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private static final int[] leap_maxDayOfMonth = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int get_maxDayOfMonth(int year, int month, int weekday) {

		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return leap_maxDayOfMonth[month];
		}

		return maxDayOfMonth[month];
	}

	public void printCalendar(int year, int month, int weekday) {

		int days = get_maxDayOfMonth(year, month, weekday);
		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;

		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}

		for (int i = 1; i <= days; i++) {

			System.out.printf("%3d", i);

			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.printf("\n\n");
	}

	public static void main(String[] args) {

	}
}
