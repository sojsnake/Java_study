import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionTest {
    @Test // 필수
    @DisplayName("DB연결 테스트 결과") // 선택

    public void testConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;

        // 1. 드라이버설정
        Class.forName("com.mysql.cj.jdbc.Driver"); // 파일연결 -> 예외처리 필요
        System.out.println("1. 드라이버설정성공..");

        // 2. 데이터베이스연결
        String url = "jdbc:mysql://localhost:3306/jdbc_ex";
        String user = "scoula";
        String password = "1234";
        con = DriverManager.getConnection(url, user, password); // 네트워크 연결 -> 예외처리 필요
        System.out.println("2. db연결성공.");
        //con에 연결이 성공하면 연결 통로에 해당하는 객체가 메모리에 생김(주소를 가짐.)
        //com에 연결이 실패하면 연결 통로에 해당하는 객체가 메모리에 안생김(null을 가짐.)

        Assertions.assertNotNull(con);
    }

    @Test
    @DisplayName("jdbc_ex에 접속한다.(자동 닫기)")
    public void testConnection2() throws SQLException{
        try(Connection conn = JDBCUtil.getConnection()){
            System.out.println("DB 연결 성공");
        }
    }

}