//Given a set of integers that might contains duplicates, return all possible subsets

public class Subsets2{
	 public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        res.add(temp);
        if(num==null || num.length==0){
            return res;
        }
        Arrays.sort(num);
        int len = num.length;
        generate(res,temp,num,0,len);
        return res;
    }
    
    public void generate(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] num, int start, int len){
        for(int i=start; i<len; i++){
            temp.add(num[i]);
            res.add(new ArrayList<Integer>(temp));
            generate(res,temp,num,i+1,len);
            temp.remove(temp.size()-1);
            //not use same number twice in a row
            while(i<len-1 && num[i]==num[i+1]){
                i++;
            }
        }
    }
}