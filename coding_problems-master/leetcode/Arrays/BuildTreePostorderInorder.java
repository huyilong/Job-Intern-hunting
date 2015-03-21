//build tree using postorder and inorder traversal

public class BuildTreePostorderInorder{
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = inorder.length;
        for(int i=0; i<len; i++){
            map.put(inorder[i],i);
        }
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
    }
    
    public TreeNode build(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight, HashMap<Integer,Integer> map){
        if(inLeft>inRight || postLeft>postRight){
            return null;
        }
        //last element of postorder is the root
        TreeNode root = new TreeNode(postorder[postRight]);
        //get root index
        int rootIdx = map.get(root.val);
        //build subtree
        root.left = build(inorder,inLeft,rootIdx-1,postorder,postLeft,postLeft+rootIdx-inLeft-1,map);
        root.right = build(inorder,rootIdx+1,inRight,postorder,postLeft+rootIdx-inLeft,postRight-1,map);
        return root;
    }
}