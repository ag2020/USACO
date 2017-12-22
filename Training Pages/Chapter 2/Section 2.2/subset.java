/*
ID: 
LANG: JAVA
TASK: subset
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class subset {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("subset.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		if (n % 4 != 0 && (n + 1) % 4 != 0) {
			pw.println(0);
		} else {
			int sum = n * (n + 1) / 4;
			
			long[] dp = new long[sum + 1];
			dp[0] = 1;
			
			int reach = 0;
			int j;
			for (int i = 1; i <= n; i++) {
				reach += i;
				j = reach < sum ? reach : sum;
				while(j >= i) {
					dp[j] += dp[j - i];
					j--;
				}
			}

			pw.println(dp[sum] / 2);
		}
		pw.close();
	}
}
