//Binary Tree Zig Zag Level Order Traversal

public class ZigZagLevelOrder{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        boolean leftToRight = true;
        ArrayList<Integer> level = new ArrayList<Integer>();
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        currLevel.push(root);
        
        while(!currLevel.isEmpty()){
            TreeNode curr = currLevel.pop();
            level.add(curr.val);

            //if order of current level is left from right
            //visit left child first and then right child;
            //if current order is from right to left, do the opposite
            if(leftToRight){
                if(curr.left != null){
                    nextLevel.push(curr.left);
                }
                if(curr.right != null){
                    nextLevel.push(curr.right);
                }
            }else{
                if(curr.right != null){
                    nextLevel.push(curr.right);
                }
                if(curr.left != null){
                    nextLevel.push(curr.left);
                }
            }
            
            if(currLevel.isEmpty()){
                Stack<TreeNode> copy = new Stack<TreeNode>();
                copy.addAll(nextLevel);
                currLevel = copy;
                nextLevel.clear();
                res.add(new ArrayList<Integer>(level));
                level.clear();
                leftToRight = !leftToRight;
            }
            
        }
        return res;
    }
}