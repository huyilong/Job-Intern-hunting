//Medallia

//build tree using inorder and preorder traversal

public class BuildTreeInorderPreorder{
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length==0){
            return null;
        }
        return buildTreeHelper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd){
        if(pStart > pEnd){
            return null;
        }
        int rootIdx = 0;
        //find root index in inorder traversal
        for(int i=iStart; i<=iEnd; i++){
            if(inorder[i] == preorder[pStart]){
                rootIdx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = buildTreeHelper(preorder,pStart+1,pStart+rootIdx-iStart, inorder, iStart, rootIdx-1);
        root.right = buildTreeHelper(preorder, pStart+rootIdx-iStart+1, pEnd, inorder, rootIdx+1, iEnd);
        return root;
        
    }
}