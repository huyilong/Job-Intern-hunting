/**
 * Problem: sort stack in ascending order, only allow additional stacks
 *
 * Solution: use additional stack, pop from original stack and insert into
 *           the right place in the additional stack
 */

public class SortStack{
	public static void main(String[] args){
		Stack s = new Stack();
		s.push(7);
		s.push(10);
		s.push(18);
		s.push(1);
		Stack sorted = sort(s);
		while(!sorted.isEmpty()){
			System.out.println(sorted.pop());
		}
	}

	public static Stack sort(Stack s){
		if(s.isEmpty()){
			return null;
		}
		Stack sorted = new Stack();
		sorted.push(s.pop());
		while(!s.isEmpty()){
			int temp = s.pop();
			//find right place for temp, push other elements into s
			while(!sorted.isEmpty() && temp < sorted.peek()){
				s.push(sorted.pop());
			}
			sorted.push(temp);
		}
		return sorted;
	}
}