package bigdata.siva;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by sivakumaran on 11/25/2017.
 */
public class ReadData extends HBaseProjectConstants {
    public static void main(String args[]) throws IOException {
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf("emp2"));
        Scan scan = new Scan();

        // Scanning the required columns
        scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"));
        scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("city"));

        // Getting the scan result
        ResultScanner scanner = table.getScanner(scan);

        for (Result result = scanner.next(); result != null; result = scanner.next())
            System.out.println("Found row : " + result);

        table.close();
    }

}
