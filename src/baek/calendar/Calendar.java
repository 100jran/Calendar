package baek.calendar;

public class Calendar {

	private static final int[] maxDayOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int get_maxDayOfMonth(int month) {
		return maxDayOfMonth[month];
	}

	public void printCalendar(int month) {
		
		int days = get_maxDayOfMonth(month);
				
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");
		
		for(int i = 1; i <= days; i++) {
			
			System.out.printf("%3d", i);
			
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.printf("\n\n");
	}

	public static void main(String[] args) {

	}
}
