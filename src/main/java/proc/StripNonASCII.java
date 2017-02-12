package proc;

/**
 * Created by alexr on 09.02.2017.
 */
public class StripNonASCII implements Process {
    private final String origin;
    private final String FIND="[^\\x20-\\x7e]";
    private final String REPLACE="";

    public StripNonASCII(Process origin) {
        this(origin.data());
    }

    public StripNonASCII(String origin) {
        this.origin = origin;
    }

    public String data() {
        return origin.replaceAll(FIND, REPLACE);
    }
}
