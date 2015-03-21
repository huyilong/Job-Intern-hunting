//Binary Tree Level Order Traversal from Bottom

public class BinaryTreeLevelOrderBottom{
	 public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
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
                res.add(0,new ArrayList<Integer>(level));
                level.clear();
            }
        }
        return res;  
    }
    
    //recursive approach
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        helper(root, res, 1);
        return res;
    }
    
    public void helper(TreeNode root, ArrayList<ArrayList<Integer>> res, int depth){
        if(root == null){
            return;
        }
        ArrayList<Integer> level;
        //create a new list for level if not exist before
        if(res.size() < depth){
            level = new ArrayList<Integer>();
            res.add(0,level);
        }else{
            level = res.get(res.size()-depth);
        }
        level.add(root.val);
        helper(root.left, res, depth+1);
        helper(root.right, res, depth+1);
    }
}