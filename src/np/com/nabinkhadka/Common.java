package np.com.nabinkhadka;

/**
 * Created by nabin_khadka on 11/21/16.
 */
public class Common {
    private static final boolean isDebug = false;

    public static void log(String message){
        if(isDebug) {
            System.out.println(message);
        }
    }

    public static void log(String message, boolean doPrint){
        if(doPrint){
            System.out.println(message);
        }
    }
}
