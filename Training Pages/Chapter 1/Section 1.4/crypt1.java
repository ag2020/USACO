/*
ID: 
LANG: JAVA
TASK: crypt1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class crypt1 {
	
	static ArrayList <Integer> digits = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			digits.add(Integer.parseInt(st.nextToken()));
		}
		
		int a, b, c, d, e;
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			a = digits.get(i);
			for (int j = 0; j < n; j++) {
				b = digits.get(j);
				for (int k = 0; k < n; k++) {
					c = digits.get(k);
					for (int l = 0; l < n; l++) {
						d = digits.get(l);
						for (int m = 0; m < n; m++) {
							e = digits.get(m);
							if (check((100 * a + 10 * b + c) * (10 * d + e))) {
								if (("" + ((100 * a + 10 * b + c) * (10 * d + e))).length() == 4) {
									if (check((100 * a + 10 * b + c) * e)) {
										if (("" + ((100 * a + 10 * b + c) * e)).length() == 3) {
											if (check((100 * a + 10 * b + c) * d)) {
												if (("" + ((100 * a + 10 * b + c) * d)).length() == 3) {
													answer++;
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		pw.println(answer);
		pw.close();
	}
	
	public static boolean check (int num) {
		String a = "" + num;
		for (int i = 0; i < a.length(); i++) {
			if (!digits.contains(Integer.parseInt("" + a.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
}
