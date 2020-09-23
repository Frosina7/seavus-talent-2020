import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
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

         List<String>output= (max==0 && min==0)?list.stream().collect(Collectors.toList())
                : min == 0 ?list.stream().filter(word-> word.length() <= max).collect(Collectors.toList())
                : max == 0 ?list.stream().filter(word-> word.length() >= min).collect(Collectors.toList())
                : list.stream().filter(word -> word.length() >= min).filter(word -> word.length() <= max).collect(Collectors.toList());


        if (order.equals("ascending")) {

            Collections.sort(output, (String s1, String s2) -> s1.length() - s2.length());

        } else if (order.equals("descending")) {

            Collections.sort(output, (String s1, String s2) -> (s2.length()-s1.length()));

        } else {

            System.out.println("Please type ascending or descending order .");
            return;

        }

        output.stream().distinct().forEach(System.out::println);

    }


}

