import java.io.*;

/**
 * Created by alexr on 09.02.2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Price Corrector");
        if (args.length<3) {
            System.out.println("Usage corr.jar <file> <vendor> <country>");
        } else {
            String vendor = args[1];
            String country = args[2];
            String fileName = args[0];
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
}
