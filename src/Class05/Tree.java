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

	}
	
	public void inOrder(TreeNode root) {

	}
	
	public void postOrder(TreeNode root) {

	}
	
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	public boolean isBalanced(TreeNode root) {
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
	
	public boolean isSymmetric(TreeNode root) {
		// Write your solution here
		if (root == null)
			return true;
		return symmetricCheck(root.left, root.right);
	}

	public boolean symmetricCheck(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true; // base case 1
		} else if (left == null || right == null) {
			return false; // base case 2 + 3
		} else if (left.key != right.key) {
			return false; // base case
		}

		return symmetricCheck(left.left, right.right) && symmetricCheck(left.right, right.left);
	}
	
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		}
		else if (one == null || two == null) {
			return false;
		}
		else if (one.key != two.key) {
			return false;
		}
		
		return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right) || 
				isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
		
	}
}

class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
}
