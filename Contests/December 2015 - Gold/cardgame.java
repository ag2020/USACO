import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cardgame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cardgame.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cardgame.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] opp = new int[n];
		boolean[] opp2 = new boolean[2 * n + 1];
		for (int i = 1; i < 2 * n + 1; i++) {
			opp2[i] = false;
		}
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			opp[i] = Integer.parseInt(st.nextToken());
			opp2[opp[i]] = true;
		}
		int[] my = new int[n];
		int index = 0;
		for(int i = 1; i < 2 * n + 1; i++) {
			if (!opp2[i]) {
				my[index++] = i;
			}
		}
		Arrays.sort(my);
		
		int[] oppTop = new int[n / 2];
		int[] myTop = new int[n / 2];
		int[] oppBot = new int[n / 2];
		int[] myBot = new int[n / 2];
		for (int i = 0; i < n / 2; i++) {
			oppTop[i] = opp[i];
			oppBot[i] = opp[i + n / 2];
			myBot[i] = my[i];
			myTop[i] = my[i + n / 2];
		}
		Arrays.sort(oppTop);
		Arrays.sort(oppBot);
		
		int points = 0;
		int myIndex = 0, oppIndex = 0;
		while (myIndex < n / 2 && oppIndex < n / 2) {
			if (myBot[myIndex] < oppBot[oppIndex]) {
				points++;
				myIndex++;
			}
			oppIndex++;
		}
		
		myIndex = n / 2 - 1;
		oppIndex = n / 2 - 1;
		while (myIndex >= 0 && oppIndex >= 0) {
			if (myTop[myIndex] > oppTop[oppIndex]) {
				points++;
				myIndex--;
			}
			oppIndex--;
		}
		
		pw.println(points);
		pw.close();
	}
}
