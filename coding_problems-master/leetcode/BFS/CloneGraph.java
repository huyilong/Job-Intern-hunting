//Clone Graph

public class CloneGraph{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        //store neighbors
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        //map (original node, copy node)
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        q.offer(node);
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(node, newHead);
        
        while(!q.isEmpty()){
            UndirectedGraphNode curr = q.poll();
            List<UndirectedGraphNode> neighbors = curr.neighbors;
            
            for(UndirectedGraphNode aNeighbor: neighbors){
                //map does not contain (original,copy) pair
                if(!map.containsKey(aNeighbor)){
                    //make a copy
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor, copy);
                    //add copied neighbor to current copied node
                    map.get(curr).neighbors.add(copy);
                    q.offer(aNeighbor);
                }else{
                    map.get(curr).neighbors.add(map.get(aNeighbor));
                }
            }
        }
        return newHead;
    }
}