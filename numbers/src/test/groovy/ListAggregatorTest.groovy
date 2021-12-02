import com.aor.numbers.GenericListDeduplicator
import com.aor.numbers.ListAggregator
import spock.lang.Specification

class ListAggregatorTest extends Specification{
    def "Check if the sum of #lista is equal to #finallist"() {
        when:
        def aggregator = new ListAggregator()

        then:
        aggregator.sum(lista) == finallist

        where:
        finallist << [3,5]
        lista << [[1,2],[2,1,2]]
    }

    def "Check if the max of #lista is #finallist"(){

        when:
        def aggregator = new ListAggregator()

        then:
        aggregator.max(lista) == finallist

        where:
        finallist << [2,2,6]
        lista << [[1,-4,2],[2,1,2],[1,2,4,6,1,0]]
    }

    def "Check if the min of #lista is #finallist"(){

        when:
        def aggregator = new ListAggregator()

        then:
        aggregator.min(lista) == finallist

        where:
        finallist << [-4,1,-2]
        lista << [[1,-4,2],[2,1,2],[1,-2,4,6,1,0]]
    }

    def "Check if the number of distinct elements in #lista is #finallist"(){

        given:
        GenericListDeduplicator deduplicator = Stub()
        deduplicator.deduplicate(Arrays.asList([1,1,2])) >> Arrays.asList([1,2])

        when:
        def aggregator = new ListAggregator()

        then:
        aggregator.distinct([1,1,2],deduplicator) == 2


    }

}
