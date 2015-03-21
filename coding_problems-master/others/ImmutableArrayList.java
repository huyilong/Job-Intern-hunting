//Medallia

public class ImmutableArrayList{
	private final ArrayList<Integer> list;

	ImmutableArrayList(ArrayList<Integer> listArg){
		this.list = Collections.unmodifiableList(listArg)
	}

	public int get(int index){
		if(index < list.size()){
			return list.get(index);
		}else{
			return Integer.MIN_VALUE;
		}
	}
}