package process.sp;

/**
 * Created by alexr on 13.02.2017.
 */
public class SpStripSpaces implements StringProcess {
    private final String origin;
    private final String SEARCH = " ";
    private final String REPLACE = "";

    public SpStripSpaces(String origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        return origin.replace(SEARCH, REPLACE);
    }
}
