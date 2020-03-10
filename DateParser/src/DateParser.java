import java.util.Scanner;

import static java.lang.System.*;

import java.io.IOException;

public class DateParser {

    public static void main(String []args)throws IOException
    {
        String s=new Scanner(System.in).nextLine();

        String[] s1=s.split("/");
        
        System.out.println(s.substring(0,2)+" "+s.substring(3,5)+" "+s.substring(6,s.length()));
         
 

    }
}
