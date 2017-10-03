package yiji.calc.nodes;
import java.util.*;
public class FuncCallNode extends TreeNode
{
	public int parameters_quantity;
	public String func_name;
	public ArrayList<TreeNode> parameters;
}
