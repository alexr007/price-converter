import java.io.*;

/**
 * Created by alexr on 09.02.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Price Corrector");
        if (args.length<3) {
            System.out.println("Usage corr.jar <file> <vendor> <country>");
        } else {
            new ConvertedFile(args[0], args[1], args[2])
            .convert();
        }
    }
}
