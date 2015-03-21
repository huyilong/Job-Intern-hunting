//find two numbers that sum to target

//solution1: use hashmap
//solution2: sort and then use two pointers


public class TwoSum{
	public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int len = numbers.length;
        for(int i=0; i<len; i++){
            if(map.containsKey(numbers[i])){
                int[] res = new int[2];
                res[0] = map.get(numbers[i])+1;
                res[1] = i+1;
                return res;
            }else{
                map.put(target-numbers[i],i);
            }
        }
        return null;
    }

    public int[] twoSum(int[] numbers, int target){
		int len = numbers.length;
		int[] sorted = new int[len];
		System.arraycopy(numbers,0,sorted,0,len);
		Arrays.sort(sorted);
		
		int front = 0;
		int end = len - 1;
		
		while(front < end){
		    if(sorted[front]+sorted[end] < target){
		        front++;
		        continue;
		    }else if(sorted[front]+sorted[end] > target){
		        end--;
		        continue;
		    }else{
		        break;
		    }
		}
		
		int n1 = sorted[front];
		int n2 = sorted[end];
		int idx1 = -1;
		int idx2 = -1;
		
		for(int i=0; i<len; i++){
		    if(numbers[i]==n1 || numbers[i]==n2){
		        if(idx1 == -1){
		            idx1 = i;
		        }else if(idx2 == -1){
		            idx2 = i;
		        }else{
		            break;
		        }
		    }
		}
		
		int[] res = new int[]{idx1+1,idx2+1};
		Arrays.sort(res);
		return res;
	}
}