import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;

/**
 * Created by nabin_khadka on 11/18/16.
 */
public class Converter {

    //Change this when you get more previous database.
    public static final int START_ENGLISH_YEAR = 1953;
    public static final int START_ENGLISH_MONTH = 4;
    public static final int START_ENGLISH_DAY = 13;
    //Change this to equivalent nepali start date
    public static final int START_NEPALI_YEAR = 2010;
    public static final int START_NEPALI_MONTH = 1;
    public static final int START_NEPALI_DAY = 1;

    public Converter() {

    }




    public NepaliDate getNepaliDate(int eYear, int eMonth, int eDay) {
        int l_day = START_NEPALI_DAY, l_month = START_NEPALI_MONTH, l_year = START_NEPALI_YEAR;
        DateTimeZone dummy = DateTimeZone.forID("America/Sao_Paulo");
        DateTime start = new DateTime(START_ENGLISH_YEAR, START_ENGLISH_MONTH, START_ENGLISH_DAY, 5, 0, 0, dummy);
        DateTime end = new DateTime(eYear, eMonth, eDay, 13, 0, 0, dummy);
        int deltaDays = Days.daysBetween(start, end).getDays();
        NepaliDate nepaliDate = new NepaliDate();
        for (int i = 0; i < deltaDays; i++) {
            if (l_day < nepaliDate.getDaysOf(l_year, l_month)) {
                l_day++;
            } else if (l_month < 12) {
                l_day = 1;
                l_month++;
            } else if (l_month == 12) {
                l_year++;
                l_month = 1;
                l_day = 1;
            }
        }
        String week_day = "" + end.dayOfWeek().getAsText();
        return new NepaliDate(l_year, l_month, l_day, week_day);
    }

}
