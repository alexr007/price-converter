package proc;

/**
 * Created by alexr on 09.02.2017.
 */
public class ReplaceComma implements Process {
    private final String origin;
    private final String FIND = ",";
    private final String REPLACE = ".";

    public ReplaceComma(Process origin) {
        this(origin.data());
    }

    public ReplaceComma(String origin) {
        this.origin = origin;
    }

    public String data() {
        return origin.replace(FIND, REPLACE);
    }
}
