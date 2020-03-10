import java.awt.HeadlessException;
import java.util.Scanner;

class Box{
	
	Integer height;
	Integer width;
	Integer depth;
	
	public Box(Integer height,Integer width,Integer depth)
	{
		height=this.height;
		width=this.width;
		depth=this.depth;
	}
	
}

public class Application{
	
	public static void main(String[] args) {
		
	int h=new Scanner(System.in).nextInt();
	int w=new Scanner(System.in).nextInt();
	int d=new Scanner(System.in).nextInt();
	
	Box a=new Box(h, w, d);
	
	Integer volume=h*w*d;
	
	System.out.println(volume);

	}

}
