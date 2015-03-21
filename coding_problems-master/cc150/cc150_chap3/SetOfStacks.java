/**
 * Problem: implement a set of stacks with pop() and push(item)
 *          follow-up: popAt(index) function
 *
 * Solution: array of stacks with certain threshold
 *           popAt(): afer poping from intermediate stack, transfer elements
 *                    from other stacks to fill in the blank
 */

public class SetOfStacks{
	public int threshold;
	public int maxSize;
	public int size;
	public Stack[] storage;
	public int[] capacity;

	public SetOfStacks(int maxSize, int threshold){
		this.maxSize = maxSize;
		this.threshold = threshold;
		this.size = 0;
		this.storage = new Stack[size];
		this.capacity = new int[size];
	}

	public void push(int item){
		storage[size].push(item);
		capacity[size]++;
		if(capacity[size] == threshold){
			size ++;
		}
		if(size = maxSize){
			System.out.println("SetOfStack is full");
		}
	}

	public int pop(){
		if(size==0 && capacity[size]==0){
			return -1;
		}
		if(capacity[size]==0 && size>=1){
			size --;
		}
		capacity[size] --;
		return storage[size].pop();
	}

	public int popAt(int index){
		if(index > size){
			System.out.println("ERROR: index not exist");
			return -1;
		}
		if(index == size){
			return storage[size].pop();
		}else{
			int result = storage[index].pop();
			//fill in the blank
			for(int i=index; i<size; i++){
				int bottom = popBottom(i+1);
				if(bottom != -1){
				   storage[i].push(popBottom(i+1))
				}
			}
			return result;
		}
	}
    
    //pop bottom element from stack at index
	public int popBottom(int index){
		if(capacity[index] == 0){
			return -1;
		}
		Stack temp = new Stack();
		while(!storage[index].isEmpty()){
			temp.push(storage.pop());
		}
		int result = temp.pop();
		while(!temp.isEmpty()){
			storage[index].push(temp.pop());
		}
		return result;
	}
}