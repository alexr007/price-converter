import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Entrance {
    private final String[] args;
    private final long start = System.currentTimeMillis();

    public Entrance(String[] args) {
        this.args = args;
    }

    public long run_parallel_all() throws InterruptedException {
        List<String> fileNames = new AvailableFiles(args).get();
        CountDownLatch cdl =new CountDownLatch(fileNames.size());
        fileNames.forEach(
            name->new Thread(new RunnableConverted(name, cdl)).start());
        cdl.await();
        return System.currentTimeMillis()-start;
    }

    public long run_sequential() {
        List<String> fileNames = new AvailableFiles(args).get();
        fileNames.forEach(s -> new ConvertedFile(s).convert());
        return System.currentTimeMillis()-start;
    }

    public long run_parallel_smart() throws InterruptedException {
        final int nCores = Runtime.getRuntime().availableProcessors();
        System.out.printf("Running on %d cores\n", nCores);
        ExecutorService es = Executors.newFixedThreadPool(nCores);

        List<String> fileNames = new AvailableFiles(args).get();
        CountDownLatch cdl =new CountDownLatch(fileNames.size());
        fileNames.forEach(s -> es.submit(new RunnableConverted(s, cdl)));
        cdl.await();
 //       fileNames.forEach(s -> es.submit(new ConvertedFile(s)::convert));
        es.shutdown();
        return System.currentTimeMillis()-start;
    }
}
