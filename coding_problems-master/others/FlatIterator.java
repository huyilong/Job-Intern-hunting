import java.util.*;





public class FlatIterator{
	public static void main(String[] args){
		ArrayList<String> l1 = new ArrayList<String>();
		l1.add("3");
		l1.add("4");
		l1.add("5");

		ArrayList<String> l2 = new ArrayList<String>();
		l2.add("4");
		l2.add("5");
		l2.add("5");

		ArrayList<String> l3 = new ArrayList<String>();

		ArrayList<String> l4 = new ArrayList<String>();
		l2.add("1");
		l2.add("2");
		l2.add("3");

		ArrayList<String> l5 = new ArrayList<String>();

	   ArrayList<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
	   l.add(l1);
	   l.add(l2);
	   l.add(l3);
	   l.add(l4);
	   l.add(l5);
       
       ArrayList<Iterator<String>> temp = new ArrayList<Iterator<String>>();
       for(ArrayList<String> curr: l){
       	   temp.add(curr.iterator());
       }

	   Iterator<Iterator<String>> iters = temp.iterator();

	   Iterator<String> test = flatten(iters);

	   while(test.hasNext()){
	   	   System.out.println(test.next());
	   }

	}



	
	private static Iterator<String> flatten(Iterator<Iterator<String>> iters){
		final Iterator<Iterator<String>> nested = iters;

		return new Iterator<String>(){
			Iterator<String> curr = null;

			public boolean hasNext(){
				//stop getting next iterator in the nested iterator until one of condition hold
				//(1) nested is null
				//(2) nested doesn't have next iterator
				//(3) current iterator is not null and it has next element
				while(nested!=null && nested.hasNext() && (curr==null || !curr.hasNext())){
					curr = nested.next();
				}
				//check the third condition to return result
				return curr!=null && curr.hasNext();
			}
            
            //this implementation assumes user will check iter.hasNext() before
            //doing iter.next(); otherwise, we need to add a condition checking if
            //curr.hasNext() and throw exception if it is false
			public String next(){
				return curr.next();
			}


			public void remove(){
				curr.remove();
			}
		};
	}
}


