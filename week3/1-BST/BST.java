public class BST {

  public static class Node {

    public int value;
    public Node left;
    public Node right;
  }

  // Checks if a binary tree is a binary search tree.
  public boolean isBST(Node root) {
    if(root.left != null){
    	if(root.left.value <= root.value)
    		isBST(root.left);
    	else
    		return false;
    }
    if(root.right != null){
    	if(root.right.value >= root.value)
    		isBST(root.right);
    	else
    		return false;
    }
    return true;
    
  }
}
