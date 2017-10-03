package yiji.calc;
public class Token{
	public static final int INTEGER=1;
	public static final int DOUBLE=2;
	public static final int ADD=3;
	public static final int SUB=4;
	public static final int MUL=5;
	public static final int DIV=6;
	public static final int FUNC=7;
	public static final int LBK=8;
	public static final int RBK=9;
	public static final int SPL=10;
	public static final int VAR=11;
	public int type;
	public int i;
	public double d;
	public String str;
	public boolean func_has_no_param=false;
}
