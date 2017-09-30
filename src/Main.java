import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello World!");

		Scanner input = new Scanner(System.in);
		
		Parser p=new Parser();
		p.compile("(3+5)*2-func(2+3)");
	}
}
