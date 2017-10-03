package yiji.calc;
import java.util.*;
import yiji.calc.nodes.*;
public class ASTParser
{
	Stack<TreeNode> nodes=new Stack<TreeNode>();
	public TreeNode parseToAST(ArrayList<Token> tokenlist){
		for(Token tk:tokenlist){
			switch(tk.type){
				case Token.INTEGER:
					nodes.push(new NumberNode(tk.i));
					break;
				case Token.DOUBLE:
					nodes.push(new NumberNode(tk.d));
					break;
				case Token.VAR:
					nodes.push(new VarNode(tk.str));
					break;
				case Token.ADD:
				case Token.SUB:
				case Token.MUL:
				case Token.DIV:
				case Token.SPL:
					nodes.push(getDbOptNode(tk.type));
					break;
				case Token.FUNC:
					//TODO
					nodes.push(getFuncCallNode(tk.str,tk.func_has_no_param));
					break;
			}
		}
		return nodes.pop();
	}
	private FuncCallNode getFuncCallNode(String name,boolean hasNoParam){
		FuncCallNode fcn=new FuncCallNode();
		fcn.func_name=name;
		if(hasNoParam){
			//function without parameter.
			return fcn;
		}else if((nodes.peek() instanceof DbOptNode)&&((DbOptNode)nodes.peek()).type==DbOptNode.SPL){
			//if the top node is a function parameter separator.
			DbOptNode temp=(DbOptNode)nodes.pop();
			while(temp!=null&&temp.type==DbOptNode.SPL){
				fcn.parameters.add(temp.left);
				if(temp.right instanceof DbOptNode){
					temp=(DbOptNode)temp.right;
				}
			}
			fcn.parameters.add(temp.right);
		}else{
			//the function has only one parameter.
			fcn.parameters=new ArrayList<TreeNode>();
			fcn.parameters.add(nodes.pop());
		}
		fcn.parameters_quantity=fcn.parameters.size();
		return fcn;
	}
	private DbOptNode getDbOptNode(int type){
		TreeNode b=nodes.pop();
		TreeNode a=nodes.pop();
		return new DbOptNode(type,a,b);
	}
}
