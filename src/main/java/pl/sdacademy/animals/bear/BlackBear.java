package pl.sdacademy.animals.bear;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import pl.sdacademy.clock.Clock;

public class BlackBear extends Bear {
    public BlackBear(int weight, Clock clock) {
        super(weight, clock);
    }

    public BlackBear(double weight) {
        super(weight);
    }

//    public boolean isHibernating() {
//        boolean result = DateTime.
//    }
}