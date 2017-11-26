package com.jpa;

import org.apache.hadoop.hbase.client.Admin;

import java.io.IOException;

/**
 * Created by Sivakumar Annamalai on 11/25/2017.
 */
public class CreateTable extends HBaseProjectConstants{

    public static void main(String args[]) throws IOException {
        Admin admin = getConnection().getAdmin();
        createTable(admin,"test1","cf1");
        createTable(admin,"test2","cf1","cf2");
        createTable(admin,"test3","cf1","cf2","cf3");

        createTable(admin,"emp1","personal","professional");
        createTable(admin,"emp2","personal");

    }
}
