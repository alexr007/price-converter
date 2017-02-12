package proc;

/**
 * Created by alexr on 12.02.2017.
 */
public class Fields implements Process {
    private final String[] origin;

    Fields(String... origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        return new ArrayToLine(origin).data();
    }
}
