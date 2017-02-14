import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * Created by alexr on 12.02.2017.
 */
public class AvailableFiles {
    private final List<String> files = new ArrayList<>();

    public List<String> get() throws IOException {
        files.clear();
        DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("."));
        for (Path path : stream) {
            if(!path.toFile().isDirectory()) {
                //String fileName = path.toFile().toString().toLowerCase();
                String fileName = path.toFile().toString().toLowerCase();
                if (fileName.endsWith(".txt")||fileName.endsWith(".csv")) {
                    System.out.println(fileName);
                    files.add(fileName);
                }
            }
        }
        return files;
    }
}
