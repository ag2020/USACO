/*
ID: 
LANG: JAVA
TASK: combo
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class combo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("combo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c1n1 = Integer.parseInt(st.nextToken());
		int c1n2 = Integer.parseInt(st.nextToken());
		int c1n3 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c2n1 = Integer.parseInt(st.nextToken());
		int c2n2 = Integer.parseInt(st.nextToken());
		int c2n3 = Integer.parseInt(st.nextToken());
		
		if (n == 1) {
			pw.println(1);
		} else if (n == 2) {
			pw.println(8);
		} else if (n ==3) {
			pw.println(27);
		} else if (n == 4){
			pw.println(64);
		}	else if (n == 5) {
			pw.println(125);
		} else {
			int total = 250;
			
			ArrayList<Integer> array1 = new ArrayList<Integer>();
			ArrayList<Integer> array2 = new ArrayList<Integer>();
			
			for (int i = c1n1 - 2; i <= c1n1 + 2; i++) {
				if (i < 1) {
					array1.add(i + n);
				} else if (i > n) {
					array1.add(i - n);
				} else {
					array1.add(i);
				}
			}
			for (int i = c2n1 - 2; i <= c2n1 + 2; i++) {
				if (i < 1) {
					array2.add(i + n);
				} else if (i > n) {
					array2.add(i - n);
				} else {
					array2.add(i);
				}
			}
			int prod1 = 0;
			for (int i = 0; i < 5; i++) {
				if (array2.contains(array1.get(i))) {
					prod1++;
				}
			}
			
			array1.clear();
			array2.clear();
			
			for (int i = c1n2 - 2; i <= c1n2 + 2; i++) {
				if (i < 1) {
					array1.add(i + n);
				} else if (i > n) {
					array1.add(i - n);
				} else {
					array1.add(i);
				}
			}
			for (int i = c2n2 - 2; i <= c2n2 + 2; i++) {
				if (i < 1) {
					array2.add(i + n);
				} else if (i > n) {
					array2.add(i - n);
				} else {
					array2.add(i);
				}
			}
			int prod2 = 0;
			for (int i = 0; i < 5; i++) {
				if (array2.contains(array1.get(i))) {
					prod2++;
				}
			}
			
			array1.clear();
			array2.clear();
			
			for (int i = c1n3 - 2; i <= c1n3 + 2; i++) {
				if (i < 1) {
					array1.add(i + n);
				} else if (i > n) {
					array1.add(i - n);
				} else {
					array1.add(i);
				}
			}
			for (int i = c2n3 - 2; i <= c2n3 + 2; i++) {
				if (i < 1) {
					array2.add(i + n);
				} else if (i > n) {
					array2.add(i - n);
				} else {
					array2.add(i);
				}
			}
			int prod3 = 0;
			for (int i = 0; i < 5; i++) {
				if (array2.contains(array1.get(i))) {
					prod3++;
				}
			}
			
			total -= prod1 * prod2 * prod3;
			
			pw.println(total);
		}
		pw.close();
	}
}
