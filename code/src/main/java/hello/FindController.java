package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class FindController {

    Logger logger = LoggerFactory.getLogger(FindController.class);

    @RequestMapping("/find")
    public ArrayList<String> find(@RequestParam(value="name", defaultValue="empty") String name,
                                  @RequestParam(value="first", defaultValue="0") long first,
                                  @RequestParam(value="second", defaultValue="0.0") float second) {

        Key key = new Key(name, first, second);
        ArrayList<String> list = new ArrayList<String>();

        /* Parse 3 files */
        FileScanner fs1 = new FileScanner("C:\\Users\\doro\\Documents\\Projects\\tmp1.txt", key.toString(), list);
        FileScanner fs2 = new FileScanner("C:\\Users\\doro\\Documents\\Projects\\tmp2.txt", key.toString(), list);
        FileScanner fs3 = new FileScanner("C:\\Users\\doro\\Documents\\Projects\\tmp3.txt", key.toString(), list);

        fs1.start();
        fs2.start();
        fs3.start();

        try {
            fs1.join();
            fs2.join();
            fs3.join();
        } catch (InterruptedException e){
            logger.error("Error: interrupted exception");
        }

        return list;
    }
}
