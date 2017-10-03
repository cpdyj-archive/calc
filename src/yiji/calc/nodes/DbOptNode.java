package yiji.calc.nodes;
public class DbOptNode extends TreeNode
{
	public static final int ADD=3;
	public static final int SUB=4;
	public static final int MUL=5;
	public static final int DIV=6;
	public static final int SPL=10;
	public int type;
	public TreeNode left,right;
	public DbOptNode(int type,TreeNode l,TreeNode r){
		this.type=type;
		this.left=l;
		this.right=r;
	}
}
