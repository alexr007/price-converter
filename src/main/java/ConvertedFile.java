import proc.list.AddFields;
import proc.list.ProcessedLine;
import proc.text.QuotedEach;

import java.io.*;

/**
 * Created by alexr on 10.02.2017.
 */
public class ConvertedFile {
    private final String fileName;
    private final int DEALER = 4;
    private final int vendorId;
    private final String vendorName;

    public ConvertedFile(String fileName) {
        this.fileName = fileName;
        Vendor vendor = new Vendor(fileName);
        this.vendorId = vendor.id();
        this.vendorName = vendor.name();
    }

    public void convert() throws IOException {
        System.out.println(
            new File(fileName).exists()
        );
/*
        BufferedReader rd = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(
                    new File(fileName))));
        BufferedWriter wr = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(
                    new File(vendorName + ".sql"))
            )
        );
        String line = rd.readLine(); // strip 1st line
        while ((line = rd.readLine())!= null) {
            wr.write(
                new QuotedEach(
                    new AddFields(
                        new ProcessedLine(line, vendorName),
                        // vendorId
                        Integer.toString(vendorId),
                        // dealer = 4
                        Integer.toString(DEALER)
                    )
                ).toString()
            );
            wr.newLine();
        }
        rd.close();
        wr.close();
*/
    }
}
