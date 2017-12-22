/*
ID: 
LANG: JAVA
TASK: namenum
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class namenum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long n = Long.parseLong(st.nextToken());
		
		BufferedReader br2 = new BufferedReader(new FileReader("dict.txt"));
		StringTokenizer st2;
		String name;
		long num;
		String s;
		int k = 0;
		while ((s = br2.readLine()) != null) {
			st2 = new StringTokenizer(s);
			name = st2.nextToken();
			num = toNum(name);
			if (num == n) {
				pw.println(name);
				k++;
			}
		}
		if (k == 0) {
			pw.println("NONE");
		}
		pw.close();
	}
	
	public static long toNum (String name) {
		String a = "";
		for (int i = 0; i < name.length(); i++) {
			switch(name.charAt(i)) {
			case 'A': case 'B': case 'C': a += "2";
			case 'D': case 'E': case 'F': a += "3";
			case 'G': case 'H': case 'I': a += "4";
			case 'J': case 'K': case 'L': a += "5";
			case 'M': case 'N': case 'O': a += "6";
			case 'P': case 'R': case 'S': a += "7";
			case 'T': case 'U': case 'V': a += "8";
			default: a += "9";
			}
		}
		return Long.parseLong(a);
	}
}
