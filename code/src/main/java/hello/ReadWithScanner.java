package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/** Assumes UTF-8 encoding. JDK 7+. */
public class ReadWithScanner {

    /**
     Constructor.
     @param aFileName full name of an existing, readable file.
     */

    public ReadWithScanner(String aFileName, String key, ArrayList<String> list){
        fFilePath = Paths.get(aFileName);
        this.key = key;
        this.list = list;
    }


    /** Template method that calls {@link #processLine(String)}.  */
    public final void processLineByLine() throws IOException {
        try (Scanner scanner =  new Scanner(fFilePath, ENCODING.name())){
            while (scanner.hasNextLine()){
                processLine(scanner.nextLine());
            }
        }
    }

    /**
     Overridable method for processing lines in different ways.

     <P>This simple default implementation expects simple name-value pairs, separated by an
     ' *= *' regex. Examples of valid input:
     <tt>height =167cm</tt>
     <tt>mass =  65kg</tt>
     <tt>disposition =  "grumpy"</tt>
     <tt>this is the name = this is the value</tt>
     */
    protected void processLine(String aLine) {
        //use a second Scanner to parse the content of each line
        try(Scanner scanner = new Scanner(aLine)) {
            scanner.useDelimiter(" *= *");
            //assumes the line has a certain structure

            String name = scanner.next();
            String value = scanner.next();

            if (name.equals(key)) {
                list.add("Key : " + quote(name.trim()) + ", Value : " + quote(value.trim()));
            }
        } catch (Exception e){
            logger.warn("Warning : wrong format");
        }
    }

    // PRIVATE
    private final Path fFilePath;
    private final String key;
    private final static Charset ENCODING = StandardCharsets.UTF_8;
    private ArrayList<String> list;
    Logger logger = LoggerFactory.getLogger(ReadWithScanner.class);

    private String quote(String aText){
        String QUOTE = "'";
        return QUOTE + aText + QUOTE;
    }
}