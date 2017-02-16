package proc.text;

/**
 * Created by alexr on 13.02.2017.
 */
public class StripSpaces implements Process {
    private final String origin;

    public StripSpaces(String origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        return origin.replace(" ","");
    }
}
