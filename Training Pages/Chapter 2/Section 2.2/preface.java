/*
ID: 
LANG: JAVA
TASK: preface
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class preface {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("preface.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] val = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		String[] rom = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
		int I = 0; int V = 0; int X = 0; int L = 0; int C = 0; int D = 0; int M = 0;
		
		int x; int index; String s;
		for (int num = 1; num <= n; num++) {
			x = num;
			s = "";
			while (x > 0) {
				index = val.length - 1;
				while (val[index] > x) {
					index--;
				}
				s += rom[index];
				x -= val[index];
			}
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case 'I': I++; break;
				case 'V': V++; break;
				case 'X': X++; break;
				case 'L': L++; break;
				case 'C': C++; break;
				case 'D': D++; break;
				case 'M': M++; break;
				}
			}
		}
		
		pw.println("I " + I);
		if (V > 0) {pw.println("V " + V);}
		if (X > 0) {pw.println("X " + X);}
		if (L > 0) {pw.println("L " + L);}
		if (C > 0) {pw.println("C " + C);}
		if (D > 0) {pw.println("D " + D);}
		if (M > 0) {pw.println("M " + M);}
		pw.close();
	}
}
