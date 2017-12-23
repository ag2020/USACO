import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hps {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		String[] order = new String[n];
		int[] totals = new int[]{0 ,0 ,0};
		String a = "";
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			order[i] = a;
			
			if (a.equals("H")) {
				totals[0] += 1;
			} else if (a.equals("P")) {
				totals[1] += 1;
			} else {
				totals[2] += 1;
			}
		}
		
		int maxGames = maximum(totals);
		int[] curTotals = new int[]{0, 0, 0};
		for (int i = 0; i < n; i++) {
			if (order[i].equals("H")) {
				curTotals[0] += 1;
				totals[0] -= 1;
			} else if (order[i].equals("P")) {
				curTotals[1] += 1;
				totals[1] -= 1;
			} else {
				curTotals[2] += 1;
				totals[2] -= 1;
			}
			
			int b = maximum(curTotals) + maximum(totals);
			if (b > maxGames) {
				maxGames = b;
			}
		}
		
		//System.out.println(maxGames);
		pw.println(maxGames);
		pw.close();
	}
	
	public static int maximum (int[] list) {
		int max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] > max) {
				max = list[i];
			}
		}
		return max;
	}
}
