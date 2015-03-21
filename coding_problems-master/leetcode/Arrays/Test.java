public class Test{
	public static void main(String[] args){
		StringBuffer buf = new StringBuffer();
		buf.append("hello");
		String s = buf.toString();
		buf.deleteCharAt(buf.length()-1);
		System.out.println(s);
	}

}