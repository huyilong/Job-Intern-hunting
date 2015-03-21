//list node contains random pointer, return a deep copy of the list

public class CopyRandomList{
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }
        //map to store (node,copy) pairs
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode res = new RandomListNode(head.label);
        map.put(head,res);
        RandomListNode resIter = res;
        RandomListNode iter = head.next;
        //traverse the original list, store (node,copy) in the map
        //this time, only build the singly linked list
        while(iter!=null){
            RandomListNode copy = new RandomListNode(iter.label);
            map.put(iter,copy);
            resIter.next = copy;
            resIter = resIter.next;
            iter = iter.next;
        }
        iter = head;
        resIter = res;
        //add random pointer to each copy node
        while(iter!=null){
            resIter.random = map.get(iter.random);
            resIter = resIter.next;
            iter = iter.next;
        }
        return res;
    }


    public RandomListNode copyRandomList(RandomListNode head) {
        if(head==null){
            return null;
        }else if(head.next==null){
            return new RandomListNode(head.label);
        }
        RandomListNode iter = head;
        //first round, build oscillating list structure
        while(iter!=null){
            RandomListNode copy = new RandomListNode(iter.label);
            copy.next = iter.next;
            iter.next = copy;
            iter = copy.next;
        }
        
        iter = head;
        //second round, add random pointers to copies
        while(iter!=null){
            if(iter.random != null){
               iter.next.random = iter.random.next;
            }
            //dont need to check if iter.next is null because of even length
            iter = iter.next.next;
        }
        
        //third round, detach two lists
        iter = head;
        RandomListNode res = head.next;

        while(iter!=null){
            RandomListNode copyNode = iter.next;
            iter.next = copyNode.next;
            if(copyNode.next != null){
                copyNode.next = copyNode.next.next;
            }
            iter = iter.next;
        }
        return res;
    }
}