package Class03;

public class LinkedList {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(3);
		ListNode three = new ListNode(5);
		
		one.next = two;
		two.next = three;
		
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(6);
		ListNode six = new ListNode(8);
		
		four.next = five;
		five.next = six;
		
		LinkedList ll = new LinkedList();
		
		
		System.out.println(ll.merge(one, four).value);

//		System.out.println("two's next: " + two.next.value);
//		System.out.println("three's next: " + three.next.value);
//		System.out.println("four's next: " + four.next.value);
		
		
	}
	
	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
//	public ListNode reverse2(ListNode head) {
//		if (head == null || head.next == null) {
//			return head;
//		}
//	}
	
	public ListNode middleNode(ListNode head) {
		if(head == null) {
			return null;
		}
		
		ListNode i = head;
		ListNode j = head;
		while ( j.next != null && j.next.next != null) {
			i = i.next;
			j = j.next.next;
		}
		
		return i;
	}
	
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}
		ListNode i = head;
		ListNode j = head;
		while ( j != null && j.next != null) {
			i = i.next;
			j = j.next.next;
			if (i  == j ) {
				return true;
			}
		}
		
		return false;
	}
	
	public ListNode insert(ListNode head, int value) {
		ListNode add = new ListNode(value);
		if (head == null || head.value >= value) {
			add.next = head;
			return add;
		}
		
		ListNode prev = head;
		// need to remember the prev and next position
		// inserting on the right side
		while (prev.next != null && prev.next.value < value) {
			prev = prev.next;
		}
		add.next = prev.next;
		prev.next = add;
		return head;
	}
	
	public ListNode merge(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (one.next != null && two.next != null) {
			if (one.value <= two.value) {
				cur.next = one;
				one = one.next;
			}
			else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		
		// if there is remaining elements
		if (one.next != null) {
			cur.next = one;
		}
		else {
			cur.next = two;
		}
		return dummy.next;
	}
	
	/*
	public ListNode reorder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// step 1: find the middle nodes and split
		ListNode slow = head;
		ListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = null;
		ListNode two = slow.next;

		// reversed the second linkedlist
		ListNode prev = null;
		while (two.next != null && two.next.next != null) {
			ListNode next = two.next;
			two.next = prev;
			prev = two;
			two = next;
		}
		
		// merge the two linkedlist 
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int counter = 0;
		while ( head.next != null && two.next != null) {
			if (counter % 2 == 0) {
				cur.next = head;
				head = head.next;
			}
			else {
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		
		// add remaining elements 
		if (head.next != null) {
			cur.next = head;
		}
		else {
			cur.next = two;
		}
	
		return dummy.next;
	} */
	
	public ListNode reorder(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode mid = middleNode(head);
		ListNode one = head;
		ListNode two = mid.next;
		
		// disconnect from the original ll
		mid.next = null;
	
		return mergeReorder(one, reverse(two));
	}
	
	public ListNode mergeReorder(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (one != null && two != null) {
			cur.next = one;
			one = one.next;
			cur.next.next = two;
			two = two.next;
			cur = cur.next.next;
		}
		
		// link remaining elements
		if (one != null) {
			cur.next = one;
		}
		else {
			cur.next = two;
		}
		
		return dummy.next;
	}
	
	
	// Given a linked list and a target value T, partition it such that all nodes
	// less than T are listed before the nodes larger than or equal to target value
	// T. The original relative order of the nodes in each of the two partitions
	// should be preserved.
	public ListNode partition(ListNode head, int target) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		// you dont want to do small.next because you want to keep the head reference
		ListNode small = new ListNode(0);
		ListNode large = new ListNode(0);
		ListNode curSmall = small;
		ListNode curLarge = large;
		while (head != null) {
			if (head.value < target) {
				curSmall.next = head;
				curSmall = curSmall.next;
			}
			else { //  head.value >= target
				curLarge.next = head;
				curLarge = curLarge.next;
			}
			head = head.next;
		}
		
		// join the small's tail to large's head
		// it's large.next because large is ListNode(0);
		curSmall.next = large.next;
		
		// disconnect large.next to null because it might still be pointing to head
		curLarge.next = null;
		
		// return small.next instead of small
		// because small = new ListNode(0)
		return small.next;
	}

}

class ListNode {
	int value;
	public ListNode next;
	
	public ListNode(int value) {
		this.value = value;
		next = null;
	}
	
	
}
