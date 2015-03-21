//Binary Tree Level Order Traversal

public class BinaryTreeLevelOrder{
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        //store nodes in a level
        ArrayList<Integer> level = new ArrayList<Integer>();
        //store nodes in current level
        Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
        //store nodes in next level
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
        currLevel.offer(root);
        
        while(!currLevel.isEmpty()){
            TreeNode curr = currLevel.poll();
            level.add(curr.val);
            
            //add children to next level queue
            if(curr.left != null){
                nextLevel.add(curr.left);
            }
            
            if(curr.right != null){
                nextLevel.add(curr.right);
            }
            
            //when finish traversing current level, update current level to be next level
            //and store level list to result, lastly, clear level list and next level queue for next round
            if(currLevel.isEmpty()){
            	//note that we need to make a copy before clearing the contents
                currLevel = new LinkedList<TreeNode>(nextLevel);
                nextLevel.clear();
                res.add(new ArrayList<Integer>(level));
                level.clear();
            }
        }
        return res;
    }
}