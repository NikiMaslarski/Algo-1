public class BST {

  public static class Node {

    public int value;
    public Node left;
    public Node right;
  }

  // Checks if a binary tree is a binary search tree.
  public boolean isBST(Node root) {
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }
 
  private boolean isValidBST(Node node, int MIN, int MAX) {
	     if(node == null)
	         return true;
	     if(node.value > MIN 
	         && node.value < MAX
	         && isValidBST(node.left, MIN, Math.min(node.value,MAX))
	         && isValidBST(node.right, Math.max(node.value,MIN), MAX))
	         return true;
	     else 
	         return false;
	}
}
