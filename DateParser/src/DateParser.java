import java.util.Scanner;

public class DateParser {

    public static void main(String[] args) {

        String s = new Scanner(System.in).nextLine();

        System.out.println(s.substring(0, 2) + " " + s.substring(3, 5) + " " + s.substring(6, s.length()));


    }
}
