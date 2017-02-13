package proc;

import java.util.List;

/**
 * Created by alexr on 09.02.2017.
 *
 * adding fields to List<String>
 */
public class AddFields implements ProcessList {
    private final List<String> origin;
    private final String[] fields;

    public AddFields(ProcessList origin, String... fields) {
        this.origin = origin.list();
        this.fields = fields;
    }

    public List<String>list(){
        for (String s : fields) {
            origin.add(s);
        }
        return origin;
    }
}
