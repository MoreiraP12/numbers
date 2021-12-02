import com.aor.numbers.PositiveFilter
import spock.lang.Specification

class PositiveFilterSpockTest extends Specification {
    private def positives
    private def nonPositives

    def setup() {
        positives = Arrays.asList(1, 2,10, 1238, 12345678)
        nonPositives = Arrays.asList(0, -1, -2, -3, -1234)
    }

    def 'Testing: accept'() {

        when:
        def filter = new PositiveFilter()

        then:
        positives.every {it ->  filter.accept(it) }

        nonPositives.every {it -> !filter.accept(it) }
    }
}
