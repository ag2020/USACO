/*
ID: 
LANG: JAVA
TASK: milk
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class milk {
	
	public static void main (String [] args)  throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int milkNeeded = Integer.parseInt(st.nextToken());
		int numFarmers = Integer.parseInt(st.nextToken());
		
		ArrayList <Integer> cost = new ArrayList<Integer>();
		ArrayList <Integer> units = new ArrayList<Integer>();
		
		for (int i = 0; i < numFarmers; i++) {
			st = new StringTokenizer(br.readLine());
			cost.add(Integer.parseInt(st.nextToken()));
			units.add(Integer.parseInt(st.nextToken()));
		}
		
		int index;
		int minCost;
		int available;
		int totalCost = 0;
		
		while (milkNeeded > 0) {
			minCost = cost.get(0);
			index = 0;
			for (int i = 1; i < cost.size(); i++) {
				if (cost.get(i) < minCost) {
					minCost = cost.get(i);
					index = i;
				}
			}
			
			available = units.get(index);
			cost.remove(index);
			units.remove(index);
			
			if (available <= milkNeeded) {
				totalCost += available * minCost;
				milkNeeded -= available;
			} else {
				totalCost += milkNeeded * minCost;
				milkNeeded = 0;
			}
		}
		
		pw.println(totalCost);
		pw.close();
	}
}
