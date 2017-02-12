import proc.*;

import java.io.*;

/**
 * Created by alexr on 09.02.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Price Corrector");
        if (args.length<1) {
            System.out.println("Usage corr.jar <file>");
        } else {
            new ConvertedFile(args[0])
            .convert();
        }
    }
}
