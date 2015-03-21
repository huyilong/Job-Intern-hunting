//merge intervals in the list

public class MergeInterval{
   public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
	    if(intervals == null || intervals.size()<=1){
	        return intervals;
	    }
	    //sort intervals by starting position
	    Collections.sort(intervals, new IntervalComparator());
	    int size = intervals.size();
	    
	    ArrayList<Interval> res = new ArrayList<Interval>();
	    Interval prev = intervals.get(0);
	    
	    for(int i=1; i<size; i++){
	        Interval curr = intervals.get(i);
	        //merge
	        if(curr.start <= prev.end){
	            //create merged interval and set prev to merged interval
	            Interval merge = new Interval(prev.start,Math.max(curr.end,prev.end));
	            prev = merge;
	        }else{
	            //add interval to list if cannot merge and upate prev
	            res.add(prev);
	            prev = curr;
	        }
	    }
	    res.add(prev);
	    return res;
   }
}

class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval i1, Interval i2){
        return i1.start - i2.start;
    }
}