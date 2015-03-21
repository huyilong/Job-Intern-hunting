/**
 * Problem: Simplify absolute path for a file
 *
 * Solution: Use a stack to push directories, if see ../, then pop from stack to go back 
 */
import java.util.*;
public class SimplifyPath{
	public String simplifyPath(String path){
		if(path==null || path.length()==0){
			return "";
		}
		StringBuilder buf = new StringBuilder();
		Stack<String> s = new Stack<String>();
		//split by / and considfer multiple / as one
		String[] split = path.split("\\/+");
		int len = split.length;
        
        //push directories to stack and pop from stack if see ../
		for(int i=1; i<len; i++){
			if(split[i].equals(".")){
				continue;
			}else if(split[i].equals("..")){
				if(!s.isEmpty()){
					s.pop();
				}
			}else{
				s.push(split[i]);
			}
		}

		if(s.isEmpty()){
			return "/";

		}
        //simplify path
		while(!s.isEmpty()){
			buf.insert(0,s.pop());
			buf.insert(0,"/");
		}
		return buf.toString();

	}
}