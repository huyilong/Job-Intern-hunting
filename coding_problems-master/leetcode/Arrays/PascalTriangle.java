//generate Pascal Triangle by the given number of rows

//list(i) = prevlist(i-1) + prevlist(i)


import java.util.*;
public class PascalTriangle{
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows <= 0){
            return res;
        }
        for(int row=0; row<numRows; row++){
            int size = row + 1;
            ArrayList<Integer> list = new ArrayList<Integer>(size);
            list.add(1);
            for(int k=1; k<size-1; k++){
                list.add(res.get(row-1).get(k-1) + res.get(row-1).get(k));
            }
            if(size > 1){
                list.add(1);
            }
            res.add(list);
        }
        return res;
    }
}