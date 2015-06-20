import java.util.List;

public class KLists {

	public class Node {
		public int value;
		public Node next;
	}
	
	// Merge K sorted lists.
	public Node merge(List<Node> lists) {
		Node result = new Node();
		int indexOfSmallest;
		int smallestValue;
		boolean flag = true;
		
		while(flag){
			indexOfSmallest = 0;
			smallestValue = lists.get(0).value;
			for(int i = 0; i < lists.size(); ++i){
				if(lists.get(i).value < smallestValue){
					smallestValue = lists.get(i).value;
					indexOfSmallest = i;
				}
			}
			
			addToList(result, smallestValue);
			
			if(lists.get(indexOfSmallest).next != null)
				lists.set(indexOfSmallest, lists.get(indexOfSmallest).next);
			else{
				lists.remove(indexOfSmallest);
			}
		}
	}
	
	private void addToList(Node list, int value){
		Node temp = new Node();
		temp.value =  value;
		Node current = list;
		while(current.next != null)
			current = current.next;
		current.next = temp;
	}

}