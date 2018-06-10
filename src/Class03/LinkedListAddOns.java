package Class03;

public class LinkedListAddOns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
//		
		ListNode four = new ListNode(7);
		//ListNode five = new ListNode(5);
		
		one.next = two;
		two.next = three;
		three.next = four;
		//four.next = five;
		//five.next = six;
		//five.next = six;
		
		LinkedListAddOns ll = new LinkedListAddOns();
		//System.out.println("Middle node: " + ll.findMiddle(one).value);
		ll.remove(one, 2);
		
		System.out.println("Expected: 7, Output: " + one.next.value);
		//System.out.println("Expected: 3, Output: " + four.next.value);
		//System.out.println("Expected: 2, Output: " + three.next.value);
		//System.out.println("Expected: 6, Output: " + five.next.value);
		
		//System.out.println(7/10);
		
	}
	
	public ListNode findMiddle(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public ListNode merge(ListNode one, ListNode two) {
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
		
		if ( one != null) {
			cur.next = one;
		}
		else {
			cur.next = two;
		}
		return dummy.next;
	}
	
	public ListNode mergeLL(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		// find the middle nodes 
		ListNode mid = findMiddle(head);
		
		// split the list into two & disconnect;
		ListNode rightHalf = mid.next;
		mid.next = null;
		// go to left & right
		ListNode left = mergeLL(head);
		ListNode right = mergeLL(rightHalf);
	
		return merge(left, right);	
	}
	
	
	// do follow up problem!
	// Algorithm: We can simple reverse the list, calculate the result, and reverse the result.
	public ListNode addTwo(ListNode one, ListNode two) {
		int carry = 0;
		
		ListNode dummy = new ListNode(0);
		ListNode curOne = one;
		ListNode curTwo = two;
		ListNode cur = dummy;
		while (curOne != null || curTwo != null) {
			if (curOne != null) {
				carry += curOne.value;
				curOne = curOne.next;
			}
			
			if (curTwo != null) {
				carry += curTwo.value;
				curTwo = curTwo.next;
			}
			
			//System.out.println("carry # here is .. " + carry);
			cur.next = new ListNode(carry%10);
			cur = cur.next;
			carry /= 10;
		}
		
		if (carry == 1) {
			cur.next = new ListNode(1);
		}
		return dummy.next;
	}
	
	public ListNode reverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		
		return prev;
	}
	
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		ListNode mid = findMiddle(head);
		ListNode right = mid.next;
		mid.next = null; // disconnect list #1
		ListNode rightHead = reverse(right); // keymistake, didn't save this
		
		ListNode first = head;
		ListNode second = rightHead;
		while (second != null) {
			if (first.value != second.value) {
				return false;
			}
			first = first.next;
			second = second.next;
		}
		
		return true;
	}
	
	public ListNode remove(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (head != null) {
			if (head.value == n) {
				cur.next = head.next;
				head = head.next;
				cur = cur.next;
			}
			else {
				head = head.next;
			}
		}
		
		return dummy.next;
	}
	
	//public ListNode removeNthFromEnd(ListNode head, int n) {
		
	
}
