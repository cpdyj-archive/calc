package yiji.calc.nodes;
public class NumberNode extends  TreeNode
{
	public static final int INTEGER=1;
	public static final int DOUBLE=2;
	public int type;
	public int i;
	public double d;
	public NumberNode(int i){
		type=INTEGER;
		this.i=i;
	}
	public NumberNode(double d){
		type=DOUBLE;
		this.d=d;
	}
}
