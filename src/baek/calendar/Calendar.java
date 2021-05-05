package baek.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] maxDayOfMonth 
			= { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final int[] leap_maxDayOfMonth 
			= { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	private static final String SAVE_FILE = "calendar.dat";
	
	private HashMap<Date, PlanItem>planMap;
	
	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File file = new File(SAVE_FILE);
			
		if (!file.exists()) {
			System.err.println("NO SAVE FILE");
			return;
		}
		
		try {
			Scanner scan = new Scanner(file);
			
			while (scan.hasNext()) {
				
				String line = scan.nextLine();
				String[] words = line.split(",");
				
				String date = words[0];
				String detail = words[1].replaceAll("\"", "");
				PlanItem pi = new PlanItem(date, detail);
				planMap.put(pi.getDate(), pi);
				
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}	
	
	public void registerPlan(String strDate, String plan) throws ParseException {
	
		PlanItem plni = new PlanItem(strDate, plan);
		planMap.put(plni.getDate(), plni);
		
		File file = new File(SAVE_FILE);
		String item = plni.saveString();
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
}
