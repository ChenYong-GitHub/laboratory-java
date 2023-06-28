package com.example.corejava8.database;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.*;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

/**
 * 监听MySQL数据表变更，如果采用本地缓存时，可以考虑采用监听表变更来清理本地缓存
 */
public class MySQLBinlogListener {
    public static void main(String[] args) {
        BinaryLogClient client = new BinaryLogClient("172.18.9.99", 3306,"t_order_config_service", "user_test", "UserTest1246");
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setCompatibilityMode(EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG);
        client.setEventDeserializer(eventDeserializer);

        client.registerEventListener(event -> {
//            EventHeaderV4 header = event.getHeader();
            EventData data = event.getData();
//            if (header.getEventType().equals(EventType.UPDATE_ROWS)) {
//
//            }
            if (data instanceof TableMapEventData) {
                TableMapEventData tableMapEventData = (TableMapEventData) data;
                String database = tableMapEventData.getDatabase();
                String table = tableMapEventData.getTable();
                if (table.equals("temporary")) {
                    System.out.println("database:" + database);
                    System.out.println("table:" + table);
                }


//                if (database.equals("t_order_config_service") && table.equals("temporary")) {
//                    if (data instanceof UpdateRowsEventData) {
//                        UpdateRowsEventData eventData = (UpdateRowsEventData) data;
//                        // 处理更新行的事件
//                        System.out.println("表发生更新：" + eventData.getTableId());
//                        System.out.println("更新的行：" + eventData.getRows());
//                    } else if (data instanceof WriteRowsEventData) {
//                        WriteRowsEventData eventData = (WriteRowsEventData) data;
//                        // 处理插入行的事件
//                        System.out.println("表发生插入：" + eventData.getTableId());
//                        System.out.println("插入的行：" + eventData.getRows());
//                    } else if (data instanceof DeleteRowsEventData) {
//                        DeleteRowsEventData eventData = (DeleteRowsEventData) data;
//                        // 处理删除行的事件
//                        System.out.println("表发生删除：" + eventData.getTableId());
//                        System.out.println("删除的行：" + eventData.getRows());
//                    }
//                }
            }
        });

        try {
            client.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}