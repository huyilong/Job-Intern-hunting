//find majority element in the array

//use Moore's Voting algorithm: idea is to cancel out occurence of element e 
//by occurence of elements different from e, then e will exist if it is majority element

public class MajorityElement{
	 public int majorityElement(int[] num) {
        int len = num.length;
        if(len == 1){
            return num[0];
        }
        int majority = findMajority(num,len);
        int freq = 0;
        for(int i=0; i<len; i++){
            if(num[i] == majority){
                freq ++;
            }
            if(freq > Math.floor(len/2)){
                return majority;
            }
        }
        return majority;
    }
    
    public int findMajority(int[] num, int len){
        int count = 1;
        int majorityIdx = 0;
        for(int i=1; i<len; i++){
            if(num[i] == num[majorityIdx]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majorityIdx = i;
                count = 1;
            }
        }
        return num[majorityIdx];
    }
}