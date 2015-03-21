/**
 * Problem: Design a min stack that operates in O(1) time
 *
 * Solution: use additional stack to track min element
 */

public class MinStack{
	public Stack<Integer> s = new Stack<Integer>();
	public Stack<Integer> tracker = new Stack<Integer>();

	public void push(int x){
		if(s.empty() || (tracker.peek()!=null && x<=tracker.peek())){
			tracker.push(x);
		}
		s.push(x);
	}

	public void pop(){
		if(s.empty()){
			return;
		}
		int item = s.pop();
		if(item == tracker.peek()){
			tracker.pop();
		}
	}

	public int top(){
		return s.peek();
	}

	public int getMin(){
		return tracker.peek();
	}
}