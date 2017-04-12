/**
 * Created by AlexNewman on 4/12/17.
 *
 * Citations:
 *
 * Copied junit structure from CS homework
 * Copied use of URL from SO
 */

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TestWordSort {

    /** These tests don't actually use Assert so
     * they always pass.  The only way that seemed
     * reasonable was to use print statements and
     * inspect. The @Test signs are more for
     * showing where the various tests are visually. */


    //TODO: Test edge cases and nulls and stuff

    /* Makes sure WordSorter can actually read words and lines */
    @Test
    public void basicFunctionalityTest() {
        WordSorter test = new WordSorter();
        String y = "basicFunctionalityTestinput.txt";
        System.out.print(test.read(y));
    }

    /* Tests if WordSorter can add exact matches */
    @Test
    public void repeatingTest() {
        WordSorter test = new WordSorter();
        String y = "repeatingTestinput.txt";
        System.out.print(test.read(y));
    }

    /* This tests if the punctuation remover is working correctly. */
    @Test
    public void punctRemoveTest() {
        WordSorter test = new WordSorter();
        String a = "punctRemoveTestinput.txt";
        System.out.print(test.read(a));
    }

    /* Sample test: performs test on Alice in Wonderland */
    @Test
    public void AliceTest() {
       /** Note: Only works for pages that are blank text files
        *  Don't try other sites, you'll just get the source code
        * */
        try { //Unfortunately URL seems to need this in test cases
            URL z = new URL("http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt");
            WordSorter test = new WordSorter();
            System.out.print(test.read(z));
        } catch (MalformedURLException e) {
            System.out.println("Not a valid URL!");
        }
    }



}
