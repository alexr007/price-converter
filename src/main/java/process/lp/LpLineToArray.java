package process.lp;

import process.sp.SpTrimmed;
import process.sp.SpUnQuoted;
import process.sp.StringProcess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexr on 12.02.2017.
 */
public class LpLineToArray implements ListProcess {
    private final String origin;
    private final String delimiter;

    public LpLineToArray(StringProcess origin, String delimiter) {
        this(origin.data(), delimiter);
    }

    LpLineToArray(String origin, String delimiter) {
        this.origin = origin;
        this.delimiter = delimiter;
    }

    private List<String> listIt() {
        final char QUOTE = '\"';
        final char DELIM = delimiter.charAt(0);
        final String EMPTY = "";
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
                    result.add(EMPTY);
                } else {
                    result.add(origin.substring(start));
                }
            } else if (DELIM == origin.charAt(pos) && !inQuotes) {
                result.add(origin.substring(start, pos));
                start = pos + 1;
            }
        }
        return result;
    }

    @Override
    public List<String> list() {
        ArrayList<String> result = new ArrayList<>();
        for (String s : listIt()) {
            result.add(new SpTrimmed(new SpUnQuoted(s)).data());
        }
        return result;
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
