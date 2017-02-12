package proc;

import java.util.ArrayList;

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

    String[] items() {
        final String QUOTE = "\"";
        final String DELIM = ";";
        ArrayList<String> result = new ArrayList<>();
        int start = 0;
        boolean inQuotes = false;
        for (int pos = 0; pos < origin.length(); pos++) {
            if (QUOTE.equals(origin.charAt(pos))) {
                inQuotes = !inQuotes;
            }
            boolean atLastChar = (pos == origin.length() - 1);
            if (atLastChar) {
                if (DELIM.equals(origin.charAt(pos))) {
                    result.add(origin.substring(start, pos));
                    result.add("");
                }
                else {
                    result.add(origin.substring(start));
                }
            }
            else if (DELIM.equals(origin.charAt(pos)) && !inQuotes) {
                result.add(origin.substring(start, pos));
                start = pos + 1;
            }
        }
        return result.toArray(new String[0]);
        //return origin.split(String.valueOf(DELIM),-1);
    }

    @Override
    public String toString() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        for (String s : items()) {
            sb.append(delim);
            sb.append('<');
            sb.append(s);
            sb.append('>');
            delim=",";
        }

        return sb.toString();
    }
}
