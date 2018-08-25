package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

public class FileScanner extends Thread {

    private final String filename;
    private final String key;
    private ArrayList<String> list;
    Logger logger = LoggerFactory.getLogger(FileScanner.class);

    public FileScanner(String filename, String key, ArrayList<String> list){
        this.filename = filename;
        this.key = key;
        this.list = list;
    }

    public void run() {
        try {
            ReadWithScanner parser = new ReadWithScanner(filename, key, list);
            parser.processLineByLine();
            logger.info("Parsing " + filename);
        } catch (IOException e){
            logger.warn("Could not parse: " + filename);
        }
    }
}
