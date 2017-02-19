package process.sp;

/**
 * Created by alexr on 12.02.2017.
 */
public class SpZeroIfNull implements StringProcess {
    private final String origin;
    private final String ZERO = "0";

    public SpZeroIfNull(StringProcess origin) {
        this(origin.data());
    }

    public SpZeroIfNull(String origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        return
            new SpTrimmed(origin).data().isEmpty()
                ? ZERO
                : origin;
    }
}
