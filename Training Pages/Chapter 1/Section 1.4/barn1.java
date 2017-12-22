/*
ID: 
LANG: JAVA
TASK: barn1
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class barn1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int numBoards = Integer.parseInt(st.nextToken());
		int numStalls = Integer.parseInt(st.nextToken());
		int numCows = Integer.parseInt(st.nextToken());
		
		if (numBoards >= numCows) {
			pw.println(numCows);
		} else {
			ArrayList<Integer> stallNum = new ArrayList<Integer>();
			
			for (int i = 0; i < numCows; i++) {
				st = new StringTokenizer(br.readLine());
				stallNum.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(stallNum);

			ArrayList<Integer> diff = new ArrayList<Integer>();			
			for (int i = 1; i < numCows; i++) {
				diff.add(stallNum.get(i) - stallNum.get(i - 1));
			}
			
			ArrayList<Integer> index = new ArrayList<Integer>();
			int max;
			int curIndex = 0;
			
			for (int i = 1; i < numBoards; i++) {
				max = diff.get(0);
				for (int j = 1; j < diff.size(); j++) {
					if (diff.get(j) > max && !index.contains(j)) {
						max = diff.get(j);
						curIndex = j;
					}
					
				}
				index.add(curIndex);
			}
			
			index.add(-1);
			index.add(numCows - 1);
			Collections.sort(index);
			
			int answer = 0;
			
			for (int i = 1; i < index.size(); i++) {
				answer += stallNum.get(index.get(i)) - stallNum.get(index.get(i-1) + 1) + 1;
			}
			
			if (answer == -1) {
				answer = stallNum.get(stallNum.size() - 1) - stallNum.get(0);
			}
			
			pw.println(answer);
		}
		pw.close();		
	}
}
