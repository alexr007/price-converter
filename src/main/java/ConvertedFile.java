import process.lp.LpAddFields;
import process.lp.LpLineToArray;
import process.lp.LpVendorSpecific;
import process.sp.SpQuotedEach;
import process.sp.SpReplaceComma;
import process.sp.SpStripNonASCII;

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

    public void convert() {
        System.out.printf("Processing file: %s...\n", fileName);
        BufferedReader rd = null;
        try {
            rd = new BufferedReader(
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
                    new SpQuotedEach(
                        new LpAddFields(
                            new LpVendorSpecific(
                                new LpLineToArray(
                                    new SpReplaceComma(
                                        new SpStripNonASCII(line)
                                    ), ";")
                                , vendorName),
                            // vendorId
                            Integer.toString(vendorId),
                            // dealer = 4
                            Integer.toString(DEALER)
                        )
                    ).data()
                );
                wr.newLine();
            }
            rd.close();
            wr.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File Not found: "+fileName,e);
        } catch (IOException e) {
            throw new IllegalArgumentException("IOException",e);
        }
    }
}
