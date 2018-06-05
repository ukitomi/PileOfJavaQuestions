package Class03;

import java.util.Deque;
import java.util.LinkedList;

public class stackWithMin {

	private Deque<Integer> stack;
	private Deque<Integer> minStack;
	public stackWithMin(){
		stack = new LinkedList<Integer>();
		minStack = new LinkedList<Integer>();
	}
	
	// delete, handle duplicates
	// when the pop value is the same as top value of the stack,
	// value need to be pop from minstack as well
	public Integer pop() {
		if (stack.isEmpty()) {
			return null;
		}
		
		Integer poll = stack.pollFirst(); // retrieve and delete
		if (minStack.peekFirst().equals(poll)) {
			minStack.pollFirst();
		}
		
		return poll;
	}

	// we push when element is small than the first value at minstack 
	public void push(int element) {
		//stack.push(element);
		stack.offerFirst(element);  // Offerfirst: Inserts the specified element at the front of this list.
		
		// watch out for duplicates
		if (element <= minStack.peekFirst() || minStack.isEmpty()) {
			minStack.push(element);
		}
		// not necessary
//		else {
//			stack.push(element);
//		}
	}

	// peek top
	public Integer top() {
		if (stack.isEmpty()) {
			return null;
		}
		return stack.peekFirst();
	}

	public Integer min() {
		if (minStack.isEmpty()) {
			return null;
		}
		
		return minStack.peekFirst();
	}

}
