import com.aor.numbers.GenericListSorter
import com.aor.numbers.ListDeduplicator
import spock.lang.Specification

class ListDeduplicatorSpockTest extends Specification {
    private def list
    private def expected


    def 'Testing deduplicate'() {
        given:
        GenericListSorter sorter = Mock(GenericListSorter.class)
        def deduplicator = new ListDeduplicator(sorter)

        sorter.sort(_) >> Arrays.asList(1, 2, 2, 4, 5)

        when:
        def distinct = deduplicator.deduplicate(list)

        then:
        expected == distinct;

        where:
        expected << [[1,2,4],[1,3,7,9],[2,6]]
        list << [[1,4,2],[7,3,1,9],[2,6]]

    }


}


