/*
ID: 
LANG: JAVA
TASK: gift1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		HashMap<String, Integer> myMap = new HashMap<String, Integer>(); 
		ArrayList<String> names = new ArrayList<String>();
		int numPeople = Integer.parseInt(st.nextToken());
		String iter = "";
		
		for (int i = 0; i < numPeople; i++) {
			st = new StringTokenizer(br.readLine());
			iter = st.nextToken();
			myMap.put(iter, 0);
			names.add(iter);
		}
		
		String giver = "";
		int amount = 0;
		int people = 0;
		int equal = 0;
		int leftOver = 0;
		String name = "";
		int value = 0;
		
		for (int i = 0; i < numPeople; i++) {
			st = new StringTokenizer(br.readLine());
			giver = st.nextToken();
			st = new StringTokenizer(br.readLine());
			amount = Integer.parseInt(st.nextToken());
			people = Integer.parseInt(st.nextToken());
			
			if (people > 0) {
			equal = amount / people;
			leftOver = amount % people;
			} else {
				equal = 0;
				leftOver = amount;
			}
			
			
			value = myMap.get(giver) - amount + leftOver;
			myMap.put(giver, value);
			
			for (int j = 0; j < people; j++) {
				st = new StringTokenizer(br.readLine());
				name = st.nextToken();
				value = myMap.get(name) + equal;
				myMap.put(name, value);
			}
		}
		
		for (int i = 0; i < numPeople; i++) {
			pw.println(names.get(i) + " " + myMap.get(names.get(i)));
		}
		pw.close();
	}
}
