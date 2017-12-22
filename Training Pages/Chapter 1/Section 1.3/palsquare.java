/*
ID: 
LANG: JAVA
TASK: palsquare
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class palsquare {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int base = Integer.parseInt(st.nextToken());
		String square;
		
		for (int i = 1; i <= 300; i++) {
			square = Integer.toString(i*i, base);
			if (isPalin(square)) {
				pw.println(Integer.toString(i, base).toUpperCase() + " " + square.toUpperCase());
			}
		}
		pw.close();
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
