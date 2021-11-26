package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListSorterTest {

    private List<Integer> list ;
    private List<Integer> expected ;

    @BeforeEach
    public void setUp() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,2,4,5);
    }

    @Test
    public void sort() {


        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(list);

        Assertions.assertEquals(expected, sorted);
    }

    @Test
    public void bug_sort_8276() {
        ListSorter sorter = new ListSorter();
        List<Integer> sorted = sorter.sort(Arrays.asList(1, 2, 4, 2,5));
        Assertions.assertEquals(Arrays.asList(1, 2,2, 4,5), sorted);
    }
}
