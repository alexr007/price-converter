package proc;

/**
 * Created by alexr on 12.02.2017.
 */
public class ZeroIfNull implements Process {
    private final String origin;
    private final String ZERO = "0";

    public ZeroIfNull(Process origin) {
        this(origin.data());
    }

    public ZeroIfNull(String origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        String res=origin;
        if (new Trimmed(origin).data().isEmpty()) {
            res=ZERO;
        }
        return res;
    }
}
