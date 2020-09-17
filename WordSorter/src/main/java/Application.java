import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Application {

    public static void main(String[] args) throws IOException {

        System.out.print("Enter if you want your words to be sorted in ascending or descending order : ");

        String order = new Scanner(System.in).nextLine();

        File file = new File("file.txt");

        String string = FileUtils.readFileToString(file, "UTF-8");

        String result = string.replaceAll("[^a-zA-z]", " ");

        List<String> list = Arrays.asList(result.split(" "));

        AscendingLengthStringComparator lengthStringComparator = (o1, o2) -> Integer.compare(o1.toString().length(), o2.toString().length());

        DescendingLengthStringComparator lengthStringComparator1 = (o1, o2) -> Integer.compare(o1.toString().length(), o2.toString().length());

        if (order.equals("ascending")) {

            Collections.sort(list, lengthStringComparator);

        } else if (order.equals("descending")) {

            Collections.sort(list, Collections.reverseOrder(lengthStringComparator1));

        } else {

            System.out.println("Please type ascending or descending order .");
            return;
        }


        list.stream().distinct().forEach(System.out::println);


    }


    interface AscendingLengthStringComparator extends Comparator {

    }

    interface DescendingLengthStringComparator extends Comparator {

    }

}
