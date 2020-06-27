package log4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class CommonsLoggingTest {
    public static void main(String[] args) {
        Log log = LogFactory.getLog(CommonsLoggingTest.class);
        log.info("start...");
        log.warn("end...");
    }
}
