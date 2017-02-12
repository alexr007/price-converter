package proc;

/**
 * Created by alexr on 12.02.2017.
 */
public class QuoteEach implements Process {
    private final String origin;

    public QuoteEach(Process origin) {
        this(origin.data());
    }

    public QuoteEach(String origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        String delim = "";
        String[] items = new LineToArray(origin, ";").items();
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append(delim);
            sb.append(new Quoted(item).data());
            delim = ";";
        }
        return sb.toString();
    }
}
