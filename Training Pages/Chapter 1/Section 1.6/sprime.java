/*
ID: 
LANG: JAVA
TASK: sprime
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class sprime {
	
	static int n;
	static ArrayList<Integer> answers = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		search(2, 1);
		search(3,1);
		search(5,1);
		search(7,1);
		
		for (int e : answers) {
			pw.println(e);
		}
		pw.close();
	}
	
	public static void search(int num, int length) {
		if (isPrime(num)) {
			if (length == n) {
				answers.add(num);
			} else {
				for (int i = 1; i <= 9; i++) {
					search(Integer.parseInt("" + num + i), length + 1);
				}
			}
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
