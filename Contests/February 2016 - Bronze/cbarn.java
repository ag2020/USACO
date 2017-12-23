import java.io.*;
import java.util.*;
public class cbarn {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lines = Integer.parseInt(st.nextToken());
		int [] values = new int[(2 * lines)];
		int [] totals = new int[lines];
		int total = 0;
		
		for (int i = 0; i < lines; i++) {
			st = new StringTokenizer(br.readLine());
			values[i] = Integer.parseInt(st.nextToken()) ;
			values[i + lines] = values[i];
		}
		
		for (int i = 0; i < lines; i++ ) {
			total = 0;
				for (int k = 0; k < lines; k++) {
					total = total + (values[i+k] * k);
				}
				totals[i] = total;
		}
		int finale = totals[0];
		for (int i = 1; i < totals.length; i++) {
			if (totals[i] < finale) {
				finale = totals[i];
			}
		}
		pw.println(finale);
		pw.close();
	}
}
