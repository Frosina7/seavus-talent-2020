import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void getChar(String s) {

        HashMap<String, Integer> table = new HashMap<>();

        String[] s1 = s.split(" ");

        for (String string : s1) {
            string = string.toLowerCase();
            if (table.containsKey(string)) {
                table.put(string, table.get(string) + 1);
            } else {
                table.put(string, 1);
            }
        }


        for (Map.Entry e : table.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }


    }

    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        String string = FileUtils.readFileToString(file, (String) null);
        String result = string.replaceAll("[^a-zA-z]", " ");
        getChar(result);
    }


}
