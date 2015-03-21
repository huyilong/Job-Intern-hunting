

public class DoublyList{
	public ListNode head;

	public DoublyList(ListNode head){
		this.head = head;
	}

	public DoublyList(int[] arr){
		if(arr.length==0 || arr==null){
			return;
		}
		this.head = new ListNode(arr[0],null,null);
		ListNode curr = this.head;
		for(int i=1; i<arr.length; i++){
			curr.next = new ListNode(arr[i],curr,null);
			curr = curr.next;
		}
	}

	public String print(){
		ListNode curr = this.head;
		StringBuffer buf = new StringBuffer();
		while(curr.next != null){
			buf.append(curr.data + "->");
			curr = curr.next;
		}
		buf.append(curr.data);
		return buf.toString();
	}
}