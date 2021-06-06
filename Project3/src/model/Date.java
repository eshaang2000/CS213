package model; /**
 *  Class to instantiate, compare, and validate accountDatabase.Date objects.
 *  @author Shankar Kohli, Eshaan Gandhi
 */

import java.util.StringTokenizer;

public class Date implements Comparable<Date> {

	private int day;
	private int month;
	private int year;

	/**
	 * Constructor to create accountDatabase.Date object
	 *
	 * @param date String containing date
	 */
	public Date(String date) {
		StringTokenizer st = new StringTokenizer(date, "/");
		month = Integer.parseInt(st.nextToken());
		day = Integer.parseInt(st.nextToken());
		year = Integer.parseInt(st.nextToken());
	}

	/**
	 * Constructor to make accountDatabase.Date object
	 *
	 */
	public Date(Date date) {
		day = date.day;
		month = date.month;
		year = date.year;
	}

	/**
	 * Compare two dates
	 * @param date object
	 * @return -1 if date is less recent, 0 if dates are equal, 1 if date is more recent
	 */
	public int compareTo(Date date) {

		if (date == null) {
			return -1;
		}
		if (this.year > date.year) {
			return 1;
		} else if (this.year<date.year) {
			return -1;
		} else if (this.year == date.year) {
			if (this.month<date.month) {
				return -1;
			} else if (this.month > date.month) {
				return 1;
			} else if (this.month == date.month) {
				if (this.day<date.day) {
					return -1;
				} else if (this.day > date.day) {
					return 1;
				} else {
					return 0;
				}
			}

		}

		return -1;
	}

	/**
	 * Indicates whether a given date is valid
	 *
	 * @return true if the date is valid
	 */
	public boolean isValid() {
		int maxMonth = 12;
		int minMonth = 1;
		int minDays = 1;
		int maxDays;
		int[] thirtyDaysMonths = { 9, 4, 6, 11 }; //added for clarity, these months have 30 days
		int[] thirtyOneDaysMonths = { 1, 3, 5, 7, 8, 10, 12 }; //added for clarity, these months have 31 days
		int feb = 2;
		int febDays;

		//call method checkLeap to check if year is leap year. If yes, febDays = 29, else febDays = 28
		if (checkLeap(year)) {
			febDays = 29;
		} else {
			febDays = 28;
		}

		if (year<0) {
			return false;
		}

		if (month<minMonth || month > maxMonth) {
			return false;
		}

		//Check if month is one that has 30 days, 31 days, or is February
		if (month == 9 || month == 6 || month == 4 || month == 11) {
			maxDays = 30;
			if (day<minDays || day > maxDays) {
				return false;
			}
		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			maxDays = 31;
			if (day<minDays || day > maxDays) {
				return false;
			}
		} else if (month == feb) {
			maxDays = febDays;
			if (day<minDays || day > maxDays) {
				return false;
			}

		}

		return true;

	}

	/**
	 * Returns string representation of date, overrides defualt toString()
	 * @return string representation of date
	 */
	@Override
	public String toString() {
		String tempMonth = Integer.toString(month);
		String tempDay = Integer.toString(day);
		String tempYear;

		return (tempMonth + "/" + tempDay + "/" + Integer.toString(year));
	}

	/**
	 * Helper method to check if given year is leap year, sets days in February accordingly
	 * @param year to check
	 * @return true if year is leap year, false if not
	 */
	public boolean checkLeap(int year) {
		boolean isLeap = false;

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0)
					isLeap = true;
				else
					isLeap = false;
			} else
				isLeap = true;
		} else {
			isLeap = false;
		}

		return isLeap;
	}

}