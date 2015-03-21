/** 
 * Problem: Replace space with %20, enough space at the end of string
 *          Perform in place, assume actual length of the string is given
 *
 * Solution: scan to count spaces, then edit from end to the start
 */  
public class ReplaceSpace{
	public static void main(String[] args){
		String s = "Mr John Smith      ";
		char[] test = s.toCharArray();
		replace(test,13);
		for(char c: test){
			System.out.print(c);
		}
		System.out.println();

	}

	public static void replace(char[] arr, int length){
		int spaceCount = 0;
		//count number of space
		for(int i=0; i<length; i++){
			if(arr[i] == ' '){
				spaceCount ++;
			}
		}
		//compute new length
		int k = length + 2*spaceCount;
		arr[k] = '\0';
		//traverse the string backwards
		for(int i=length-1; i>=0; i--){
			//if space found, add %20 to the end
			if(arr[i] == ' '){
				arr[k-1] = '0';
				arr[k-2] = '2';
				arr[k-3] = '%';
				k = k - 3;
			//if character found, add it to the end
			}else{
				arr[k-1] = arr[i];
				k --;
			}
		}
	}


}