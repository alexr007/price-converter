package proc;

import proc.list.ProcessList;
import proc.text.Process;
import proc.text.Trimmed;
import proc.text.UnQuoted;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexr on 12.02.2017.
 */
public class LineToArray implements ProcessList{
    private final String origin;
    private final String delimiter;

    public LineToArray(Process origin, String delimiter) {
        this(origin.data(), delimiter);
    }

    LineToArray(String origin, String delimiter) {
        this.origin = origin;
        this.delimiter = delimiter;
    }

    @Override
    public List<String> list() {
        final char QUOTE = '\"';
        final char DELIM = ';';
        ArrayList<String> result = new ArrayList<>();
        int start = 0;
        boolean inQuotes = false;
        //String item="";
        for (int pos = 0; pos < origin.length(); pos++) {
            if (QUOTE == origin.charAt(pos)) {
                inQuotes = !inQuotes;
            }
            boolean atLastChar = (pos == origin.length() - 1);
            if (atLastChar) {
                if (DELIM == origin.charAt(pos)) {
                    //item=origin.substring(start, pos);
                    result.add(origin.substring(start, pos));
                    result.add("");
                } else {
                    //item=origin.substring(start);
                    result.add(origin.substring(start));
                }
            } else if (DELIM == origin.charAt(pos) && !inQuotes) {
                result.add(origin.substring(start, pos));
                //item=origin.substring(start, pos);
                start = pos + 1;
            }
            /*
            result.add(new Trimmed(new UnQuoted(item)).data());
            if (DELIM == origin.charAt(pos)) {
                result.add("");
            }
            return result;
            */
        }
        ArrayList<String> r2 = new ArrayList<>();
        for (String s : result) {
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
