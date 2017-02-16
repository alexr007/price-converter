import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by alexr on 09.02.2017.
 *
 * main class
 */
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("-= Price converter =-");
        List<String> fileNames = new AvailableFiles().get();
        CountDownLatch cdl =new CountDownLatch(fileNames.size());
        long start = System.currentTimeMillis();
        for (String name : fileNames) {
            new Thread(
                new RunnableConverted(name, cdl)
            ).start();
        }
        cdl.await();
        long delta = System.currentTimeMillis()-start;
        System.out.println(String.format("-= Done in %d millis=-", delta));
    }
}
