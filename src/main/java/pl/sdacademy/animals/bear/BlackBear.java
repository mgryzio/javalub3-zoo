package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import pl.sdacademy.clock.Clock;

public class BlackBear extends Bear {
    public BlackBear(double weight, Clock clock) {
        super(weight, clock);
    }

    public BlackBear(double weight) {
        super(weight);
    }

    @Override
    public boolean isHibernating() {
        LocalDate twientiethNovember = new LocalDate(clock.getCurrentTime().getYear(), 11, 20);

        return clock.getCurrentTime().toLocalDate().isAfter(twientiethNovember);
    }
}