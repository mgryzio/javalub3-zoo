package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.sdacademy.clock.Clock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BearTest {

    @Test
    void bearShouldBeAliveIfHasEatenWithin10Days() {
        Bear bear = new BlackBear(1);
        bear.eat(0);

        assertThat(bear.isAlive()).isTrue();
    }

    @Test
    void feedingBearShouldSetTheDateOfTheLastMealForNow() {
        Bear bear = new BlackBear(1);
        bear.eat(0);

        assertThat(new Duration(bear.getLastMealTime(), DateTime.now()).isShorterThan(Duration.standardSeconds(1)))
                .isTrue();
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

        assertThat(bear.getWeight() == 4.75).isTrue();
    }

    @Test
    void afterPoop() {
        Bear bear = new BlackBear(1);
        bear.poop();

        assertThat(bear.getWeight() == 0.95).isTrue();
    }

    @Test
    void blackBearShouldBeHibernatingAfter20thNovember() {
        Clock clock = mock(Clock.class);
        when(clock.getCurrentTime()).thenReturn(new DateTime(2017, 12, 01, 14, 0));
        BlackBear bear = new BlackBear(1, clock);

        assertThat(bear.isHibernating()).isTrue();
    }


}