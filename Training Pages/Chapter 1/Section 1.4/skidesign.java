/*
ID: 
LANG: JAVA
TASK: skidesign
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

public class skidesign {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		TreeSet<Integer> heights = new TreeSet<Integer>();
		ArrayList<Integer> height = new ArrayList<Integer>();
		int b;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			b = Integer.parseInt(st.nextToken());
			heights.add(b);
			height.add(b);
		}
		TreeSet<Integer> costs = new TreeSet<Integer>();
		int cost, a;
		for (int min = heights.first(); min <= heights.last(); min++) {
			cost = 0;
			for (int i = 0; i < height.size(); i++) {
				a = height.get(i);
				if (!(a >= min && a <= min + 17)) {
					if (Math.abs(min - a) > Math.abs(a - (min + 17))) {
						cost += (a - (min + 17)) * (a - (min + 17));
					} else {
						cost += (min - a) * (min - a);
					}
				}
			}
			costs.add(cost);
		}
		pw.println(costs.first());
		pw.close();
	}
}
