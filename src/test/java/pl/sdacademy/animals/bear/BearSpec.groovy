package pl.sdacademy.animals.bear

import org.joda.time.DateTime
import org.joda.time.Duration
import pl.sdacademy.clock.Clock
import spock.lang.Specification


class BearSpec extends Specification {

    def "Bear should be alive if has eaten within 10 days"() {
        given:
        Bear bear = testBear
        bear.eat()

        when:
        def result = bear.isAlive()

        then:
        result == true

        where:
        testBear << [new BlackBear(5), new PolarBear(20)]
    }

    def "Feeding bear should set the date of the last meal for now"() {
        given:
        Bear bear = new BlackBear(1)
        bear.eat()

        when:
        def result = bear.getLastMealTime()

        then:
        new Duration(result, DateTime.now()).isShorterThan(Duration.standardSeconds(1))
    }

    def "Bear should not be alive if it has not eaten for more than 10 days"() {
        given:
        Bear bear = new BlackBear(1, new TestClock())

        when:
        def result = bear.isAlive()

        then:
        result == false
    }

    def "When bear ate sth, then his weight raised"() {
        given:
        Bear bear = new BlackBear(4)
        bear.eat(1)

        when:
        def result = bear.getWeight()

        then:
        result == 5
    }

    def "Drinking water casuses weight rising"() {
        given:
        Bear bear = new PolarBear(4)
        bear.drink(1)

        when:
        def result = bear.getWeight()

        then:
        result == 4.75
    }

    def "When bear poo, then its losing his weight"() {
        given:
        Bear bear = new BlackBear(1)
        bear.poop()

        when:
        def result = bear.getWeight()

        then:
        result == 0.95
    }

}