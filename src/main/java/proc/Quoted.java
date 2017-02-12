package proc;

/**
 * Created by alexr on 12.02.2017.
 *
 * just enclose string to quotes;
 */
public class Quoted implements Process {
    private final String origin;
    private final char QUOTE = '"';

    Quoted(String origin) {
        this.origin = origin;
    }

    Quoted(Process origin) {
        this(origin.data());
    }

    public String data() {
        return QUOTE + origin + QUOTE;
    }
}
