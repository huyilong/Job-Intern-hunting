/**
 * Problem: Level order traversal from bottom up
 *
 * Solution: similar to previous questions, just adding level data at the head of result list
 */

public class TreeLevelOrder2{
	public LinkedList<LinkedList<Integer>> levelOrderBottom(TreeNode root){
		LinkedList<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
		if(root == null){
			return result;
		}
		Queue<TreeNode> levelNode = new LinkedList<TreeNode>();
		levelNode.offer(root);
	
		//continue until no node at level
		while(levelNode.size() != 0){
			LinkedList<Integer> levelData = new LinkedList<Integer>();
			//store child nodes into levelNode
			int size = levelNode.size();
			for(int i=0; i<size; i++){
				TreeNode parent = levelNode.poll();
				//retrieve data
				levelData.add(parent.val);
				if(parent.left != null){
					levelNode.offer(parent.left);
				}
				if(parent.right != null){
					levelNode.offer(parent.right);
				}
			}
			//add level data to result list
			result.add(0,levelData);
		}
		return result;
	}
}