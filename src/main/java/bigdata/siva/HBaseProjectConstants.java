package bigdata.siva;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by Sivakumar Annamalai on 11/25/2017.
 */
public class HBaseProjectConstants {

    public static final String RESOURCES_DIR = "C:\\Users\\sivakumaran\\IdeaProjects\\HBase\\src\\main\\resources";


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

    public static Connection getConnection() throws IOException {
        Configuration config = HBaseConfiguration.create();
        System.out.println("Creating connection");
        return ConnectionFactory.createConnection(config);
    }

}
