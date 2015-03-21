public class Stack{
	Node top;

	public Stack(){
		this.top = null;
	}

	public int pop(){
		if(top != null){
			int item = top.data;
			top = top.next;
			return item;
		}
		return -1;
	}

	public void push(int item){
		Node t = new Node(item);
		t.next = top;
		top = t;
	}

	public int peek(){
		if(top != null){
			return top.data;
		}
		return -1;
	}

	public boolean isEmpty(){
		return top==null;
	}

}