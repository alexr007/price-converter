package proc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexr on 12.02.2017.
 */
class LineToArray {
    private final String origin;
    private final String delimiter;

    LineToArray(Process origin, String delimiter) {
        this(origin.data(), delimiter);
    }

    LineToArray(String origin, String delimiter) {
        this.origin = origin;
        this.delimiter = delimiter;
    }

    List<String> list() {
        final char QUOTE = '\"';
        final char DELIM = ';';
        ArrayList<String> result = new ArrayList<>();
        int start = 0;
        boolean inQuotes = false;
        for (int pos = 0; pos < origin.length(); pos++) {
            if (QUOTE == origin.charAt(pos)) {
                inQuotes = !inQuotes;
            }
            boolean atLastChar = (pos == origin.length() - 1);
            if (atLastChar) {
                if (DELIM == origin.charAt(pos)) {
                    result.add(origin.substring(start, pos));
                    result.add("");
                }
                else {
                    result.add(origin.substring(start));
                }
            }
            else if (DELIM == origin.charAt(pos) && !inQuotes) {
                result.add(origin.substring(start, pos));
                start = pos + 1;
            }
        }
        ArrayList<String> r2 = new ArrayList<>();
        for (String s : result ) {
            r2.add(new Trimmed(new UnQuoted(s)).data());
        }
        return r2;
    }

    @Override
    public String toString() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        for (String s : list().toArray(new String[0])) {
            sb.append(delim);
            sb.append('<');
            sb.append(s);
            sb.append('>');
            delim=",";
        }
        return sb.toString();
    }
}
