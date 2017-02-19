package process.sp;

/**
 * Created by alexr on 12.02.2017.
 *
 * just enclose string to quotes;
 */
public class SpQuoted implements StringProcess {
    private final String origin;
    private final String QUOTE = "\"";

    SpQuoted(String origin) {
        this.origin = origin;
    }

    public String data() {
        return QUOTE + origin + QUOTE;
    }
}
