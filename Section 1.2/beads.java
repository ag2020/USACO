/*
ID: 
LANG: JAVA
TASK: beads
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class beads {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("beads.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		String neck = st.nextToken();
		neck += neck;
		int max = 0;
		int j;
		char color;
		int onemax;
		int twomax;
		char curColor;
		
		for (int i = 0; i < 2*n - 1; i++) {
			curColor = '!';
			color = '!';
			onemax = 0;
			twomax = 0;
			j = i;
			
			while (j >= 0) {
				color = neck.charAt(j);
				if (color == 'b' && curColor == '!'){
					onemax++;
					curColor = 'b';
				}
				else if (color == 'b' && curColor == 'r') {
					break;
				}
				else if (color == 'r' && curColor == '!') {
					onemax++;
					curColor = 'r';
				}
				else if (color == 'r' && curColor == 'b') {
					break;
				}
				else {
					onemax++;
				}
				j--;
			}
			curColor = '!';
			color = '!';
			j = i+1;
			
			while (j <= 2*n - 1){
				color = neck.charAt(j);
				if (color == 'b' && curColor == '!'){
					twomax++;
					curColor = 'b';
				}
				else if (color == 'b' && curColor == 'r') {
					break;
				}
				else if (color == 'r' && curColor == '!') {
					twomax++;
					curColor = 'r';
				}
				else if (color == 'r' && curColor == 'b') {
					break;
				}
				else {
					twomax++;
				}
				j++;
			}
			
			if (onemax + twomax > max) {
				max = onemax + twomax;
			}
			
		}
		if (max > n){
			max = n;
		}
		
		pw.println(max);
		pw.close();
	}
}
