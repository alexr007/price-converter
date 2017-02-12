package proc;

/**
 * Created by alexr on 12.02.2017.
 *
 * just Quote each Item in string
 */
public class QuoteEach implements Process {
    private final String origin;

    QuoteEach(Process origin) {
        this(origin.data());
    }

    QuoteEach(String origin) {
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
