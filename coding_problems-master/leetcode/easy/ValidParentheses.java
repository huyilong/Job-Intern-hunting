/**
 * Problem: Determine if the parentheses combination is valid
 *
 * Solution: use stack to store left parentheses and traverse the string to match right parentheses with top element in the stack
 */

public class ValidParentheses{
	public boolean isValid(String s){
		if(s == null){
			return false;
		}
		char[] arr = s.toCharArray();
		//pre-check
		if(arr.length%2 != 0 || arr.length==0){
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for(char c: arr){
			//push left part into stack
			if(c=='(' || c=='{' || c=='['){
                stack.push(c);
			}else{
				//right part matches with stack
				if(!stack.isEmpty() && match(stack.peek(),c)){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
    
    //determine if left and right part matches
	public boolean match(char left, char right){
		return (left=='('&&right==')') || (left=='['&&right==']') || (left=='{'&&right=='}');
	}
}