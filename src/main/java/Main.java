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
        final String fmt = "Method, %s, done time:%dms\n";
        System.out.println("-= Price converter =-");
        if (args.length>0) {
            //final long time1 = new Entrance(args).run_parallel_all();
            //final long time2 = new Entrance(args).run_sequential();
            final long time3 = new Entrance(args).run_parallel_smart();
            //System.out.printf(fmt, "Brutal Parallel", time1);
            //System.out.printf(fmt, "Simple Sequential", time2);
            System.out.printf(fmt, "Smart Parallel (according to core count)", time3);
        }
        else {
            System.out.println("format: >converter initialDir");
        }
    }
}
