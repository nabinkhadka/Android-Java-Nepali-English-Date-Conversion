package np.com.nabinkhadka;

import java.util.List;

/**
 * Created by nabin_khadka on 11/18/16.
 */
public class Main {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        Converter converter = new Converter();

        List<NepaliDate> nepaliDateList = converter.getFullNepaliMonthOf(1992, 4, 20);

        for (NepaliDate nepaliDate: nepaliDateList){
            System.out.println(nepaliDate.toString());
        }


        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time taken: " + totalTime + " ms");
    }
}
