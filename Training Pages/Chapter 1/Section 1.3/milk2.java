/*
ID: 
LANG: JAVA
TASK: milk2
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class milk2 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		TreeSet<Integer> start = new TreeSet<Integer>();
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			if (start.contains(a)) {
				b = Integer.parseInt(st.nextToken());
				if (b > hash.get(a)) {
					hash.put(a, b);
				}
			} else {
				start.add(a);
				b = Integer.parseInt(st.nextToken());
				hash.put(a, b);
			}
		}
		
		int val3 = start.pollFirst();  
		int val4 = hash.get(val3);
		int low = val3;
		int high = val4;
		int maxyes = 0;
		int maxno = 0;
		
		if (n == 1) {
			maxyes = high - low;
		} else {
			for (int i = 0; i < hash.size() - 1; i++) {
				val3 = start.pollFirst();  
				val4 = hash.get(val3);
				
				if (val3 > high) {
					if (high - low > maxyes) {
						maxyes = high - low;
					}
					if (val3 - high > maxno) {
						maxno = val3 - high;
					}
					low = val3;
					high = val4;
				}
				else if (val4 > high) {
					high = val4;
				}
			}
		}
		
		if (maxyes == 0 && maxno == 0) {
			maxyes = high - low;
			maxno = 0;
		}
		
		pw.println(maxyes + " " + maxno);
		pw.close();
	}
}
