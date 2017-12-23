import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class moocast {
	
	static ArrayList<ArrayList<Integer>> location = new ArrayList<ArrayList<Integer>>();
	static ArrayList<Integer> power = new ArrayList<Integer>();
	static ArrayList<ArrayList<Integer>> done = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> reached = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ArrayList<Integer> d = new ArrayList<Integer>();
			d.add(Integer.parseInt(st.nextToken()));
			d.add(Integer.parseInt(st.nextToken()));
			location.add(d);
			power.add(Integer.parseInt(st.nextToken()));
		}
	//	System.out.println("powers are " + power);
		int answers = 0;
		
		for (int i = 0; i < n; i++) {
			reached.clear();
			done.clear();
			System.out.println("called from main");
			search(location.get(i).get(0), location.get(i).get(1), i, 0);
			System.out.println("size of reach is " + reached.size());
			if (reached.size() > answers) {
				answers = reached.size();
			}
		}
		
		pw.println(answers);
		System.out.println(answers);
		pw.close();
	}
	
	public static void search(int x, int y, int index, int num) {
		ArrayList<Integer> e = new ArrayList<Integer>();
		e.add(x);
		e.add(y);
		
		System.out.println("input is " + e);
		System.out.println(!(done.contains(e)));
		if (!(done.contains(e))) {
			done.add(e);
			
			ArrayList<Integer> t = new ArrayList<Integer>();
			int a = 0;
			int b = 0;
			int p = power.get(index);
			for (int i = 0; i < location.size(); i++) {
				t = location.get(i);
				a = t.get(0);
				b = t.get(1);
				
				if ((a-x)*(a-x) + (b-y)*(b-y) <= p*p) {
					if (!(reached.contains(t))) {
						reached.add(t);
					}
					System.out.println("a = " + a + ", b = " + b + ", i = " + i + ", num = " + num);
					System.out.println("called from inside the method");
					search(a, b, i, num + 1);
				}
			}
		}
	}
}
