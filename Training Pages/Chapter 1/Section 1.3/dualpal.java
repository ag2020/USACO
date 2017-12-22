/*
ID: 
LANG: JAVA
TASK: dualpal
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dualpal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int num = 0;
		
		while (num < n) {
			if (check(++s)) {
				pw.println(s);
				num++;
			}
		}
		
		pw.close();
	}
	
	public static boolean check (int num) {
		int numBool = 0;
		
		if (isPalin(Integer.toString(num, 2))) numBool++;
		if (isPalin(Integer.toString(num, 3))) numBool++;
		if (isPalin(Integer.toString(num, 4))) numBool++;
		if (isPalin(Integer.toString(num, 5))) numBool++;
		if (isPalin(Integer.toString(num, 6))) numBool++;
		if (isPalin(Integer.toString(num, 7))) numBool++;
		if (isPalin(Integer.toString(num, 8))) numBool++;
		if (isPalin(Integer.toString(num, 9))) numBool++;
		if (isPalin(Integer.toString(num, 10))) numBool++;
		
		if (numBool >= 2) {
			return true;
		}
		return false;
	}
	
	public static boolean isPalin (String num) {
		String b = "";
		for (int i = num.length() - 1; i >= 0; i--) {
			b += num.charAt(i);
		}
		
		if (num.equals(b)) {
			return true;
		}
		return false;
	}
}
