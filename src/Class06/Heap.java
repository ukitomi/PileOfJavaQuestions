package Class06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Find the K smallest numbers in an unsorted integer array A. The returned
	// numbers should be in ascending order.
	// Method: k sized max heap
	public int[] kSmallest(int[] array, int k) {
		if (array.length == 0 || k == 0) {
			return new int[0];
		}

		// create a PQ & min heap
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;
			}
		});

		// heapify the whole array into the heap with time complexity O(n)
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				// offer the first k elements into max heap
				// only way to utilize heapify(), the only thing you can do is
				// to
				// call a certain constructor
				maxHeap.offer(array[i]);
			} else if (array[i] < maxHeap.peek()) {
				// for the other elements, only offer it into the maxheap if
				// it is smaller than the max value in the max heap
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}

		// pop k times to get the k smallest elements
		int[] result = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			result[i] = maxHeap.poll();
		}

		return result;
	}

	public int kthSmallest(int[][] matrix, int k) {
		// Write your solution here
		int row = matrix.length;
		int column = matrix[0].length;

		// perform Best First Search here
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
			@Override
			public int compare(Cell o1, Cell o2) {
				// TODO Auto-generated method stub
				if (o1.value == o1.value) {
					return 0;
				}
				return o1.value < o2.value ? -1 : 1;
			}
		});

		// all the visited ones will be marked true
		// so it cannot be GENERATE more than once
		boolean[][] visited = new boolean[row][column];
		minHeap.offer(new Cell(0, 0, matrix[0][0]));
		visited[0][0] = true;

		// iterate k-1 rounds, and BFS the smallest k-1 element/cell.
		for (int i = 0; i < k - 1; i++) {
			Cell cur = minHeap.poll();
			// the neighbor cell will be inserted back to the minHeap if..
			// 1. it is not out of boundary
			// 2. it has not been generated before
			// for each cell, it can be generated twice.
			if (cur.row + 1 < row && !visited[cur.row + 1][cur.column]) {
				minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
				visited[cur.row + 1][cur.column] = true;
			}

			if (cur.column + 1 < column && !visited[cur.row][cur.column + 1]) {
				minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
				visited[cur.row][cur.column + 1] = true;
			}
		}

		return minHeap.peek().value;

	}

	static class Cell {
		int row;
		int column;
		int value;

		Cell(int row, int column, int value) {
			this.row = row;
			this.column = column;
			this.value = value;
		}
	}

	public boolean isCompleted(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		boolean flag = false;
		q.offer(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();

			// if any child is not present, set flag = true;
			if (cur.left == null) {
				flag = true;
			} else if (flag) {
				// if flag is set but we still see cur has a left child
				// then it's not a complete binary tree
				return false;
			} else {
				q.offer(cur.left);
			}

			// same logic applied to right child
			if (cur.right == null) {
				flag = true;
			} else if (flag) {
				return false;
			} else {
				q.offer(cur.right);
			}
		}

		return true;
	}

	// get keys in binary tree layer by layer
	public List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		while (!q.isEmpty()) {
			// the list storing all the nodes on the current level
			List<Integer> curLayer = new ArrayList<Integer>();

			// size of current level
			int size = q.size();

			// traverse all the nodes on the current level and prepare for next
			// level
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				curLayer.add(cur.key);
				if (cur.left != null) {
					q.offer(cur.left);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				}
			}
			list.add(curLayer);
		}

		return list;
	}

	public boolean isBipartite(List<GraphNode> graph) {
		HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
		for (GraphNode node : graph) {
			if (!BFS(node, visited)) {
				return false;
			}
		}

		return true;
	}
	
	private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
		
		// if this node already has been traversed, no need to do this again
		if (visited.containsKey(node)) {
			return true;
		}
		
		Queue<GraphNode> q = new LinkedList<GraphNode>();
		q.offer(node);
		
		// start breadth-first-search from the node, since the node has not been visited,
		// we can assign it to any of the groups, e.g., group 0.
		visited.put(node, 0);
		
		while(!q.isEmpty()) {
			GraphNode cur = q.poll();
			
			// the group assigned for cur node
			int curGroup = visited.get(cur);
			
			// the group assigned for any neighbor of cur node
			int neiGroup = curGroup == 0 ? 1 : 0;
			
			for (GraphNode nei : cur.neighbors) {
				// if the neighbor has not been visited, put in the queue and choose the correct group
				if (!visited.containsKey(nei)) {
					visited.put(nei, neiGroup);
					q.offer(nei);
				}
				else if (visited.get(nei) != neiGroup) {
					// only if the neighbor has been traversed and the group does not match
					// to the desire one, return false
					return false;
				}
				// if the neighbor has been traversed and the group matches the desired one,
				// we dont need to do anything.
			}
		}
		return true;
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

class GraphNode {
	public int key;
	public List<GraphNode> neighbors;

	public GraphNode(int key) {
		this.key = key;
		this.neighbors = new ArrayList<GraphNode>();
	}
}