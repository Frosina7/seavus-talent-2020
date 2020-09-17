import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter if you want your words to be sorted in ascending or descending order : ");

        String order = new Scanner(System.in).nextLine();

        System.out.print("Specify your minimum length of printed words : ");

        Integer min = new Scanner(System.in).nextInt();

        System.out.print("Specify your maximum length of printed words : ");

        Integer max = new Scanner(System.in).nextInt();

        File file = new File("file.txt");

        String string = FileUtils.readFileToString(file, "UTF-8");

        String result = string.replaceAll("[^a-zA-z]", " ");

        List<String> list = Arrays.asList(result.split(" "));

        List<String> output = list.stream().filter(word -> word.length() >= min).filter(word -> word.length() <= max).collect(Collectors.toList());

        if (min == 0) {

            output = list.stream().filter(word -> word.length() <= max).collect(Collectors.toList());

        } else if (max == 0) {

            output = list.stream().filter(word -> word.length() >= min).collect(Collectors.toList());

        }

        if (order.equals("ascending")) {

            Collections.sort(output, Comparator.comparingInt(o -> o.length()));

        } else if (order.equals("descending")) {

            Collections.sort(output, Collections.reverseOrder(Comparator.comparingInt(o -> o.length())));

        } else {

            System.out.println("Please type ascending or descending order .");
            return;

        }

        output.stream().distinct().forEach(System.out::println);


    }


}
