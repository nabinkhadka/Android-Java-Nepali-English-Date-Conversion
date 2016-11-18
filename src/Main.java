/**
 * Created by nabin_khadka on 11/18/16.
 */
public class Main {
    public static void main(String[] args){
        long startTime = System.currentTimeMillis();

        Converter converter = new Converter();
        NepaliDate date = converter.getNepaliDate(1992,4,20);
        System.out.println(date.toString());

        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time taken: " + totalTime);
    }
}
