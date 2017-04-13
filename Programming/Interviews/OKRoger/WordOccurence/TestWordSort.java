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


    /** Null/error tests: should print either nothing or error message of some kind */
    /* Tests that WordSorter prints error when given nonexistent file*/
    @Test
    public void nulllocalTest() {
        WordSorter test = new WordSorter();
        String y = "weirdfile.png";
        System.out.print(test.read(y));
    }
    /* Output: "Not a valid file!" */

    /* Tests that WordSorter prints error when given bad type*/
    @Test
    public void malformedinputTest() {
        WordSorter test = new WordSorter();
        int testnum = 4;
        System.out.print(test.read(testnum));
    }
    /* Output: "Not a valid type!" */

    /* Tests that WordSorter prints nothing when given blank document*/
    @Test
    public void blankDocumentTest() {
        WordSorter test = new WordSorter();
        String y = "blankDocument.txt";
        System.out.print(test.read(y));
    }
    /*  Output:  [null]*/

    /* Tests that WordSorter prints all vals when no match arg is passed*/
    @Test
    public void blankmatchTest() {
        WordSorter test = new WordSorter();
        String y = "BasicFunctionalityTestinput.txt";
        System.out.print(test.match(y, "")); //searches file, words beginning with o
    }

    /** Functionality tests: makes sure the actual frequency */

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

    /* Involved test: performs test on Alice in Wonderland */
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


   /** Special parameters test */
    /* Tests if capitalize argument selects for capitalizaiton*/
    @Test
    public void capsTest() {
        WordSorter test = new WordSorter("caps");
        String y = "capsTestinput.txt";
        System.out.print(test.read(y));
    }

    /* Tests if  special characters should be kept*/
    @Test
    public void specialTest() {
        WordSorter test = new WordSorter("special");
        String y = "specialTestinput.txt";
        System.out.print(test.read(y));
    }

    /* Tests if both special characters and caps should be kept */
    @Test
    public void specialAndCapsTest() {
        WordSorter test = new WordSorter("caps", "special");
        String y = "specialAndCapsTestinput.txt";
        System.out.print(test.read(y));
    }

    /** Prefix sort tests*/

    /* Tests that WordSorter prints correct output for basic text file*/
    @Test
    public void basicmatchTest() {
        WordSorter test = new WordSorter();
        String y = "BasicFunctionalityTestinput.txt";
        System.out.print(test.match(y, "o")); //searches file, words beginning with o
    }

    /* Tests Alice in Wonderland for words beginning with "al" */
    @Test
    public void AliceMatchTest() {
        try { //Unfortunately URL seems to need this in test cases
            URL z = new URL("http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt");
            WordSorter test = new WordSorter();
            System.out.print(test.match(z, "al")); //searches file, words beginning with al
        } catch (MalformedURLException e) {
            System.out.println("Not a valid URL!");
        }
    }

    @Test
    public void matchAndCapsTest() {
        WordSorter test = new WordSorter("caps");
        String y = "matchAndCapsTestinput.txt";
        System.out.print(test.match(y, "Th")); //searches file, words beginning with o
    }
    //Output: This, 3

    @Test
    public void matchAndSpecialTest() {
        WordSorter test = new WordSorter("special");
        String y = "matchAndSpecialTestinput.txt";
        System.out.print(test.match(y, "!th")); //searches file, words beginning with o
    }
    //Output: !this, 3

    /* Tests average word length of Alice in Wonderland */
    @Test
    public void AliceWordLengthTest() {
        try {
            URL z = new URL("http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt");
            WordSorter test = new WordSorter();
            System.out.print(test.averageWordLength(z)); //searches file, average word length
        } catch (MalformedURLException e) {
            System.out.println("Not a valid URL!");
        }
    }
    /* Output: 4.0612597 */

    /* Tests averge word length of Alice in Wonderland words with words beginning with "al" */
    @Test
    public void AliceMatchWordLengthTest() {
        try {
            URL z = new URL("http://www.umich.edu/~umfandsf/other/ebooks/alice30.txt");
            WordSorter test = new WordSorter();
            System.out.print(test.averageMatchWordLength(z, "al")); //searches file, average word length of "al"
        } catch (MalformedURLException e) {
            System.out.println("Not a valid URL!");
        }
    } /* Output: 4.5297804 */

    //TODO: AWL with special characters and stuff
}
