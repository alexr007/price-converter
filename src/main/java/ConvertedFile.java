import java.io.*;

/**
 * Created by alexr on 10.02.2017.
 */
public class ConvertedFile {
    private final String fileName;
    private final String vendor;
    private final String country;

    public ConvertedFile(String fileName, String vendor, String country) {
        this.fileName = fileName;
        this.vendor = vendor;
        this.country = country;
    }

    public void convert() throws IOException {
        BufferedReader rd = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(
                    new File(fileName))));
        BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(
                    new File(fileName + ".sql"))
            )
        );
        String line = rd.readLine(); // strip 1st line
        while ((line = rd.readLine())!= null) {
            wr.write(
                new ReplaceComma(
                    new AddFields(
                        new StripFields(
                            new StripNonASCII(line)
                        ),
                        vendor,
                        country
                    )

                ).data()
            );
            wr.newLine();
        }
        rd.close();
        wr.close();
    }
}
