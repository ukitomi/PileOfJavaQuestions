package Class05;

public class Tree {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode eight = new TreeNode(8);
		TreeNode nine = new TreeNode(9);
		TreeNode three2 = new TreeNode(3);
		TreeNode one2 = new TreeNode(1);
		TreeNode four2 = new TreeNode(4);
		
		five.left = three;
		five.right = three2;
		three.left = one;
		three.right = four;
		three2.left = four2;
		three2.right = one2;
		
		Tree t = new Tree();
		System.out.println(t.getHeight(five));
	}
	
	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		System.out.println(root.value);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.value);
	}
	
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public boolean isBalanced(TreeNode root) {
//		if (getHeight(root.left) - getHeight(root.right) > 1) {
//			return false;
//		}
//		return true;
		
		if (root == null) {
			return true;
		}
		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (Math.abs(left - right) > 1) {
			return false;
		}
		return true;
	}
	
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true; // base case 1
		}
		else if (left == null || right == null) {
			return false; // base case 2 + 3 
		}
		else if (left.value != right.value) {
			return false; // base case
		}
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
