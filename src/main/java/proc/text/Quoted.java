package proc.text;

/**
 * Created by alexr on 12.02.2017.
 *
 * just enclose string to quotes;
 */
public class Quoted implements Process {
    private final String origin;
    private final String QUOTE = "\"";

    Quoted(String origin) {
        this.origin = origin;
    }

    public String data() {
        return QUOTE + origin + QUOTE;
    }
}
