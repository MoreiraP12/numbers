package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;


public class ListAggregatorTest {
    private List<Integer> list;
    private List<Integer> expected;
    GenericListDeduplicator deduplicator = Mockito.mock(GenericListDeduplicator.class);

    @BeforeEach
    public void setUp() {
        list = Arrays.asList(1,2,4,2,5);
        expected = Arrays.asList(1,2,4,5);
    }

    @Test
    public void sum() {


        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {


        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {


        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void max_bug_7263() {
        ListAggregator aggregator = new ListAggregator();
        List<Integer> list1 = Arrays.asList(-1,-2,-5);
        int distinct = aggregator.max(list1);

        Assertions.assertEquals(-1, distinct);
    }

    @Test
    public void distinct() {
        //List<Integer> list = Arrays.asList(1,2,4,2,5);
        Mockito.when(deduplicator.deduplicate(Mockito.anyList())).thenReturn(Arrays.asList(1, 2, 4));
        class StubListDeduplicator implements GenericListDeduplicator{
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return  Arrays.asList(1, 2, 4, 5);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void distinct_bug_8726() {
        List<Integer> list = Arrays.asList(1,2,4,2);
        class StubListDeduplicator implements GenericListDeduplicator{
            @Override public List<Integer> deduplicate(List<Integer> list) {
                return  Arrays.asList(1, 2, 4);
            }
        }
        ListAggregator aggregator = new ListAggregator();
        StubListDeduplicator deduplicator = new StubListDeduplicator();
        int distinct = aggregator.distinct(list, deduplicator);
        Assertions.assertEquals(3, distinct);
    }


}
