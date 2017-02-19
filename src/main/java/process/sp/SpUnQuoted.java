package process.sp;

/**
 * Created by alexr on 12.02.2017.
 */
public class SpUnQuoted implements StringProcess {
    private final String origin;
    private final String QUOTE = "\"";

    public SpUnQuoted(String origin) {
        this.origin = origin;
    }

    public String data() {
        return ((origin != null)
            &&(origin.startsWith(QUOTE))
            &&(origin.endsWith(QUOTE))) ?
            origin.substring(1, origin.length() - 1)
            : origin;
    }
}
