/*
ID: 
LANG: JAVA
TASK: numtri
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class numtri {

	static ArrayList<ArrayList<Integer>> tree = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> fromPoint = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i; j++) {
				a.add(Integer.parseInt(st.nextToken()));
			}
			tree.add(a);
		}
		
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++) {
			b.add(0);
		}
		fromPoint.add(b);
		
		search(n);
		
		pw.println(fromPoint.get(fromPoint.size() - 1).get(0));
		pw.close();
	}
	
	public static void search (int row) {
		if (row >= 1) {
			ArrayList<Integer> c = new ArrayList<Integer>();
			for (int i = 1; i <= row; i++) {
				if (fromPoint.get(fromPoint.size() - 1).get(i - 1) > fromPoint.get(fromPoint.size() - 1).get(i)) {
					c.add(fromPoint.get(fromPoint.size() - 1).get(i - 1) + tree.get(row - 1).get(i - 1));
				} else {
					c.add(fromPoint.get(fromPoint.size() - 1).get(i) + tree.get(row - 1).get(i - 1));
				}
			}
			
			fromPoint.add(c);
			search(row - 1);
		}
	}
}
