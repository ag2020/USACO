/*
ID: 
LANG: JAVA
TASK: milk3
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class milk3 {
	
	static TreeSet<Integer> answers = new TreeSet<Integer>();
	static int maxA, maxB, maxC, aCur, bCur, cCur = 0;
	static ArrayList<ArrayList<Integer>> visited = new ArrayList<ArrayList<Integer>>();
	
	public static void main (String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		maxA = Integer.parseInt(st.nextToken());
		maxB = Integer.parseInt(st.nextToken());
		maxC = Integer.parseInt(st.nextToken());
		cCur = maxC;
		
		search(aCur, bCur, cCur, 0);
		
		int d = answers.size();
		for (int i = 0; i < d - 1; i++) {
			pw.print(answers.pollFirst() + " ");
		}
		pw.println(answers.pollFirst());
		pw.close();
	}
	
	public static void search (int a, int b, int c, int num) {
		ArrayList<Integer> d = new ArrayList<Integer>();
		d.add(a);
		d.add(b);
		d.add(c);
		
		if (!(visited.contains(d))) {
			visited.add(d);
			if (a == 0) {
				if (!(answers.contains(c))) {
					answers.add(c);
				}
			}
			for (int i = 1; i <= 6; i++) {
				switch(i) {
				case 1: atob(); break;
				case 2: btoc(); break;
				case 3: atoc(); break;
				case 4: btoa(); break;
				case 5: ctob(); break;
				default: ctoa(); break;
				}
				
				search(aCur, bCur, cCur, num + 1);
				
				aCur = a;
				bCur = b;
				cCur = c;
			}
		}
		visited.add(d);
	}
	
	public static void atob () {
		if (aCur + bCur <= maxB) {
			bCur += aCur;
			aCur = 0;
		} else {
			aCur -= maxB - bCur;
			bCur = maxB;
		}
	}
	
	public static void btoc () {
		if (bCur + cCur <= maxC) {
			cCur += bCur;
			bCur = 0;
		} else {
			bCur -= maxC - cCur;
			cCur = maxC;
		}
	}

	public static void atoc () {
		if (aCur + cCur <= maxC) {
			cCur += aCur;
			aCur = 0;
		} else {
			aCur -= maxC - cCur;
			cCur = maxC;
		}
	}

	public static void btoa () {
		if (bCur + aCur <= maxA) {
			aCur += bCur;
			bCur = 0;
		} else {
			bCur -= maxA - aCur;
			aCur = maxA;
		}
	}

	public static void ctob () {
		if (cCur + bCur <= maxB) {
			bCur += cCur;
			cCur = 0;
		} else {
			cCur -= maxB - bCur;
			bCur = maxB;
		}
	}

	public static void ctoa () {
		if (cCur + aCur <= maxA) {
			aCur += cCur;
			cCur = 0;
		} else {
			cCur -= maxA - aCur;
			aCur = maxA;
		}
	}
}
