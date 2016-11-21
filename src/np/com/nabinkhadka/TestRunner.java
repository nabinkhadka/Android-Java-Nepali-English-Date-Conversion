package np.com.nabinkhadka;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by nabin_khadka on 11/21/16.
 */
public class TestRunner {

    @Test
    public void allTests(){
        Converter converter = new Converter();
        //English to Nepali test cases
        assertEquals("2049 / 1 / 8 Monday", converter.getNepaliDate(1992, 4, 20).toString());
        assertEquals("2073 / 8 / 6 Monday", converter.getNepaliDate(2016, 11, 21).toString());
        assertEquals("2080 / 3 / 15 Friday", converter.getNepaliDate(2023, 6, 30).toString());
        assertEquals("2033 / 11 / 1 Saturday", converter.getNepaliDate(1977, 2, 12).toString());


        //Nepali to English test cases
        assertEquals("1992 / 4 / 20 Monday", converter.getEnglishDate(2049, 1, 8).toString());
        assertEquals("2016 / 11 / 21 Monday", converter.getEnglishDate(2073, 8, 6).toString());
        assertEquals("2023 / 6 / 30 Friday", converter.getEnglishDate(2080, 3, 15).toString());
        assertEquals("1977 / 2 / 12 Saturday", converter.getEnglishDate(2033, 11, 1).toString());
    }
}
