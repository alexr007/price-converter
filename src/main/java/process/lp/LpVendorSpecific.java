package process.lp;

import java.util.List;

/**
 * Created by alexr on 12.02.2017.
 */
public class LpVendorSpecific implements ListProcess {
    private final String vendorName;
    private final List<String> origin;

    public LpVendorSpecific(ListProcess origin, String vendorName) {
        this.origin = origin.list();
        this.vendorName = vendorName;
    }

    @Override
    public List<String> list() {
        ListProcess processed;
        switch (vendorName) {
            // ---------------
            case "MERCEDES":
                processed =
                    new LpGetFields(origin,
                        1, 2, 3, 6, 8);
                break;
            // ---------------
            case "ZF":
                processed = new LpAddFields(
                    new LpGetFields(origin,
                        3, 8, 5, 7),
                    "0");
                break;
            // ---------------
            case "PORSCHE":
                processed = new LpAddFields(
                    new LpGetFields(origin,
                        3, 4, 9, 6),
                    "0");
                break;
            // ---------------
            case "LANDROVER":
                processed = new LpAddFields(
                    new LpGetFields(origin,
                        3, 7, 5, 11),
                    "0");
                break;
            // ---------------
            case "JAGUAR":
                processed = new LpAddFields(
                    new LpGetFields(origin,
                        3, 4, 9),
                    "0", "0");
                break;
            // ---------------
            default:
                processed = new LpAddFields(
                    new LpGetFields(origin,
                        1, 2, 3, 7),
                    "0");
        }
        return processed.list();
    }
}