
import java.util.*;
import java.util.regex.*;


/*
 constructor: Init and check the source String is legal.
 getTokens: Parse the string to tokens list.
 Use regex to split the string to a token string.
 Call getTk to parse the token string to a token object.
 At the end of return the tokens list.
 getTk: Parse the token string to a Token object.
 */
public class TokenParser
{
	public static ArrayList<Token> getTokens(String src){
		if(src==null){
			throw new NullPointerException();
		}
		Pattern token_pattern=Pattern.compile("\\d+(\\.\\d+)?|\\+|\\-|\\*|\\/|\\(|\\)|[A-z]+\\(|,");
		Matcher matcher=token_pattern.matcher(src);
		ArrayList<Token> tks=new ArrayList<Token>();
		//use regex split the string.
		while(matcher.find()){
			//getTk return the Token object , add it to list.
			tks.add(getTk(matcher.group()));
		}
		return tks;
	}
	private static Token getTk(String s){
		Token tk=new Token();
		int ch=s.charAt(0);
		//if parser ok, return immediately.
		//Operater
		switch(ch){
			case '+':
				tk.type = Token.ADD;
				return tk;
			case '-':
				tk.type = Token.SUB;
				return tk;
			case '*':
				tk.type = Token.MUL;
				return tk;
			case '/':
				tk.type = Token.DIV;
				return tk;
			case '(':
				tk.type = Token.LBK;
				return tk;
			case ')':
				tk.type = Token.RBK;
				return tk;
			case ',':
				tk.type=Token.SPL;
				return tk;
		}
		//Function
		//if the first character is a letter.
		if((ch > 64 & ch < 91) | (ch > 96 & ch < 123)){
			//TODO
			tk.type=Token.FUNC;
			tk.str=s.substring(0,s.length()-1);//remove the left bracket.
			return tk;
		}
		try{
			//Integer
			//if not find '.'
			if(s.indexOf('.') == -1){
				tk.i = Integer.parseInt(s);
				tk.type = Token.INTEGER;
			}else{
				//or it  maybe a double
				tk.d = Double.parseDouble(s);
				tk.type = Token.DOUBLE;
			}
		}catch(NumberFormatException ex){
			//TODO may throw it. Don't pass it.
		}
		return tk;
	}
}
