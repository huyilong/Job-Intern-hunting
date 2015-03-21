//Given a set of distinct integers, return all possible subsets

public class Subsets{
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S==null || S.length==0){
            return res;
        }
        ArrayList<Integer> temp = new ArrayList<Integer>();
        //make substs in non-descending order
        Arrays.sort(S);
        int len = S.length;
        //empty set
        res.add(temp);
        generate(res,temp,S,0,len);
        return res;
    }
    
    public void generate(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] S, int start, int len){
       for(int i=start; i<len; i++){
           temp.add(S[i]);
           //adding only one element generates a subset
           res.add(new ArrayList<Integer>(temp));
           //adding elements after current elements to generate more subsets
           generate(res,temp,S,i+1,len);
           //remove current element and try next one
           temp.remove(temp.size()-1);
       }
    }
}