import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class taming {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean done = false;
		int val;
		int val2;
		for (int i = n - 1; i >= 0 && !done; i--) {
			val = arr[i];
			if (val != -1) {
				for (int j = i - 1; j >= i - val && !done; j--) {
					val2 = arr[j];
					if (val2 != -1 && val - val2 != i - j) {
						done = true;
						break;
					}
				}
			}
		}
				
		if (!done) {
			byte[] boo = new byte[n];
			boo[0] = 2;
			
			for (int i = 0; i < n; i++) {
				val = arr[i];
				if (val == 0) {
					boo[i] = 2;
				} else if (val > 0) {
					for (int j = 0; j < val; j++) {
						boo[i - j] = 1;
					}
					boo[i - val] = 2;
				}
			}
			
			int min = 0;
			int max = 0;
			for (int i = 0; i < n; i++) {
				if (boo[i] == 2) {
					min++;
				} else if (boo[i] == 0) {
					max++;
				}
			}
			
			pw.println(min + " " + (min + max));
		} else {
			pw.println(-1);
		}
		
		pw.close();
	}
}
