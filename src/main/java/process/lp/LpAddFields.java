package process.lp;

import java.util.List;

/**
 * Created by alexr on 09.02.2017.
 *
 * adding fields to List<String>
 */
public class LpAddFields implements ListProcess {
    private final List<String> origin;
    private final String[] fields;

    public LpAddFields(ListProcess origin, String... fields) {
        this.origin = origin.list();
        this.fields = fields;
    }

    public List<String>list(){
        final List<String> process = origin;
        for (String s : fields) {
            process.add(s);
        }
        return process;
    }
}
