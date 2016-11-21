package np.com.nabinkhadka;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.DurationFieldType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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


    /*
        English units start with e
        Nepali units start with n
    */
    public NepaliDate getNepaliDate(int eYear, int eMonth, int eDay) {
        int nDay = START_NEPALI_DAY, nMonth = START_NEPALI_MONTH, nYear = START_NEPALI_YEAR;
        DateTime start = new DateTime(START_ENGLISH_YEAR, START_ENGLISH_MONTH, START_ENGLISH_DAY, 0, 0);
        DateTime end = new DateTime(eYear, eMonth, eDay, 0, 0);
        int deltaDays = Days.daysBetween(start, end).getDays();
        NepaliDate nepaliDate = new NepaliDate();
        for (int i = 0; i < deltaDays; i++) {
            if (nDay < nepaliDate.getDaysOf(nYear, nMonth)) {
                nDay++;
            } else if (nMonth < 12) {
                nDay = 1;
                nMonth++;
            } else if (nMonth == 12) {
                nYear++;
                nMonth = 1;
                nDay = 1;
            }
        }
        System.out.println("Nepali iterations: " + deltaDays);
        String week_day = "" + end.dayOfWeek().getAsText();
        return new NepaliDate(nYear, nMonth, nDay, week_day);
    }


    public EnglishDate getEnglishDate(int nYear, int nMonth, int nDay) {
        int l_day = START_NEPALI_DAY, l_month = START_NEPALI_MONTH, l_year = START_NEPALI_YEAR;
        int deltaDays = 0;
        boolean isReached = false;
        NepaliDate nepaliDate = new NepaliDate();
        while (!isReached) {
            if (nYear == l_year && nMonth == l_month && nDay == l_day) {
                isReached = true;
                deltaDays--;
            }
            deltaDays++;
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
        System.out.println("English iterations: " + deltaDays);
        DateTime dateTime = new DateTime(START_ENGLISH_YEAR, START_ENGLISH_MONTH, START_ENGLISH_DAY, 0 , 0);
        return new EnglishDate(dateTime.withFieldAdded(DurationFieldType.days(), deltaDays));
    }

    public List<NepaliDate> getFullNepaliMonthOf(int eYear, int eMonth, int eDay) {

        NepaliDate temp = getNepaliDate(eYear, eMonth, eDay);
        int nDay = temp.getGatey();
        int nYear = temp.getSaal();
        int nMonth = temp.getMahina();
        String nWeekDay = temp.getBaar();
        List<NepaliDate> nepaliDates = new ArrayList<NepaliDate>();

        int weekIndex = EnglishDate.getWeekIndex(nWeekDay);
        for (int i = nDay; i > 0; i--) {
            nepaliDates.add(new NepaliDate(nYear, nMonth, i,
                    EnglishDate.WEEK_DAYS[weekIndex - 1]));
            if (weekIndex > 1) {
                weekIndex--;
            } else {
                weekIndex = 7;
            }
        }
        weekIndex = EnglishDate.getWeekIndex(nWeekDay);
        if (weekIndex < 7) {
            weekIndex++;
        } else {
            weekIndex = 1;
        }
        for (int i = nDay + 1; i <= temp.getDaysOf(nYear, nMonth); i++) {
            nepaliDates.add(new NepaliDate(nYear, nMonth, i,
                    EnglishDate.WEEK_DAYS[weekIndex - 1]));
            if (weekIndex < 7) {
                weekIndex++;
            } else {
                weekIndex = 1;
            }
        }
        Collections.sort(nepaliDates, new Comparator<NepaliDate>() {
            @Override
            public int compare(NepaliDate p1, NepaliDate p2) {
                return p1.getGatey() - p2.getGatey(); // Ascending
            }

        });
        return nepaliDates;
    }

}
