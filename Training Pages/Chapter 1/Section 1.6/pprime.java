/*
ID: 
LANG: JAVA
TASK: pprime
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class pprime {
	
	static int palin;
	static int a;
	static int b;
	static ArrayList<Integer> answers = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int b2 = ("" + b).length();
		for (int i = ("" + a).length(); i <= b2; i++) {
			makePalin(i);
		}
		
		for (int e : answers) {
			pw.println(e);
		}
		pw.close();
	}
	
	public static void makePalin (int digits) {
		switch(digits) {
		case 1:
			for (int d1 = 1; d1 <= 9; d1++) {
				palin = d1;
				if (palin >= a && palin <= b && isPrime(palin)) {
					answers.add(palin);
				}
			}
			break;
		case 2:
			for (int d1 = 1; d1 <= 9; d1++) {
				palin = 10*d1 + d1;
				if (palin >= a && palin <= b && isPrime(palin)) {
					answers.add(palin);
				}
			}
			break;
		case 3:
			for (int d1 = 1; d1 <= 9; d1++) {
				for (int d2 = 0; d2<= 9; d2++) {
					palin = 100*d1 + 10*d2 + d1;
					if (palin >= a && palin <= b && isPrime(palin)) {
						answers.add(palin);
					}
				}
			}
			break;
		case 4:
			for (int d1 = 1; d1 <= 9; d1++) {
				for (int d2 = 0; d2 <= 9; d2++) {
					palin = 1000*d1 + 100*d2 + 10*d2 + d1;
					if (palin >= a && palin <= b && isPrime(palin)) {
						answers.add(palin);
					}
				}
			}
			break;
		case 5:
			for (int d1 = 1; d1 <= 9; d1++) {
				for (int d2 = 0; d2 <= 9; d2++) {
					for (int d3 = 0; d3 <= 9; d3++) {
						palin = 10000*d1 + 1000*d2 + 100*d3 + 10*d2 + d1;
						if (palin >= a && palin <= b && isPrime(palin)) {
							answers.add(palin);
						}
					}
				}
			}
			break;
		case 6: 
			for (int d1 = 1; d1 <= 9; d1++) {
				for (int d2 = 0; d2 <= 9; d2++) {
					for (int d3 = 0; d3 <= 9; d3++) {
						palin = 100000*d1 + 10000*d2 + 1000*d3 + 100*d3 + 10*d2 + d1;
						if (palin >= a && palin <= b && isPrime(palin)) {
							answers.add(palin);
						}
					}
				}
			}
			break;
		case 7: 
			for (int d1 = 1; d1 <= 9; d1++) {
				for (int d2 = 0; d2 <= 9; d2++) {
					for (int d3 = 0; d3 <= 9; d3++) {
						for (int d4 = 0; d4 <= 9; d4++) {
							palin = 1000000*d1 + 100000*d2 + 10000*d3 + 1000*d4 + 100*d3 + 10*d2 + d1;
							if (palin >= a && palin <= b && isPrime(palin)) {
								answers.add(palin);
							}
						}
					}
				}
			}
			break;
		case 8:
			for (int d1 = 1; d1 <= 9; d1++) {
				for (int d2 = 0; d2 <= 9; d2++) {
					for (int d3 = 0; d3 <= 9; d3++) {
						for (int d4 = 0; d4 <= 9; d4++) {
							palin = 10000000*d1 + 1000000*d2 + 100000*d3 + 10000*d4 + 1000*d4 + 100*d3 + 10*d2 + d1;
							if (palin >= a && palin <= b && isPrime(palin)) {
								answers.add(palin);
							}
						}
					}
				}
			}
			break;
		}
	}
	
	public static boolean isPrime (int num) {
		if (num == 2) {
			return true;
		} else if (num % 2 == 0) {
			return false;
		} else {
			for (int i = 3; i * i <= num; i += 2) {
				if (num % i == 0) {
					return false;
				}
			}
			return true;
		}
	}
}
