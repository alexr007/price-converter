import java.io.IOException;

/**
 * Created by alexr on 09.02.2017.
 *
 * main class
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("-= Price converter =-");
        for (String name : new AvailableFiles().get()) {
            System.out.println(String.format("Processing file: %s...", name));
            new ConvertedFile(name)
                //.convert()
            ;
        }
        System.out.println("-= Done =-");
    }
}
