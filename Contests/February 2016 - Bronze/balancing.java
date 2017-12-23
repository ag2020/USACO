import java.io.*;
import java.util.*;

public class balancing {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int cows = Integer.parseInt(st.nextToken());
		int [] x = new int[cows];
		int [] y = new int[cows];
		int [] xlines = new int [cows];
		int [] ylines = new int[cows];

		for (int i = 0; i < cows ; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			xlines[i] = x[i] - 1;
			ylines[i] = y[i] - 1;
		}
		int total = 0;
		int [] totals = new int[((xlines.length) * (ylines.length))];
		
		for (int k = 0; k < xlines.length; k++) {
			for (int j = 0; j < ylines.length; j++) {
				
				int iter2 = 0;
				int iter3 = 0;
				int iter4 = 0;
				int iter5 = 0;
				
				for (int i = 0; i < cows; i++) {
					if (x[i] < xlines[k]  && y[i] < ylines[j]) {
						iter2++;
					}
				}
				System.out.println(iter2 + "iter2");
				for (int i = 0; i < cows; i++) {
					if (x[i] < xlines[k] && y[i] > ylines[j]) {
						iter3++;
					}
				}
				System.out.println(iter3 + "iter3");

				for (int i = 0; i < cows; i++) {
					if (x[i] > xlines[k] && y[i] < ylines[j]) {
						iter4++;
					}
				}
				System.out.println(iter4 + "oter4");

				for (int i = 0; i < cows; i++) {
					if (x[i] > xlines[k] && y[i] > ylines[j]) {
						iter5++;
					}
				}
				System.out.println(iter5 + "iter5");
				
				total = iter2;
				if(iter3 > total) {
					total = iter3;
				}
				if(iter4 > total) {
					total = iter4;
				}
				if(iter5 > total) {
					total = iter5;
				}
				System.out.println(total);
				totals[(cows * k) + j] = total;
			}
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
