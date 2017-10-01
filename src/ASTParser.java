import java.util.*;
public class ASTParser
{
	public TreeNode parseToAST(ArrayList<Token> tokenlist){
		Stack<TreeNode> nodes=new Stack<TreeNode>();
		for(Token tk:tokenlist){
			switch(tk.type){
				case Token.INTEGER:

			}
		}
		return nodes.pop();
	}
}
