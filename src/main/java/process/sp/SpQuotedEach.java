package process.sp;

import process.lp.ListProcess;

import java.util.List;

/**
 * Created by alexr on 12.02.2017.
 *
 * just Quote each Item in string
 */
public class SpQuotedEach implements StringProcess{
    private final List<String> origin;
    private final String DELIM = ";";

    public SpQuotedEach(ListProcess origin) {
        this.origin = origin.list();
    }

    @Override
    public String data() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        int fieldNumber = 1;
        String field = "";
        for (String item : origin) {
            sb.append(delim);
            if (fieldNumber == 3 || fieldNumber == 4) {
                // special price & weight handling
                field = new SpZeroIfNull(new SpStripSpaces(item)).data();
            }
            else {
                field = item;
            }
            sb.append(new SpQuoted(field).data());
            delim = DELIM;
            fieldNumber++;
        }
        return sb.toString();
    }
}
