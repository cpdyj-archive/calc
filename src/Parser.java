
import java.util.*;
import java.util.regex.*;

public class Parser{
	public ArrayList<Token> compile(String src){
		//TODO
		ArrayList<Token> a=TokenParser.getTokens(src);
		Stack<Token> s=parseToRPN(a);
		return null;
	}
	private HashMap<Integer,Integer> pri=new HashMap<Integer,Integer>();
	public Parser(){
		pri.put(Token.MUL,3);
		pri.put(Token.DIV,3);
		pri.put(Token.ADD,2);
		pri.put(Token.SUB,2);
		pri.put(Token.SPL,1);
		pri.put(Token.INTEGER,0);
		pri.put(Token.DOUBLE,0);
		pri.put(Token.LBK,0);
		pri.put(Token.FUNC,0);
		
	}
	private Stack<Token> parseToRPN(ArrayList<Token> tokenlist){
		Stack<Token> ops=new Stack<Token>();
		Stack<Token> nums=new Stack<Token>();
		for(Token tk:tokenlist){
			switch(tk.type){
				case Token.INTEGER:
				case Token.DOUBLE:
					nums.push(tk);
					break;
				case Token.LBK:
				case Token.FUNC:
					ops.push(tk);
					break;
				case Token.RBK:
					while(!ops.isEmpty()){
						Token temp=ops.pop();
						if(temp.type == Token.LBK){
							break;
						}else if(temp.type == Token.FUNC){
							nums.push(temp);
							break;
						}
						nums.push(temp);
					}
					break;
				case Token.MUL:
				case Token.DIV:
				case Token.ADD:
				case Token.SUB:
				case Token.SPL:
					while(!(ops.isEmpty())&&getpri(tk)<getpri(ops.peek())){
						nums.push(ops.pop());
					}
					ops.push(tk);
			}
		}
		while(!ops.isEmpty()){
			nums.push(ops.pop());
		}
		return nums;
	}
	private int getpri(Token tk){
		return pri.get(tk.type);
	}
}
