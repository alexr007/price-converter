package proc;

/**
 * Created by alexr on 12.02.2017.
 *
 * just Quote each Item in string
 */
public class QuotedEach implements Process {
    private final String origin;

    QuotedEach(Process origin) {
        this(origin.data());
    }

    QuotedEach(String origin) {
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
