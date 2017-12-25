import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class greedy { 
	
	static int n;
	static int[] jump;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("greedy.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("greedy.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		jump = new int[n];
		for (int i = 0; i < n; i++) {
			jump[i] = n - Integer.parseInt(st.nextToken());
		}
		
		int min = 0;
		int max = n - 1;
		int mid;
		
		while (min != max) {
			mid = (min + max) / 2;
			if (check(mid)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		pw.println(n - min);
		pw.close();
	}
	
	public static boolean check (int cow) {
		int[] arr = new int[n + 1];
		for (int i = 0; i < cow; i++) {
			arr[jump[i]]++;
		}
		int total = 0;
		for (int k = 1; k <= cow; k++) {
			total += arr[k];
			if (total >= k) {
				return true;
			}
		}
		return false;
	}
}
