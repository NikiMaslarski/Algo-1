import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class ClosestCoffeeStore {
	private static class Node {
		int current;
		Node next;

		public Node(int value) {
			this.current = value;
		}

	}

	private static Node insert(Node root, int element) {
		Node temp = new Node(element);
		temp.next = root;
		return temp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Node[] neighborList = new Node[size];
		int temp;

		for (int i = 0; i < size; ++i) {
			for (int j = 0; j < size; ++j) {
				temp = sc.nextInt();
				if (temp == 1) {
					neighborList[i] = insert(neighborList[i], j);
				}
			}
		}
		int startingPoint = sc.nextInt();

		boolean[] isCoffeStore = new boolean[size];
		for (int i = 0; i < size; ++i)
			if (sc.nextInt() == 1)
				isCoffeStore[i] = true;


		System.out.println(closestCoffeeStore(neighborList, isCoffeStore,
				startingPoint));

		sc.close();
	}

	public static int closestCoffeeStore(Node[] graph, boolean[] isCoffeStore,
			int startingPoint) {

		int size = graph.length;
		int current;

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean color[] = new boolean[size]; // false = white, true = black

		queue.add(startingPoint);
		color[startingPoint] = true;

		while (!queue.isEmpty()) {
			current = queue.poll();
			for (Node i = graph[current]; i != null; i = i.next) {
				
				if(isCoffeStore[i.current])
					return i.current;
				
				if (!color[i.current]) {
					queue.add(i.current);
					color[i.current] = true;
				}
			}
		}
		return -1;
	}
}
