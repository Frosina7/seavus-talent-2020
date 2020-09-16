import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void getChar(String s) {

        HashMap<Character, Integer> table = new HashMap<>();

        char[] s1 = s.toCharArray();

        for (char character : s1) {
            if (table.containsKey(character)) {
                table.put(character, table.get(character) + 1);
            } else {
                table.put(character, 1);
            }
        }

        for (Map.Entry e : table.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }


    }

    public static void main(String[] args) {

        String s = new Scanner(System.in).nextLine();

        getChar(s);

    }

}
