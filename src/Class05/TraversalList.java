package Class05;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TraversalList {

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
		
		TraversalList t = new TraversalList();
		t.printLevelOrder(five);
	}
	
	
	// iterative solution
	public List<Integer> preOrder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			list.add(cur.key);
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
		}
		
		return list;
	}
	
	public List<Integer> inOrder(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode helper = root;
		
		while ( helper != null || !stack.isEmpty()) {
			if (helper != null) {
				stack.offerFirst(helper);
				helper = helper.left;
			}
			else // left subtree of the root is finished 
			{
				TreeNode parent = stack.pollFirst();
				list.add(parent.key);
				helper = parent.right;
				
			}
		}
		
		return list;
	}

	public void printLevelOrder(TreeNode root) {
		int h = getHeight(root);
		for (int i = 1; i <= h; i++) {
			printGivenLevel(root, i);
		}
	}
	
	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
    public void printGivenLevel(TreeNode root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.key + " ");
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
	
}
