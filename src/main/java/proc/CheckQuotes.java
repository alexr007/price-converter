package proc;

/**
 * Created by alexr on 12.02.2017.
 */
public class CheckQuotes implements Process{
    private final String origin;

    public CheckQuotes(Process origin) {
        this(origin.data());
    }

    public CheckQuotes(String origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        final String DELIM = "\"";
        String ret=origin;
        if (origin.contains(DELIM)) {
            String[] splitted = origin.split(DELIM);
            if (splitted.length == 3) {
                ret =
                    splitted[0]
                    +splitted[1].replace(";", ",")
                    +splitted[2];
            }
        }
        return ret;
    }
}
