package proc;

/**
 * Created by alexr on 12.02.2017.
 */
public class ProcessedLine implements Process{
    private final String origin;
    private final String vendorName;

    public ProcessedLine(String origin, String vendorName) {
        this.origin = origin;
        this.vendorName = vendorName;
    }

    public ProcessedLine(Process origin, String vendorName) {
        this(origin.data(), vendorName);
    }

    public String data() {
        String[] items;
        // меняем запятые,и удаляем непечатаемые символы
        Process baseProcessed = new ReplaceComma(
            new StripNonASCII(origin)
        )
        ;
        Process processedLine = null;
        switch (vendorName) {
            // ---------------
            case "MERCEDES" :
                processedLine = new QuotedEach(
                    new GetFields(
                        new CheckQuotes(baseProcessed),
                        1,2,3,6,8
                    )
                );
                break;
            // ---------------
            case "ZF" :
                items = new LineToArray(
                    new GetFields(
                        baseProcessed,
                        3, 8, 5, 7
                    ), ";"
                ).items();
                items[2] =items[2].replace(" ","");
                processedLine = new QuotedEach(
                    new AddFields(
                        new ArrayToLine(items),
                        "0"
                    )
                );
                break;
            // ---------------
            case "PORSCHE" :
                items=new LineToArray(
                    new GetFields(
                        baseProcessed,
                        3, 4, 9, 6
                    ),
                    ";"
                ).items();
                processedLine = new Fields(
                    items[0], // number
                    new Quoted(new Trimmed(new UnQuoted(items[1]))).data(), // name
                    new Quoted(new Trimmed(new UnQuoted(new ZeroIfNull(items[2])))).data(), // price
                    new Quoted(new Trimmed(new UnQuoted(new ZeroIfNull(items[3])))).data(), // weight
                    "0" // core
                );
                break;
            // ---------------
            case "LANDROVER" :
                processedLine = new QuotedEach(
                    new AddFields(
                        new GetFields(
                            baseProcessed,
                            3,7,5,11
                        ),
                        "0")
                );
                break;
            // ---------------
            case "JAGUAR" :
                processedLine = new QuotedEach(
                    new AddFields(
                        new GetFields(
                            baseProcessed,
                            3,4,9
                        ),
                        "0", "0")
                );
                break;

            // ---------------
            default :
                items = new LineToArray(baseProcessed, ";").items();
                processedLine = new Fields(
                    items[1-1],
                    items[2-1],
                    items[3-1],
                    items[7-1],
                    "0"
                );
        }
        return processedLine.data();
    }
}
