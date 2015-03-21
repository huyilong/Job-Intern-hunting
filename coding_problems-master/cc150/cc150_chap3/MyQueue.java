/**
 * Problem: implement a queue using two stacks
 *
 * Solution: when enqueue, push to s1; when dequeue, pop from s1 and push to s2
 *           and then pop from s2 as return value
 */

public class MyQueue{
	public Stack s1;
	public Stack s2;

	public MyQueue(){
		this.s1 = new Stack();
		this.s2 = new Stack();
	}

	public void enqueue(int item){
		s1.push(item);
	}

	public int dequeue(){
		if(s2.isEmpty()){
			while(!s1.isEmpty()){
				s2.push(s1.pop());
			}
		}
		return s2.pop();
	}
}