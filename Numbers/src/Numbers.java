import java.io.IOException;
import java.util.Scanner;

public class Numbers {

	public static void main(String[] args)throws IOException {
	
	String s=new Scanner(System.in).nextLine();
	
	String[] s1=s.split(" ");
	
	for (int i = 0; i < s1.length; i++) 
	{
		switch(s1[i])
		{
		case "one":
			 System.out.print("1");
			 break;
			
		case "two":
			
			System.out.print("2");
			break;
		
		case "three":
			
			System.out.print("3");
			break;
		
		case "four":
			
			System.out.print("4");
			break;
		
		case "five":
			
			System.out.print("5");
			break;

		case "six":
			
			System.out.print("6");
			break;
			
		case "seven":
			
			System.out.print("7");
			break;
		
		case "eight":
			
			System.out.print("8");
			break;
		
		case "nine":
			
			System.out.print("9");
			break;
		case "zero":
			
			System.out.print("0");
			break;
		
		}

	}
	
		
		
	}
}

