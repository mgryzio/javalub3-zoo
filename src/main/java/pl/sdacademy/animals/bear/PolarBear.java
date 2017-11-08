package pl.sdacademy.animals.bear;

import org.joda.time.LocalDate;
import pl.sdacademy.clock.Clock;



public class PolarBear extends Bear {
    public PolarBear(int weight, Clock clock) {
        super(weight, clock);
    }

    public PolarBear(int weight) {
        super(weight);
    }

    @Override
    public boolean isHibernating() {
        LocalDate fifthMay = new LocalDate(clock.getCurrentTime().getYear(),5,5);
        LocalDate tenthOctober = new LocalDate(clock.getCurrentTime().getYear(),10,10);

        return clock.getCurrentTime().toLocalDate().isAfter(fifthMay)
                && clock.getCurrentTime().toLocalDate().isBefore(tenthOctober);
    }
}
