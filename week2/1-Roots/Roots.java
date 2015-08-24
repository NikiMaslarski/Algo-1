import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Roots {

	private static double PRECISION = 0.000000001;
	
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		long input = sc.nextLong();
		System.out.printf("%.5f\n",FindRoot(input));
	}

	public static double FindRoot(long number) {
		return RRoot((double) number, 0, (double) number);
	}

	private static double RRoot(double number, double lo, double hi) {
		double middle = (hi + lo) / 2;
		double deviation = number - middle * middle;

		if (Math.abs(deviation) < PRECISION)
			return middle;

		if (deviation < 0)
			return RRoot(number, lo, middle);

		if (deviation > 0)
			return RRoot(number, middle, hi);

		return -1;
	}
	

	// -------------------------------------------------------------

	public static PrintWriter out;

	public static class MyScanner {
		BufferedReader br;
		StringTokenizer st;

		public MyScanner() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

	// ------------------------------------------------------------------
}
