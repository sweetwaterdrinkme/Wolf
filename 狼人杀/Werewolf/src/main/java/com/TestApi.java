package com;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import java.io.IOException;

public class TestApi {
    public static Connection connection = null;
    public static Admin admin = null;

    static {
        try {
            // 获取配置信息
            Configuration configuration = HBaseConfiguration.create();
            configuration.set("hbase.zookeeper.quorum", "master");

            // 创建连接对象
            connection = ConnectionFactory.createConnection(configuration);

            // 创建 admin 对象
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 关闭连接
    public static void close() {
        if (admin != null) {
            try {
                admin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {
        // 判断表是否存在
//        System.out.println(isTableExists("t1"));

        // 创建表
//        createTable("t2", "info");

        // 将表创建到命名空间中
//        createTable("0808:t2", "info");

        // 删除表
//        deleteTable("t2");

        // 创建命名空间
//        createNameSpace("0808");

        // 关闭资源
        close();

    }
}