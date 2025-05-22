package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    //1. 드라이버 설정
    //2. db 연결 이용해서 연결하는 것까지
    //-> Connection con; <-- con을 리턴

    static Connection conn = null;
    public static Connection getConnection(){
        if(conn != null) return conn; //이미 만들어져 있으면 그걸 리턴

        try{
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password); // 네트워크 연결 -> 예외처리 필요

        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(){
        if(conn!= null){
            try {
                conn.close();
                conn= null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}