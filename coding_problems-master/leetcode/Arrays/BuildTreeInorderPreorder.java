//build tree using inorder and preorder traversal

public class BuildTreeInorderPreorder{
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = inorder.length;
        //store index of node in inorder traversal
        for(int i=0; i<len; i++){
            map.put(inorder[i],i);
        }
        //use two parameters for each traversal to limit the range
        return build(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    
    public TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, HashMap<Integer,Integer> map){
        if(preLeft>preRight || inLeft>inRight){
            return null;
        }
        //first element of preorder is root
        TreeNode root = new TreeNode(preorder[preLeft]);
        //find index of root in inorder traveral, left part builds left subtree
        //and right part builds right subtree
        int rootIdx = map.get(root.val);
        //use rootIdx to compute correct range in preorder traversal for left and right subtree
        root.left = build(preorder,preLeft+1,preLeft+rootIdx-inLeft,inorder,inLeft,rootIdx-1,map);
        root.right = build(preorder,preLeft+rootIdx-inLeft+1,preRight,inorder,rootIdx+1,inRight,map);
        return root;
    }
}