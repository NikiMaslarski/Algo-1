import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class ValidDirectories {

	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		int N = sc.nextInt();
		int[][] graph = new int[N][N];

		for (int i = 0; i < N; ++i)
			for (int j = 0; j < N; ++j)
				graph[i][j] = sc.nextInt();

		if (isValid(graph))
			System.out.println("true");
		else
			System.out.println("false");

	}

	public static boolean isValid(int[][] graph) {
		Stack<Integer> stack = new Stack<Integer>();
		int[] color = new int[graph.length];
		for (int i = 0; i < graph.length; ++i) {
			if (color[i] == 0) {
				stack.push(i);
				color[i] = 1;
				if(!RDFS(graph, stack, color))
					return false;
			}
		}
		return true;
	}

	private static boolean RDFS(int[][] graph, Stack<Integer> stack, int[] color){
		int current = stack.pop();
		for(int i = 0; i < graph.length; ++i){
			if(graph[current][i] == 2)
				return true;
			
			if(graph[current][i] == 1){
				if(color[i] != 0)
					return false; //there is a cycle
				else{
					stack.push(i);
					return RDFS(graph, stack, color);
				}
			}
		}
		return true;
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
