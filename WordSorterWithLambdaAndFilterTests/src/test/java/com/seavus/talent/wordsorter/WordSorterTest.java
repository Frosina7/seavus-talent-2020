package com.seavus.talent.wordsorter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class WordSorterTest {

    private Application application;

    @BeforeEach
    void setUp() {
        application = new Application();
    }

    @Test
    void wordSort_ascendingSort() {
        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,2,4,"ascending");
        Assertions.assertEquals(Arrays.asList("et","est","enim"),filteredWords);

    }

    @Test
    void wordSort_descendingSort() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,2,4,"descending");
        Assertions.assertEquals(Arrays.asList("enim","est","et"),filteredWords);

    }

    @Test
    void wordSort_forZeroMax() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,2,0,"ascending");
        Assertions.assertEquals(Arrays.asList("et","est","enim","error","dicta","explicabo","voluptatem","doloremque","accusantium","perspiciatis"),filteredWords);
    }

    @Test
    void wordSort_forZeroMin() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,0,12,"descending");
        Assertions.assertEquals(Arrays.asList("perspiciatis","accusantium","voluptatem","doloremque","explicabo","error","dicta","enim","est","et"),filteredWords);

    }
    @Test
    void wordSort_sameForMinAndMaxAsc() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,5,5,"ascending");
        Assertions.assertEquals(Arrays.asList("error","dicta"),filteredWords);

    }
    @Test
    void wordSort_sameForMinAndMaxDsc() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,5,5,"descending");
        Assertions.assertEquals(Arrays.asList("error","dicta"),filteredWords);

    }
    @Test
    void wordSort_forZeroForMinAndMaxAsc() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,0,0,"ascending");
        Assertions.assertEquals(Arrays.asList("et","est","enim","error","dicta","explicabo","voluptatem","doloremque","accusantium","perspiciatis"),filteredWords);

    }

    @Test
    void wordSort_forZeroForMinAndMaxDesc() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,0,0,"descending");
        Assertions.assertEquals(Arrays.asList("perspiciatis","accusantium","voluptatem","doloremque","explicabo","error","dicta","enim","est","et"),filteredWords);

    }

    @Test
    void wordSort_wrongExpression() {

        List<String> words= Arrays.asList("est","perspiciatis","error","voluptatem","accusantium","doloremque","dicta","explicabo","enim","et");
        List<String>filteredWords=application.sortAndFilterWords(words,2,4,"something");
        Assertions.assertEquals( Collections.emptyList(),filteredWords);

    }

    @Test
    void fileExists()throws IOException{
        File file=new File("file.txt");
        Assertions.assertTrue(file.exists());
    }

    @Test
    void canLoadFromFile()throws IOException{
        List<String>list=application.loadWordsFromFile();
        Assertions.assertTrue(!list.isEmpty());
    }
}
