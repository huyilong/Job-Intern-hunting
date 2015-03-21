public class GraphNode{
	public GraphNode[] adjacent;
	public int data;
	public int index;
	public boolean visited;

	public GraphNode(int data, int adjacentSize){
		this.data = data;
		this.index = 0;
		this.visited = false;
		if(adjacentSize != 0){
		   this.adjacent = new GraphNode[adjacentSize];
		}
	}

	public void add(GraphNode n){
		this.adjacent[index] = n;
		this.index ++;
	}

	public GraphNode[] getAdjacent(){
		return this.adjacent;
	}

	public int getData(){
		return this.data;
	}

	public void visit(){
		this.visited = true;
	}

	public boolean hasAdjacent(){
		return this.index != 0;
	}
}