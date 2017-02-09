/**
 * Created by alexr on 09.02.2017.
 */
public class StringCorrected implements Process {
    private final String origin;

    public StringCorrected(String origin) {
        this.origin = origin;
    }

    public String data() {
        return origin;
    }
}
