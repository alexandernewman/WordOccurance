/**
 * Created by AlexNewman on 4/12/17.
 * <p>
 * Citations:
 * <p>
 * Used old CS homework to get IDE framework
 * Used StackOverflow for Undesirables and file reading
 * 
 */

import java.util.HashMap;
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;
import java.net.*;

public class WordSorter {
    private HashMap<String, Integer> vals; //Stores word as key, frequency as value

    /* Constructs WordSorter */
    public WordSorter() {
        vals = new HashMap<>();
    }

    //Determines input type, reads file correspondingly
    public String read(Object file) {
        String classtest = file.getClass().toString();
        if (classtest.equals("class java.lang.String")) {//Local files
            return readlocal((String) file);
        } else if (classtest.equals("class java.net.URL")) { //Online files
            return readURL((URL) file);
        } else { //If it's not local or online, we don't want it
            return "Not a valid type!";
        }
    }

    /* Similar to readlocal except using URL*/
    private String readURL(URL filename) {
        try { // Try-catch used here to keep Scanner happy
            Scanner s = new Scanner(filename.openStream());
            String line = s.nextLine(); //Similar to readLine() in BufferedReader
            while (line != null) {
                wordcheck(line);
                line = s.nextLine(); //goes to new line
            }
        } finally {
            return stringcreate(vals);
        }
    }

    /* Reads lines in file, adds words to vals */
    private String readlocal(String filename) {
       /*Reading in file */
        try { // For catching if the file doesn't exist on the computer
            BufferedReader br = new BufferedReader(new FileReader(filename));
            try { // Try-catch used here to keep FileReader happy
                String line = br.readLine(); //goes line by line
                while (line != null) {
                    wordcheck(line); //formats words, adds to vals
                    line = br.readLine(); //goes to new line

                }
            } finally {
                br.close();
                return stringcreate(vals);
            }
        } catch (Exception e) { //If this
            return "Not a valid file!";
        }
    }

    /* Formats words on line appropriately */
    private void wordcheck(String line) {
        if (!line.equals("")) {
            String replacedline = line.replace("--", " ");
            String[] linewords = replacedline.trim().split(" "); //Splits by space
            for (String x : linewords) { //for each word on line
                if (!x.equals("") && !x.equals("]")) {
                    String newx = processWord(x);
                    mapadd(newx.toLowerCase()); //ignores capitalization, adds to vals
                }
            }
        }
    }

    /* List of all characters to remove from string */
    private static final Pattern UNDESIRABLES = Pattern.compile("[(){},_'.^\"`;:*%$@#!?<>%]");

    /* Replaces all above characters with blank space */
    private static String processWord(String x) {
        return UNDESIRABLES.matcher(x).replaceAll("");
    }

    /* Adds String to vals and updates frequency if value already in vals */
    private void mapadd(String val) {
        if (!val.equals("")) {
            if (vals.containsKey(val)) {
                int f = vals.get(val) + 1;
                vals.put(val, f);
            } else {
                vals.put(val, 1);
            }
        }
    }

    /* Creates string with first column word, second column frequency*/
    private String stringcreate(HashMap<String, Integer> vals) {
        String valstring = "";
        for (String x : vals.keySet()) {
            valstring += x + ", " + vals.get(x) + "\n";
        }
        return valstring;
    }
}
