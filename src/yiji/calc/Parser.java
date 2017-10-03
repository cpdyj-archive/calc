package yiji.calc;
import java.util.*;

public class Parser{
	public ArrayList<Token> compile(String src){
		//TODO
		ArrayList<Token> a=TokenParser.getTokens(src);
		Stack<Token> s=new RPNParser().parseToRPN(a);
		return null;
	}
}
