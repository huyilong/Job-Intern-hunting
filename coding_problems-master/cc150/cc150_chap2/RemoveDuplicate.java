/**
 * Problem: remove duplicate in linked list
 *
 * Solution: two pointers, one to track each data, one to remove duplicate
 */
public class RemoveDuplicate{
	public static void main(String[] args){
		DoublyList l1 = new DoublyList(new int[]{5,5,5,2,5,2,5,2,1});
		System.out.println(l1.print());
		removeDup(l1.head);
		System.out.println(l1.print());
		
	}

	public static void removeDup(ListNode head){
		//traverse each different data
		ListNode curr = head;
		//traverse forward and remove duplicate
		ListNode temp = curr.next;
		while(curr!=null && curr.next != null){
			temp = curr.next;
			while(temp != null){
				if(temp.data == curr.data){
					temp = deleteNode(temp);
				}else{
					temp = temp.next;
				}
			}
			curr = curr.next;
		}

	}
    
    //delete the node, return the next node
	public static ListNode deleteNode(ListNode n){
		if(n == null){
			return null;
		//last node in the list
		}else if(n.next == null){
			n.prev.next = null;
		}else{
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
		return n.next;
	}
}