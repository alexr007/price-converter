import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by alexr on 12.02.2017.
 */
public class AvailableFiles {
    private final String initialFolder;

    public AvailableFiles(String[] args) {
        initialFolder = args[0];
        System.out.printf("Initial filder is:%s\n",initialFolder);
    }

    private static boolean isApplicable(String fileName) {
        return fileName.toLowerCase().endsWith(".txt")
            || fileName.toLowerCase().endsWith(".csv");
    }

    public List<String> get() {
        DirectoryStream<Path> stream = null;
        try {
            stream = Files.newDirectoryStream(Paths.get(initialFolder));
        } catch (IOException e) {
        }
        if (stream==null) {
            return Collections.EMPTY_LIST;
        }
        else
            return StreamSupport.stream(stream.spliterator(), false)
                .filter(path -> !path.toFile().isDirectory())
                .map(path -> path.toFile().toString())
                .filter(AvailableFiles::isApplicable)
                .collect(Collectors.toList());
    }
}
