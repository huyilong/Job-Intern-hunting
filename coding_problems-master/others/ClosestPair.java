//Medallia
//find shortest distance between two words
//question: does word order matter?

//follow-up: minimum distance between a value in listA and a value in listB, 
//           we can merge two lists in sorted order with list tag. 

public class ClosestPair{
	public static void main(String[] args){
		String[] words = new String[]{"apple","orange","banana","apple"};
		System.out.println(closestDistance(words,"apple","orange"));

	}

	public static int closestDistance(String[] words, String word1, String word2){
		int res = Integer.MAX_VALUE;
		int w1 = -1;
		int w2 = -1;
		int len = words.length;
		for(int i=0; i<len; i++){
			String curr = words[i];
			if(curr.equals(word1)){
				w1 = i;
				int distance = w1 - w2;
				if(w2>=0 && distance<res){
					res = distance;
				}
			}else if(curr.equals(word2)){
				w2 = i;
				int distance = w2 - w1;
				if(w1>=0 && distance<res){
					res = distance;
				}
			}
		}
		return res;
	}

}