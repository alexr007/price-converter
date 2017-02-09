/**
 * Created by alexr on 09.02.2017.
 */
public class StripFields implements Process {
    private final String origin;

    public StripFields(Process origin) {
        this(origin.data());
    }

    public StripFields(String origin) {
        this.origin = origin;
    }

    public String data() {
        String delim = ";";
        StringBuilder sb = new StringBuilder();
        String[] parts = origin.split(";");
        sb.append(parts[0]);
        sb.append(delim);
        sb.append(parts[1]);
        sb.append(delim);
        sb.append(parts[2]);
        sb.append(delim);
        sb.append(parts[6]);
        return sb.toString();
    }
}
