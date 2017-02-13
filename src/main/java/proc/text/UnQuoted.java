package proc.text;

import proc.text.Process;

/**
 * Created by alexr on 12.02.2017.
 */
public class UnQuoted implements Process {
    private final String origin;

    public UnQuoted(String origin) {
        this.origin = origin;
    }

    public String data() {
        return ((origin != null)
            &&(origin.startsWith("\""))
            &&(origin.endsWith("\""))) ?
            origin.substring(1, origin.length() - 1)
            : origin;
    }
}
