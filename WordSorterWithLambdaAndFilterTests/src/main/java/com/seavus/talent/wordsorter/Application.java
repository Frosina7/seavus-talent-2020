package com.seavus.talent.wordsorter;

import org.apache.commons.io.FileUtils;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Application {

    public static List<String> loadWordsFromFile() throws IOException {

        File file = new File("file.txt");

        String string = FileUtils.readFileToString(file, "UTF-8");

        String result = string.replaceAll("[^a-zA-z]", " ");

        List<String>list = Arrays.asList(result.split(" "));

        return list;
    }

    public static List<String>sortAndFilterWords(List<String>list,Integer min,Integer max,String order)
    {

        List<String>output= (max==0 && min==0)?list.stream().distinct().collect(Collectors.toList())
                : min == 0 ?list.stream().distinct().filter(word-> word.length() <= max).collect(Collectors.toList())
                : max == 0 ?list.stream().distinct().filter(word-> word.length() >= min).collect(Collectors.toList())
                : list.stream().distinct().filter(word -> word.length() >= min).filter(word -> word.length() <= max).collect(Collectors.toList());


        if (order.equals("ascending")) {

            Collections.sort(output, (String s1, String s2) -> s1.length() - s2.length());

        } else if (order.equals("descending")) {

            Collections.sort(output, (String s1, String s2) -> (s2.length()-s1.length()));

        } else {

             System.out.println("Please type ascending or descending order .");
             return Collections.emptyList();

        }

        return output;


    }


    public static void main(String[] args) throws IOException {

        System.out.print("Enter if you want your words to be sorted in ascending or descending order : ");

        String order = new Scanner(System.in).nextLine();

        System.out.print("Specify your minimum length of printed words : ");

        Integer min = new Scanner(System.in).nextInt();

        System.out.print("Specify your maximum length of printed words : ");

        Integer max = new Scanner(System.in).nextInt();

        List<String>list=loadWordsFromFile();

        List<String>filteredWords=sortAndFilterWords(list,min,max,order);

        filteredWords.stream().forEach(System.out::println);

    }



}
