/**
 * Problem: delete the middle node in the singly list
 *          given only access to that node
 *
 * Solution: copy data of next node to middle node
 */
public class DeleteMidNode{
	public static void main(String[] args){
		SinglyList l1 = new SinglyList(new int[]{1,2,3,4,5});
		System.out.println(l1.print());
		deleteMid(l1.head.next.next);
		System.out.println(l1.print());
	}

	public static void deleteMid(ListNode mid){
		//the only element in the list
		if(mid.next == null){
			return;
		}
		//copy data into middle node
		mid.data = mid.next.data;
		//"remove" middle node
		mid.next = mid.next.next;
	}


}