import java.util.*;
/**
 * Problem: implement a stack with min() function, operate in O(1) time
 *
 * Solution: use additional stack to track min
 */

public class minStack{
	public Stack repo;
	public Stack min;

	public minStack(){
		this.repo = new Stack();
		this.min = new Stack();
	}

	public void push(int item){
		if(repo.isEmpty()){
			min.push(item);
		}else{
			//if a smaller item is pushed to stack, push it to min stack
			if(item <= min.peek()){
				min.push(item);
			}
		}
		repo.push(item);
	}

	public int pop(){
		int item = repo.pop();
		//if min is poped, pop it from min stack
		if(item == min.peek()){
			min.pop();
		}
		return item;
	}

	public int min(){
		return min.peek();
	}
}