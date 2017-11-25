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
public class CreateTable1 extends HBaseProjectConstants{

    public static void main(String args[]) throws IOException {
        Configuration config = HBaseConfiguration.create();
        config.addResource("C:\\Users\\sivakumaran\\IdeaProjects\\HBase\\src\\main\\resources\\core-site.xml");
        config.addResource("C:\\Users\\sivakumaran\\IdeaProjects\\HBase\\src\\main\\resources\\hdfs-site.xml");
        config.addResource("C:\\Users\\sivakumaran\\IdeaProjects\\HBase\\src\\main\\resources\\hbase-site.xml");
        config.set("hbase.zookeeper.quorum", "sandbox.hortonworks.com:2181/hbase-unsecure");
        //config.set("hbase.zookeeper.property.dataDir","/home/bigdata/system/zookeeper");
        //config.set("hbase.rootdir","hdfs://ip-172-31-44-198.us-east-2.compute.internal:8020/hbase");
        System.out.println("Creating connection");
        Connection conn = ConnectionFactory.createConnection(config);
        System.out.println("Connection created");
        String table = "test1";
        String[] families = new String[]{"cf1"};
        TableName tableName = TableName.valueOf(table);
        HTableDescriptor htable = new HTableDescriptor(tableName);
        for(String family:families){
            htable.addFamily(new HColumnDescriptor(family));
        }
        System.out.println("Creating Table.."+table);
        conn.getAdmin().createTable(htable);
        System.out.println("Created table "+table+" successfully ");
    }
}
