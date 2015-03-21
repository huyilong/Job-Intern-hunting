//partition the list given a value, preserving original relative order

//create a new list picking smaller nodes in the original list

public class PartitionList{
    public ListNode partition(ListNode head, int x){
    	if(head==null){
    		return null;
    	}
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode iter = dummy;
    	ListNode connect = null;
    	ListNode res = null;
    	ListNode resIter = null;
    	while(iter!=null){
    		//attach smaller nodes to another list
    		if(iter.next!=null && iter.next.val < x){
    			if(res==null){
    				res = iter.next;
    				resIter = res;
    			}else{
    				resIter.next = iter.next;
    				resIter = resIter.next;
    			}
    			iter.next = iter.next.next;
    		}else{
    			if(connect==null){
    				connect = iter.next;
    			}
    			iter = iter.next;
    		}
    	}
    	//return the new list if not empty
    	if(resIter!=null){
    	  resIter.next = connect;
    	  return res;
    	}else{
    		return head;
    	}
    }
}