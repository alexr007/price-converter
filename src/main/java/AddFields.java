/**
 * Created by alexr on 09.02.2017.
 */
public class AddFields implements Process{
    private final String origin;
    private final String[] fields;

    public AddFields(Process origin, String... fields) {
        this(origin.data(), fields);
    }

    public AddFields(String origin, String... fields) {
        this.origin = origin;
        this.fields = fields;
    }

    public String data() {
        StringBuilder sb = new StringBuilder(origin);
        for (String field : fields) {
            sb.append(";\""+field+"\"");
        }
        return sb.toString();
    }
}
