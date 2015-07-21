import java.io.*;
import java.util.StringTokenizer;

public class PowerSupply {
	
	public static int biggestVertex;
	

	public static void main(String[] args) {

		MyScanner sc = new MyScanner();
		out = new PrintWriter(new BufferedOutputStream(System.out));

		int numOfEdges = sc.nextInt();
		int neighboursMatrix[][] = new int[numOfEdges][numOfEdges];
		
		biggestVertex = 0;

		for (int i = 0; i < neighboursMatrix.length; ++i) {
			for (int j = 0; j < neighboursMatrix[i].length; ++j)
				neighboursMatrix[i][j] = Integer.MAX_VALUE;
			neighboursMatrix[i][i] = 0;
		}

		int i1, i2, value;
		for (int i = 0; i < numOfEdges; ++i) {
			i1 = sc.nextInt();
			i2 = sc.nextInt();
			value = sc.nextInt();
			
			if(biggestVertex < Math.max(i1, i1))
				biggestVertex = Math.max(i1, i2);

			neighboursMatrix[i1][i2] = value;
			neighboursMatrix[i2][i1] = value;
		}
		
//		for (int i = 0; i < 10; ++i) {
//			System.out.println(Arrays.toString(neighboursMatrix[i]));
//		}
		
		System.out.println(minCableNeeded(neighboursMatrix, 1));
		

		out.close();
	}
	
	public static int minCableNeeded(int[][] matrix, int root){
		int neighbours[] = new int[biggestVertex + 1];
		boolean used[] = new boolean[biggestVertex + 1];
		used[root] = true;
		neighbours[0] = root;
		int numberOfVerteciesInMST = 1;
		
		int valueOfEdges = 0;
		
		int newVertex = 1;
		int minEdge;
		
		for(int i = 0; i < biggestVertex - 1; ++i){
			minEdge = Integer.MAX_VALUE;
			for(int j = 0; j < numberOfVerteciesInMST; ++j){
				int currentVertex = neighbours[j];

				for(int k = 0; k <= biggestVertex; ++k){
					if(matrix[currentVertex][k] != 0 && !used[k] && matrix[currentVertex][k] < minEdge){
						minEdge = matrix[currentVertex][k];
						newVertex = k;
					}
				}
			}
			valueOfEdges += minEdge;
			neighbours[numberOfVerteciesInMST++] = newVertex;
			used[newVertex] = true;
		}
		return valueOfEdges;
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