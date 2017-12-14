package com.siva;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;

import java.io.IOException;

/**
 * Created by Sivakumar Annamalai on 11/25/2017.
 */
public class ListTables extends HBaseProjectConstants{
    public static void main(String args[]) throws IOException {
        Admin admin = getConnection().getAdmin();
        TableName tables[] = admin.listTableNames();
        for(TableName t: tables){
            System.out.println(t.getNameAsString());
        }
    }
}
