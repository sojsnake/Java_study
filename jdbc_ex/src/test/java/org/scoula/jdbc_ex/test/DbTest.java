package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbTest {
    // 단위테스트 하려고 함
    // -> 기능 단위 -> 메서드 구현
    // 메서드 하나씩 테스트 가능
    // JUnit 5
    // 본 코드를 하기 전에 테스트를 충분히 거치고난 후 리팩토링하여 본 코드를 하면 에러율 낮아지고, 효과적으로 코딩 가능
    // = TDD 방법론

    @Test // 필수
    @DisplayName("DB연결 테스트 결과") // 테스트 제목 - 선택

    public void test1() throws ClassNotFoundException, SQLException {
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

        Assertions.assertNull(con);
        //실제로는 연결이 잘 되었기 때문에 테스트는 실패로 뜨고, 주소가 들어감
    }

    @Test
    @DisplayName("JDBCUtil 라이브러리 이용 테스트 결과")
    public void test2(){
        Connection con = JDBCUtil.getConnection();
        //JDBCUtil 안에서 예외처리 했으므로 부른 곳에서 예외처리 할 필요는 없다
        Assertions.assertNull(con);
        // 값이 null인지 보장하는지 -> 진짜 null이면 아무것도 안 나오고, 아니면 다른 것에 대한 보고서가 나옴.
    }
}
