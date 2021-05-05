package baek.calendar;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] maxDayOfMonth 
			= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final int[] leap_maxDayOfMonth 
			= { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private HashMap<Date, PlanItem>planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
	}	
	
	public void registerPlan(String strDate, String plan) throws ParseException {
	
		PlanItem plni = new PlanItem(strDate, plan);
		planMap.put(plni.getDate(), plni);
	}
	
	public PlanItem searchPlan(String strDate) {

		Date date = PlanItem.getDateFromString(strDate);
		return planMap.get(date);
	}
	
	public boolean isLeapYear(int year) {
		
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int get_maxDayOfMonth(int year, int month) {

		if (isLeapYear(year)) {
			return leap_maxDayOfMonth[month];
		}

		return maxDayOfMonth[month];
	}

	public void printCalendar(int year, int month) {

		System.out.printf("     -%4d년 %d월-\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int weekday = get_weekday(year, month, 1);

		for (int i = 0; i < weekday; i++) {
			System.out.print("   ");
		}
		int days = get_maxDayOfMonth(year, month);

		int count = 7 - weekday;
		int delim = count < 7 ? count : 0;

		for (int i = 1; i <= days; i++) {

			System.out.printf("%3d", i);

			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.printf("\n\n");
	}
	
	public int get_weekday(int year, int month, int day) {

		int standard_Year 			= 1970;
		final int STANDAD_WEEKDAY 	= 4;

		int count = 0;

		for (int y = standard_Year; y < year; y++) {
			
			int year_Delta = isLeapYear(y) ? 366 : 365;
			count += year_Delta;
		}

		for (int m = 1; m < month; m++) {
			
			int month_Delta = get_maxDayOfMonth(year, m);
			count += month_Delta;
		}
		
		count += day - 1;
		
		int weekday = (count + STANDAD_WEEKDAY) % 7;
		return weekday;
	}
	
	public static void main(String[] args) throws ParseException {
		Calendar cal = new Calendar();
		System.out.println(cal.get_weekday(1970, 1, 1) == 4);
		System.out.println(cal.get_weekday(1971, 1, 1) == 5);
		System.out.println(cal.get_weekday(1972, 1, 1) == 6);
		System.out.println(cal.get_weekday(1973, 1, 1) == 1);
		System.out.println(cal.get_weekday(1974, 1, 1) == 2);
		
		cal.registerPlan("2021-05-22", "eat");
		System.out.println(cal.searchPlan("2021-05-22").equals("eat"));
	} 
}
