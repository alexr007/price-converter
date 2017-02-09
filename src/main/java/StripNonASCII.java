/**
 * Created by alexr on 09.02.2017.
 */
public class StripNonASCII implements Process{
    private final String origin;

    public StripNonASCII(Process origin) {
        this(origin.data());
    }

    public StripNonASCII(String origin) {
        this.origin = origin;
    }

    public String data() {
        return origin.replaceAll("[^\\x20-\\x7e]", "");
    }
}
