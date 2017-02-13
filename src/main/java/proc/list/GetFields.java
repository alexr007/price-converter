package proc.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexr on 09.02.2017.
 */
public class GetFields implements ProcessList {
    private final List<String> origin;
    private final int[] fieldsList;

    public GetFields(List<String> origin, int... fieldsList) {
        this.origin = origin;
        this.fieldsList = fieldsList;
    }

    public List<String> list() {
        ArrayList<String> list = new ArrayList<>();
        for (int field : fieldsList) {
            list.add(origin.get(field-1));
        }
        return list;
    }
}
