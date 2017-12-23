import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class cownomics {
	
	static String spots[];
	static String nospots[];
	static int m;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		spots = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			spots[i] = st.nextToken();
		}
		nospots = new String[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			nospots[i] = st.nextToken();
		}
		
		int min = 1;
		int max = m;
		int mid = 0;
		
		while (min != max) {
			mid = (min + max)/2;
			//System.out.println("mid = " + mid);
			if (check(mid)) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		
		pw.println(min);
		pw.close();
	}
	
	public static boolean check(int x) {
		HashSet<String> used = new HashSet<String>();
		boolean b;
		for (int i = 0; i <= m - x; i++) {
			b = true;
			for (int j = 0; j < n; j++) {
				if (!used.contains(spots[j].substring(i, i + x))) {
					used.add(spots[j].substring(i, i + x));
				}
			}
						
			for (int j = 0; j < n; j++) {
				if (used.contains(nospots[j].substring(i, i + x))) {
					//System.out.println("false");
					b = false;
				}
			}
			if (b) {
				return true;
			}
			used.clear();
		}
		return false;
	}
}
