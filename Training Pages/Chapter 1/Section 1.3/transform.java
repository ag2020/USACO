/*
ID: 
LANG: JAVA
TASK: transform
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class transform {
	
	static int n = 0;
	static ArrayList<String> end = new ArrayList<String>();
	static ArrayList<String> potential = new ArrayList<String>();
	static ArrayList<String> potential2 = new ArrayList<String>();
	static ArrayList<String> start = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("transform.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			start.add(st.nextToken());
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			end.add(st.nextToken());
		}
		
		potential = start;
		if (check1()) {
			pw.println(1);
		} else {
			potential = start;
			if (check2()) {
				pw.println(2);
			} else {
				potential = start;
				if (check3()) {
					pw.println(3);
				} else {
					potential = start;
					if (check4()) {
						pw.println(4);
					} else {
						potential = start;
						if (check5()) {
							pw.println(5);
						} else {
							potential = start;
							if (check6()) {
								pw.println(6);
							} else {
								pw.println(7);
							}
						}
					}
				}
			}
		}
		pw.close();
	}
	
	public static void build90() {
		String a;
		for (int i = 0; i < n; i++) {
			a = "";
			for (int j = n - 1; j >= 0; j--) {
				a += (potential.get(j)).charAt(i);
			}
			potential2.add(a);
		}
		potential = new ArrayList<String>(potential2);
		potential2.clear();
	}
	
	public static void reflect() {
		String a;
		for (int i = 0; i < n; i++) {
			a = "";
			for (int j = n - 1; j >= 0; j--) {
				a += (potential.get(i)).charAt(j);
			}
			potential2.add(a);
		}
		potential = new ArrayList<String>(potential2);
		potential2.clear();
	}
	
	public static boolean check1 () {
		build90();
		if (potential.equals(end)) {
			return true;
		}
		return false;
	}
	
	public static boolean check2 () {
		build90();
		build90();
		if (potential.equals(end)) {
			return true;
		}
		return false;
	}
	
	public static boolean check3 () {
		build90();
		build90();
		build90();
		if (potential.equals(end)) {
			return true;
		}
		return false;
	}
	
	public static boolean check4 () {
		reflect();
		if (potential.equals(end)) {
			return true;
		}
		return false;
	}
	
	public static boolean check5 () {
		reflect();
		build90();
		if (potential.equals(end)) {
			return true;
		}
		build90();
		if (potential.equals(end)) {
			return true;
		}
		build90();
		if (potential.equals(end)) {
			return true;
		}
		return false;
	}
	
	public static boolean check6 () {
		if (potential.equals(end)) {
			return true;
		}
		return false;
	}
}
