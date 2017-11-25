package bigdata.siva;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by sivakumaran on 11/25/2017.
 */
public class ScanData extends HBaseProjectConstants {
    public static void main(String args[]) throws IOException {
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf("emp1"));


        Get g = new Get(Bytes.toBytes("290200"));
        Result result = table.get(g);
        byte [] name = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("name"));
        byte [] city = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("city"));
        byte [] designation = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("designation"));
        byte [] salary = result.getValue(Bytes.toBytes("personal"),Bytes.toBytes("salary"));

        System.out.println("Name: " + Bytes.toString(name));
        System.out.println("City: " + Bytes.toString(city));
        System.out.println("Designation: " + Bytes.toString(designation));
        System.out.println("Salary: " + Bytes.toString(salary));


    }

}
