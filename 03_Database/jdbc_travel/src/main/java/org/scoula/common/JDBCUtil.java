package org.scoula.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//DAO 1, 2단계 getConnection 코드가 동일하므로 클래스 하나 만들어서 사용해 줌
public class JDBCUtil {
    static Connection conn = null;

    // 자주 호출되는 메서드 static으로 만들어 두면 좋음
    public static Connection getConnection() {

        if(conn != null)
            return conn;

        //conn이 null이면, 프로퍼티 읽어오기 -> application.properties와 같은 이름으로 불러와야 함.
        //읽어와서 연결해주기
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            Class.forName(driver);
            //drivermanager가 설정한 것을 연결해 줌.
            conn = DriverManager.getConnection(url, id, password);
            //연결이 되었으면 conn 안에 주소 들어가고, 안 되었으면 null들어감.
            //=> 테스트에서 확인
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}