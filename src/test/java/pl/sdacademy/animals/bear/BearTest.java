package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import pl.sdacademy.clock.DateTimeClock;

import static org.junit.jupiter.api.Assertions.*;

class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(1);
        bear.eat(0);

        boolean result = bear.isAlive();

        assertTrue(result == true);
    }

    @Test
    void feedingBearShouldSetTheDateOfTheLastMealForNow() {
        Bear bear = new BlackBear(1);
//        bear.eat(0);

        DateTime result = bear.getLastMealTime();

        assertTrue(new Duration(result, DateTime.now()).isShorterThan(Duration.standardSeconds(1)));
    }

    @Test
    void bearShouldNotBeAliveIfItHasNotEatenForMoreThan10Days() {
        Bear bear = new BlackBear(1, new TestClock());

        boolean result = bear.isAlive();

        assertThat(result).isFalse();
    }

    // MOCK pozwala rejestrować ilość wykonanych metod na obiekcie
    // Implementacja, która zachowuje ilość wywołań wybranych metod. Tworzona zwykle przy pomocy różnego rodzaju bibliotek.

    @Test
    void eatingSthCausesWeightRise() {
        Bear bear = new BlackBear(4);
        bear.eat(1);

        assertThat(bear.getWeight() == 5).isTrue();
    }

    @Test
    void drinkingWaterCasusesWeightRise() {
        Bear bear = new BlackBear(4);
        bear.drink(1);

        assertThat(bear.getWeight() == 4.75);
    }

    @Test
    void afterpoop() {
        Bear bear = new BlackBear(1);
        bear.poop();

        assertThat(bear.getWeight() == 0.95);
    }

//    @Test
//    void hibernatingTimeForBlackBear() {
//        Bear bear = new BlackBear(4);
//        bear.isHibernating();
//
//        assertThat(LocalDate.now().plusDays(20)).isTrue;
//    }
}