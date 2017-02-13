package proc;

import java.util.List;

/**
 * Created by alexr on 12.02.2017.
 *
 * just Quote each Item in string
 */
public class QuotedEach {
    private final List<String> origin;

    public QuotedEach(ProcessList origin) {
        this.origin = origin.list();
    }

    @Override
    public String toString() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        int fieldNumber = 1;
        String field = "";
        for (String item : origin) {
            sb.append(delim);
            if (fieldNumber == 3 || fieldNumber == 4) {
                // special price & weight handling
                field = new ZeroIfNull(new StripSpaces(item)).data();
            }
            else {
                field = item;
            }
            sb.append(new Quoted(field).data());
            delim = ";";
            fieldNumber++;
        }
        return sb.toString();
    }
}
