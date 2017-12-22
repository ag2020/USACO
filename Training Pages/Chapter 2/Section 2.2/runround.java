 /*
ID: 
LANG: JAVA
TASK: runround
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class runround {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("runround.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		while (!good(++m));
		pw.println(m);
		pw.close();
	}
	
	public static boolean good (int m) {
		String s = m + "";
		if (s.indexOf('0') != -1) {return false;}
		if (s.indexOf('1') != s.lastIndexOf('1')) {return false;}
		if (s.indexOf('2') != s.lastIndexOf('2')) {return false;}
		if (s.indexOf('3') != s.lastIndexOf('3')) {return false;}
		if (s.indexOf('4') != s.lastIndexOf('4')) {return false;}
		if (s.indexOf('5') != s.lastIndexOf('5')) {return false;}
		if (s.indexOf('6') != s.lastIndexOf('6')) {return false;}
		if (s.indexOf('7') != s.lastIndexOf('7')) {return false;}
		if (s.indexOf('8') != s.lastIndexOf('8')) {return false;}
		if (s.indexOf('9') != s.lastIndexOf('9')) {return false;}
		int len = s.length();
		int pos = 0;
		boolean[] done = new boolean[len];
		do {
			done[pos % len] = true;
			pos += Integer.parseInt(s.charAt(pos % len) + "");
		} while (!done[pos % len]);
		if (pos % len != 0) {return false;}
		for (boolean b : done) {
			if (!b) {return false;}
		}
		return true;
	}
}
