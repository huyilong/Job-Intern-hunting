/**
 * Problem: Hanoi Tower
 *
 * Solution: Move top n-1 elements to another tower using a buffer
 *           then move bottom element to destination
 *           then move n-1 elements to destination
 */
public class HanoiTower{
	public static void main(String[] args){
		Tower[] towers = new Tower[3];
		for(int i=0; i<3; i++){
			towers[i] = new Tower(i);
		}

		for(int i=5; i>0; i--){
			towers[0].insert(i);
		}
		towers[0].moveTo(5,towers[1],towers[2]);
	}

}

class Tower{
	public Stack s;
	public int index;

	public Tower(int index){
		this.s = new Stack();
		this.index = index;
	}

	public void insert(int data){
		//make sure the order is correct
		if(!s.isEmpty() && s.peek()<data){
			System.out.println("ERROR: cannot put larger disk on smaller disk");
		}else{
			s.push(data);
		}
	}
    
    //move top element to another tower
	public void move(Tower t){
		int data = s.pop();
		t.insert(data);
		System.out.println("Moving " + data + "from Tower " + index + " to Tower " + t.index);
	}

	public void moveTo(int n, Tower buf, Tower dest){
		if(n > 0){
			//move top n-1 elements to buf using dest as buffer
			moveTo(n-1,dest,buf);
			//move bottom element to dest
			move(dest);
			//move n-1 elements in buf to dest using current tower as buffer
			buf.moveTo(n-1,this,dest);
		}
	}
}


