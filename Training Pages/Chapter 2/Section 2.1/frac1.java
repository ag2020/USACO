/*
ID: 
LANG: JAVA
TASK: frac1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class frac1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		pw.println("0/1");
		
		if (n > 1) {
			int[] num = new int[((n)*(n-1))/2];
			int[] den = new int[((n)*(n-1))/2];
			PriorityQueue<Double> value = new PriorityQueue<Double>(((n)*(n-1))/2);
			HashMap<Double, Integer> hash = new HashMap<Double, Integer>();
			
			double a = 0;
			for (int i = 2; i <= n; i++) {
				for (int j = 1; j <= i - 1; j++) {
					a = (j + 0.0)/i;
					if (!value.contains(a)) {
						num[(((i-2)*(i-1))/2)+j-1] = j;
						den[(((i-2)*(i-1))/2)+j-1] = i;
						value.add(a);
						hash.put(a, (((i-2)*(i-1))/2)+j-1);
					}
				}
			}
			
			int index = 0;
			while(value.size() > 0) {
				index = hash.get(value.poll());
				pw.println(num[index] + "/" + den[index]);
			}
		}
		
		pw.println("1/1");
		pw.close();
	}
}
