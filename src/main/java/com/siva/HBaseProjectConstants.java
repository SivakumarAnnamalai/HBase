package com.siva;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by Sivakumar Annamalai on 11/25/2017.
 */
public class HBaseProjectConstants {

    public static final String RESOURCES_DIR = "/home/jpasolutions/IdeaProjects/HBase/src/main/resources";


    public static Connection getConnection() throws IOException {
        Configuration config = HBaseConfiguration.create();
        System.out.println("Creating connection");
        return ConnectionFactory.createConnection(config);
    }

    public static void createTable(Admin admin,String table,String... families) throws IOException {
        TableName tableName = TableName.valueOf(table);
        HTableDescriptor htable = new HTableDescriptor(tableName);
        for(String family:families){
            htable.addFamily(new HColumnDescriptor(family));
        }
        System.out.println("Creating Table.."+table);
        admin.createTable(htable);
        System.out.println("Created table "+table+" successfully ");
    }

    public static String getColumnValue(Result result,String family,
                                        String qualifier){
        return Bytes.toString(result.getValue(Bytes.toBytes(family),
                Bytes.toBytes(qualifier)));
    }

    public static Put putColumnData(Put p, String family,
                                     String qualifier, String value){
        return p.addColumn(Bytes.toBytes(family),
                Bytes.toBytes(qualifier),Bytes.toBytes(value));
    }

}
