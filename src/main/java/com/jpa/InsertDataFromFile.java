package com.jpa;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Sivakumar Annamalai on 11/25/2017.
 */
public class InsertDataFromFile extends HBaseProjectConstants{

    public static void main(String args[]) throws IOException {
        Connection connection = getConnection();
        Table table = connection.getTable(TableName.valueOf("emp2"));
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(RESOURCES_DIR+"/emp.csv"));
        String line="";
        while ((line = bufferedReader.readLine()) != null){
            String data[] = line.split(",");
            Put p = new Put(Bytes.toBytes(data[0]));
            p.addColumn(Bytes.toBytes("personal"),
                    Bytes.toBytes("name"),Bytes.toBytes(data[1]));
            p.addColumn(Bytes.toBytes("personal"),
                    Bytes.toBytes("gender"),Bytes.toBytes(data[2]));
            p.addColumn(Bytes.toBytes("personal"),
                    Bytes.toBytes("company"), Bytes.toBytes(data[3]));
            p.addColumn(Bytes.toBytes("personal"),
                    Bytes.toBytes("salary"), Bytes.toBytes(data[4]));
            p.addColumn(Bytes.toBytes("personal"),
                    Bytes.toBytes("mobile"), Bytes.toBytes(data[5]));
            table.put(p);
            System.out.println("Inserted the record:"+line);
        }
        System.out.println("Data inserted Successfully from the file");
        table.close();
    }
}
