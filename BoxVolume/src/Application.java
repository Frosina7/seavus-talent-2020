import java.util.Scanner;

public class Application extends Box {
    public static void main(String[] args) {
        int h = new Scanner(System.in).nextInt();
        int w = new Scanner(System.in).nextInt();
        int d = new Scanner(System.in).nextInt();

        Box box = new Box(h, w, d);

        System.out.println(box.findVolume(h, w, d));
    }
}
