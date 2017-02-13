package proc.text;

import proc.text.Process;

/**
 * Created by alexr on 09.02.2017.
 */
public class Trimmed implements Process {
    private final String origin;

    Trimmed(String origin) {
        this.origin = origin;
    }

    public Trimmed(Process origin) {
        this(origin.data());
    }

    public String data() {
        return origin.trim();
    }
}
