package proc.text;

import proc.text.Process;

/**
 * Created by alexr on 09.02.2017.
 */
public class StripNonASCII implements Process {
    private final String origin;
    private final String FIND="[^\\x20-\\x7e]";
    private final String REPLACE="";

    public StripNonASCII(String origin) {
        this.origin = origin;
    }

    public String data() {
        return origin.replaceAll(FIND, REPLACE);
    }
}
