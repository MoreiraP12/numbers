import com.aor.numbers.DivisibleByFilter
import spock.lang.Specification

class DivisibleByFilterSpockTest extends Specification {

    def setup() {
        lista2 = Arrays.asList(0, 2, 4, 8, 240, 1000, 10000)
        lista3 = Arrays.asList(0, 3, 6, 9, 33, 333, 666)
    }

    def 'accept divide by 2'() {
        given:
        def filter = new DivisibleByFilter(2)
        when:
        def divisible = lista2
        def notDivisible = lista3

        then:
        divisible.every {it -> filter.accept(it) }
        notDivisible.every {it -> !filter.accept(it) }

    }

    def 'accept divide by 3'() {
        given:
        def filter = new DivisibleByFilter(3)
        when:
        def divisible = lista3
        def notDivisible = lista2

        then:
        divisible.every {it -> filter.accept(it) }
        notDivisible.every {it -> !filter.accept(it) }
    }
}

