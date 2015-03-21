/**
 * Problem: Given a directed graph, determine if there is a route
 *          between two nodes
 * Solution: simple BFS approach, remember to mark node visited to avoid loop
 *
 */

public class hasRoute{
	public static void main(String[] args){
		//graph without loop
		GraphNode n0 = new GraphNode(0,2);
		GraphNode n1 = new GraphNode(1,1);
		GraphNode n2 = new GraphNode(2,2);
		GraphNode n3 = new GraphNode(3,0);
		GraphNode n4 = new GraphNode(4,0);
		n0.add(n1); n0.add(n4);
		n1.add(n3);
		n2.add(n1); n2.add(n4);
		//System.out.println(route(n0,n3));
        
        //test graph with a loop
		GraphNode x0 = new GraphNode(0,1);
		GraphNode x1 = new GraphNode(1,1);
		GraphNode x2 = new GraphNode(2,0);
		x0.add(x1);
		x1.add(x0);
		System.out.println(route(x0,x2));
	}

	public static boolean route(GraphNode x, GraphNode y){
		if(x==null || y==null){
			return false;
		}
		Queue q = new Queue();
		q.enqueue(x);
		while(!q.isEmpty()){
			GraphNode curr = (GraphNode)q.dequeue();
			curr.visit();
			if(curr.data == y.data){
				return true;
			}
			if(curr.hasAdjacent()){
				for(GraphNode n: curr.getAdjacent()){
					if(!n.visited){
					   q.enqueue(n);
					   System.out.println("enqueue: " + n.data);
					}
				}
		    }
		}
		return false;
	}

}