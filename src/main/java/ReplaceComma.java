/**
 * Created by alexr on 09.02.2017.
 */
public class ReplaceComma implements Process {
    private final String origin;

    public ReplaceComma(Process origin) {
        this(origin.data());
    }

    public ReplaceComma(String origin) {
        this.origin = origin;
    }

    public String data() {
        return origin.replace(",", ".");
    }
}
