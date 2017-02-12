package proc;

/**
 * Created by alexr on 09.02.2017.
 */
public class GetFields implements Process {
    private final String origin;
    private final int[] fieldsList;

    public GetFields(Process origin, int... fieldsList) {
        this(origin.data(), fieldsList);
    }

    public GetFields(String origin, int... fieldsList) {
        this.origin = origin;
        this.fieldsList = fieldsList;
    }

    public String data() {
        String delim = "";
        StringBuilder sb = new StringBuilder();
        String[] items = new LineToArray(origin, ";").items();

        for (int field : fieldsList) {
            //System.out.println("index:"+field);
            //System.out.println("val:"+items[field-1]+":");
            sb.append(delim);
            String sItem = items[field-1]!="" ? items[field-1] : "\"\"";
            sb.append(items.length>field-1 ? sItem : "");
            delim = ";";
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
