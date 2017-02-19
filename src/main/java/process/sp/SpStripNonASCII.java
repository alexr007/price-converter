package process.sp;

/**
 * Created by alexr on 09.02.2017.
 */
public class SpStripNonASCII implements StringProcess {
    private final String origin;
    private final String SEARCH ="[^\\x20-\\x7e]";
    private final String REPLACE="";

    public SpStripNonASCII(String origin) {
        this.origin = origin;
    }

    public String data() {
        return origin.replaceAll(SEARCH, REPLACE);
    }
}
