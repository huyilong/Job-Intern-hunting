/**
 * Problem: Evaluate postfix equals
 *
 * Solution: Use a stack to store numbers, if see an operator, pop two numbers from stack,
 *           perform the operation and push result onto stack
 */

import java.util.*;
public class ReversePolishNotation{
	public int evalRPN(String[] tokens){
		if(tokens==null || tokens.length==0){
			return 0;
		}
		Stack<Integer> s = new Stack<Integer>();
		for(String str: tokens){
			if(str.equals("+")){
				s.push(s.pop() + s.pop());
			}else if(str.equals("-")){
				int a = s.pop();
				int b = s.pop();
				s.push(b-a);
			}else if(str.equals("*")){
                s.push(s.pop()*s.pop());
			}else if(str.equals("/")){
				int a = s.pop();
				int b = s.pop();
				s.push(b/a);
			}else{
				s.push(Integer.valueOf(str));
			}
		}
		return s.pop();
	}
}