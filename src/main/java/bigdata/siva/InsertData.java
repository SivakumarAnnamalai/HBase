package bigdata.siva;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by sivakumaran on 11/25/2017.
 */
public class InsertData extends HBaseProjectConstants{

    public static void main(String args[]) throws IOException {
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf("emp1"));

        // insert the first record
        Put p1 = new Put(Bytes.toBytes("290200"));
        p1.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"),Bytes.toBytes("Raju"));
        p1.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("city"),Bytes.toBytes("Hyderabad"));
        p1.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("designation"), Bytes.toBytes("Manager"));
        p1.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("salary"), Bytes.toBytes("50000"));

        // insert the first record
        Put p2 = new Put(Bytes.toBytes("8022102"));
        p2.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("name"),Bytes.toBytes("Kavi"));
        p2.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("city"),Bytes.toBytes("Chennai"));
        p2.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("designation"), Bytes.toBytes("Developer"));
        p2.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("salary"), Bytes.toBytes("30000"));

        // Saving the put Instance to the HTable.
        table.put(p1);
        table.put(p2);

        // closing HTable
        table.close();
        System.out.println("Data inserted Successfully");
    }
}
