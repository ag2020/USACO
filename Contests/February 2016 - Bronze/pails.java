import java.io.*;
import java.util.*;
public class pails {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int b = m/x;
		int a = m/y;
		int total = 0;
		
		for (int i = 0; i <= b ; i++) {
			for (int j = 0; j <= a; j++) {
				if ((x * i) + (y * j) <= m) {
					if ((x * i ) + (y * j) > total) {
						total = (x * i) + (y * j);
					}
				}
			}
		}
		
		pw.println(total);
		pw.close();

	}
}
