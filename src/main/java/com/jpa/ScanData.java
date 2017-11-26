package com.jpa;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by Sivakumar Annamalai on 11/25/2017.
 */
public class ScanData extends HBaseProjectConstants {
    public static void main(String args[]) throws IOException {
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf("emp1"));
        Scan scan = new Scan();

        // Scanning the required columns
        scan.addColumn(Bytes.toBytes("personal"),
                Bytes.toBytes("name"));
        scan.addColumn(Bytes.toBytes("personal"),
                Bytes.toBytes("city"));

        // Getting the scan result
        ResultScanner scanner = table.getScanner(scan);
        String personal = "personal";
        for (Result result = scanner.next(); result != null;
             result = scanner.next()) {
            System.out.println("Found row : " + result);
            System.out.println("Name:"+
                    getColumnValue(result,personal,"name"));
            System.out.println("City:"+
                    getColumnValue(result,personal,"city"));
        }

        table.close();
    }

}
