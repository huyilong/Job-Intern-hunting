/**
 * List Node implementation
 *
 */
public class ListNode{
	public ListNode prev;
	public ListNode next;
	public int data;

	public ListNode(int data){
		this.data = data;
		this.prev = null;
		this.next = null;
	}

	public ListNode(int data, ListNode prev, ListNode next){
		this.data = data;
		this.prev = prev;
		this.next = next;
	}

	public ListNode cloneForward(){
		if(this == null){
			return null;
		}
		ListNode cloneHead = this;
		ListNode cloneCurr = cloneHead;
		ListNode curr = this.next;
		while(curr != null){
			cloneCurr.next = curr;
			cloneCurr = cloneCurr.next;
			curr = curr.next;
		}
		return cloneHead;
	}

	public String printForward(){
		if(this.next != null){
			return this.data + "->" + this.next.printForward();
		}else{
			return ((Integer)this.data).toString();
		}
	}

}