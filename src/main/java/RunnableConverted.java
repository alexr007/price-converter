import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by alexr on 16.02.2017.
 */
public class RunnableConverted implements Runnable {
    private final String file;
    private final CountDownLatch cdl;

    public RunnableConverted(String file, CountDownLatch cdl) {
        this.file = file;
        this.cdl = cdl;
    }

    @Override
    public void run() {
        new ConvertedFile(file).convert();
        cdl.countDown();
    }
}
