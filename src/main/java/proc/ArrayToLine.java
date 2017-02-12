package proc;

/**
 * Created by alexr on 12.02.2017.
 * array to string convertor
 * using delimiter
 */
public class ArrayToLine implements Process{
    private final String delimiter;
    private final String[] origin;

    ArrayToLine(String[] origin) {
        this(origin, ";");
    }

    ArrayToLine(String[] origin, String delimiter) {
        this.origin = origin;
        this.delimiter = delimiter;
    }

    @Override
    public String data() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        for (String item : origin) {
            sb.append(delim);
            sb.append(item);
            delim = delimiter;
        }
        return sb.toString();
    }
}
