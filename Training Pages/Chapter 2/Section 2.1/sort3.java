/*
ID: 
LANG: JAVA
TASK: sort3
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class sort3 {
	
	static int n;
	static int[] order;
	static int ones;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		int swaps = 0;
		order = new int[n];
		ones = 0;
		int twos = 0;
		int a;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			if (a == 1) {ones++;} else if (a == 2) {twos++;}
			order[i] = a;
		}
		for (int i = 0; i < ones; i++) {
			if (order[i] == 3) {
				order[lowest()] = order[i];
				order[i] = 1;
				swaps++;
			}
			else if (order[i] == 2) {
				order[highest()] = order[i];
				order[i] = 1;
				swaps++;
			}
		}
		for (int i = ones; i < ones + twos; i++) {
			if (order[i] != 2) {
				swaps++;
			}
		}
		
		pw.println(swaps);
		pw.close();
	}
	
	public static int lowest() {
		for (int i = n - 1;; i--) {
			if (order[i] == 1) {
				return i;
			}
		}
	}
	
	public static int highest() {
		for (int i = ones;; i++) {
			if (order[i] == 1) {
				return i;
			}
		}
	}
}
