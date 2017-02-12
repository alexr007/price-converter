package proc;

/**
 * Created by alexr on 12.02.2017.
 */
public class ArrayToLine implements Process{
    private final String[] origin;

    public ArrayToLine(String[] origin) {
        this.origin = origin;
    }

    @Override
    public String data() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        for (String item : origin) {
            sb.append(delim);
            sb.append(item);
            delim = ";";
        }
        return sb.toString();
    }
}
