package pl.sdacademy.animals.bear;


import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import pl.sdacademy.clock.Clock;

public class BlackBear extends Bear {
    public BlackBear(double weight, Clock clock) {
        super(weight, clock);
    }

    @Override
    public boolean isHibernating() {
        DateTime currentTime = clock.getCurrentTime();
        int currentYear = currentTime.getYear();

        LocalDate twentiethNovember = new LocalDate(currentYear, 11, 20);
        LocalDate fifteenthMarch = new LocalDate(currentYear, 03, 15);

        boolean after20November = currentTime.toLocalDate().isAfter(twentiethNovember);
        boolean before15March = currentTime.toLocalDate().isBefore(fifteenthMarch);

        return after20November || before15March;
    }

    public BlackBear(int weight) {
        super(weight);
    }

}