/*
ID: 
LANG: JAVA
TASK: ride
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ride {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String s = st.nextToken();
		int productone = 1;
		for (int i = 0; i < s.length(); i++) {
			productone *= (s.charAt(i) - 64);
		}
		productone %= 47;
		
		st = new StringTokenizer(br.readLine());
		s = st.nextToken();
		int producttwo = 1;
		for (int i = 0; i < s.length(); i++) {
			producttwo *= (s.charAt(i) - 64);
		}
		producttwo %= 47;
		
		if (productone == producttwo) {
			pw.println("GO");
		} else {
			pw.println("STAY");
		}
		
		pw.close();
    }
}
