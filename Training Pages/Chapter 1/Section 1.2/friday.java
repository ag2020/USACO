/*
ID: 
LANG: JAVA
TASK: friday
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class friday {
	
	static int day = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("friday.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()) - 1;
		int sat = 0; int sun = 0; int mon = 0; int tue = 0; int wed = 0; int thu = 0; int fri = 0;
		int days = 0;
		int a = 0;
		
		for (int i = 1900; i <= 1900 + n; i++) {
			for (int j = 1; j < 13; j++) {
				days = daysInMonth(j, leapYear(i));
				for (int k = 1; k < days + 1; k++) {
					a = getDay();
					if (k == 13) {
						switch (a) {
						case 1: mon++; break;
						case 2: tue++; break;
						case 3: wed++; break;
						case 4: thu++; break;
						case 5: fri++; break;
						case 6: sat++; break;
						case 0: sun++; break;
						}
					}
				}
			}
		}
		
		pw.println(sat + " " + sun + " " + mon + " " + tue + " " + wed + " " + thu + " " + fri);
		pw.close();
	}
	
	public static int getDay() {
		return ++day % 7;
	}
	
	public static boolean leapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0) {
			return true;
		}
		else if (year % 400 == 0){
			return true;
		}
		return false;
	}
	
	public static int daysInMonth (int month, boolean leap) {
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			return 31;
		case 4: case 6: case 9: case 11:
			return 30;
		case 2:
			if (leap) {
				return 29;
			}
		}
		return 28;
	}
}
