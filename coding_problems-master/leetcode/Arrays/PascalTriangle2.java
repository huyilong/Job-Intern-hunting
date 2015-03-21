//generate certain row of Pascal Triangle

public class PascalTriangle{
	 public ArrayList<Integer> getRow(int rowIndex){
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(rowIndex < 0){
			return result;
		}
		result.add(1);
		if(rowIndex == 0){
			return result;
		}
		for(int i=1; i<=rowIndex; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(1);
			for(int j=1; j<result.size(); j++){
				temp.add(result.get(j-1)+result.get(j));
			}
			temp.add(1);
			result = temp;
		}
		return result;
	}
}