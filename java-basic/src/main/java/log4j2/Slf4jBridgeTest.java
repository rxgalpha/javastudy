package log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jBridgeTest {

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(Slf4jBridgeTest.class);
        log.info("start...");
        log.warn("end...");
    }
}
