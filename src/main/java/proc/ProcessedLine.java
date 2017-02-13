package proc;

import java.util.List;

/**
 * Created by alexr on 12.02.2017.
 */
public class ProcessedLine implements ProcessList {
    private final String origin;
    private final String vendorName;

    public ProcessedLine(String origin, String vendorName) {
        this.origin = origin;
        this.vendorName = vendorName;
    }

    @Override
    public List<String> list() {
        // это List<String> содержимое полей
        List<String> fields = new LineToArray(
            new ReplaceComma(
                new StripNonASCII(origin)
            ), ";").list();
        ProcessList processed;
        switch (vendorName) {
            // ---------------
            case "MERCEDES":
                processed =
                    new GetFields(fields,
                        1, 2, 3, 6, 8);
                break;
            // ---------------
            case "ZF":
                processed = new AddFields(
                    new GetFields(fields,
                        3, 8, 5, 7),
                    "0");
                break;
            // ---------------
            case "PORSCHE":
                processed = new AddFields(
                    new GetFields(fields,
                        3, 4, 9, 6),
                    "0");
                break;
            // ---------------
            case "LANDROVER":
                processed = new AddFields(
                    new GetFields(fields,
                        3, 7, 5, 11),
                    "0");
                break;
            // ---------------
            case "JAGUAR":
                processed = new AddFields(
                    new GetFields(fields,
                        3, 4, 9),
                    "0", "0");
                break;
            // ---------------
            default:
                processed = new AddFields(
                    new GetFields(fields,
                        1, 2, 3, 7),
                    "0");
        }
        return processed.list();
    }
}