package Class03;

public class LinkedList {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		
		one.next = two;
		two.next = three;
		three.next = four;
		
		System.out.println("one's next: " + one.next.value);
		System.out.println("two's next: " + two.next.value);
		System.out.println("three's next: " + three.next.value);
		
		LinkedList ll = new LinkedList();
		ll.middleNode(one);
		
		System.out.println(ll.middleNode(one).value);

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
//		if (one == null) {
//			return two;
//		}
//		if (two == null) {
//			return one;
//		}
		
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		while (one != null && two != null) {
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
		
		// link the remaining possible nodes
		if (one != null) {
			cur.next = one;
		} 
		else {
			cur.next = two;
		}
		
		return dummy.next;
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
