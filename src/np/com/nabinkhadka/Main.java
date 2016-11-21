package np.com.nabinkhadka;

import java.util.List;

/**
 * Created by nabin_khadka on 11/18/16.
 */
public class Main {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        Converter converter = new Converter();
        List<NepaliDate> nepaliDates = converter.getFullNepaliMonthOf(2016, 11, 21);

        for(NepaliDate nepaliDate: nepaliDates){
            System.out.println(nepaliDate.toString());
        }

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time taken: " + totalTime + " ms");
    }
}
