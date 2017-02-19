package process.sp;

/**
 * Created by alexr on 09.02.2017.
 */
public class SpTrimmed implements StringProcess {
    private final String origin;

    SpTrimmed(String origin) {
        this.origin = origin;
    }

    public SpTrimmed(StringProcess origin) {
        this(origin.data());
    }

    public String data() {
        return origin.trim();
    }
}
