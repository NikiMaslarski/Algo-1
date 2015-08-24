import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BirthdayRanges {
	public static void main(String[] args) {

		MyScanner sc = new MyScanner();
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] birthdays = new int[N];
		int[][] ranges = new int[M][2];

		for (int i = 0; i < N; ++i)
			birthdays[i] = sc.nextInt();

		for (int i = 0; i < M; ++i) {
			ranges[i][0] = sc.nextInt();
			ranges[i][1] = sc.nextInt();
		}

		int birthdayUntillDay[] = new int[366];
		birthdayUntillDay = countBirthdays(birthdays);

		for (int i = 0; i < M; ++i) {
			System.out.println(birthdayUntillDay[ranges[i][1]]
					- birthdayUntillDay[ranges[i][0]]
					+ birthdayUntillDay[ranges[i][0]]
					- birthdayUntillDay[ranges[i][0] - 1]);
		}
	}

	private static int[] countBirthdays(int[] birthdays) {
		int temp[] = new int[366];
		for (int i : birthdays)
			temp[i]++;

		for (int i = 0; i < 365; ++i)
			temp[i + 1] += temp[i];

		return temp;
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
