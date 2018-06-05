package Class03;

import java.util.LinkedList;

public class QueueByTwoStacks {

	private LinkedList<Integer> in; // we always insert into the stack
	private LinkedList<Integer> out; // we always delete from the stack

	public QueueByTwoStacks() {
		in = new LinkedList<Integer>();
		out = new LinkedList<Integer>();
	}

	public Integer poll() { // delete
		if (out.size() == 0) {
			while (!in.isEmpty()) {
				out.push(in.poll());
			}
		}
		return out.pollFirst();
	}

	public void offer(int element) { // add
		in.offerFirst(element);

	}

	public Integer peek() { // look at the first element
		if (out.size() == 0) {
			while (!in.isEmpty()) {
				out.push(in.poll());
			}
		}
		return out.peekFirst();
	}

	public int size() {
		return in.size() + out.size();
	}

	public boolean isEmpty() {
		return in.size() == 0 && out.size() == 0;
	}
}
