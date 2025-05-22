package org.scoula.jdbc_ex.test;
import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;
import java.sql.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    //1, 2단계 해결 - 연결 부품 가져오기
    Connection conn = JDBCUtil.getConnection();

    @AfterAll
    //아래 메서드 전부 호출한 후 한 번만 실행하는 기능 -> 여기서는 마지막에 close할 수 있도록 함
    static void tearDown() {
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException {
        //3단계 - sql문 객체 생성
        String sql = "insert into users(id, password, name, role) values(?, ?, ?, ?)";
        //?연산자는 가입할 사람이 어떤 데이터를 넣을지 모르기때문에 그 자리에 ?로 설정함
        //?는 번호가 있음. 1번부터 시작해서 순서대로. 여기서는 4개니까 4번까지

        //http://www.naver.com --> 사람은 url로 보지만, java는 string으로 인식
        //URL url = new URL("http://www.naver.com"); --> 이렇게 하면 java도 url로 인식함
        //sql도 URL 처럼 해당하는 부품이 있음 => Statement(문장), PreparedStatement(준비된 문장)

        //sql이라고 인식시켜주기 위해서는 PreparedStatement를 사용해주어야 함
        //2단계에서 만들어주었던 conn을 사용해서 preparestatement로 sql 객체 만들어줌
        // => 2단계 선행이 필수. 2단계에서 실패하면 3단계도 실패
        PreparedStatement pstmt = conn.prepareStatement(sql); //객체 만들기. 아직 ?로 되어있는 불완전 상태
        System.out.println("3단계 : sql문 객체로 만들기 성공함.");

        //set으로 '?'에 해당하는 값 넣어주기
        //set + 타입(위치 값, 넣을 값)
        pstmt.setString(1, "scoula6"); //id
        pstmt.setString(2, "scoula3"); //password
        pstmt.setString(3, "스콜라"); //name
        pstmt.setString(4, "USER"); //role

        //4단계 - sql문 db 서버로 전송하고 뒷처리
        int count = pstmt.executeUpdate(); //보내고 결과를 받아옴
        //insert문의 결과는 실행된 row 수

        Assertions.assertEquals(0, count); //맞으면 아무것도 안 뜸 => 확인 위해 그냥 0과 비교해봄
        //자원 해제 - db 관련 자원은 close 필요
        pstmt.close();
    }




    @Test
    @DisplayName("user 목록을 추출한다.")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql ="select * from users";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            System.out.println(rs.getString("name"));
        }
        stmt.close();
    }

    @Test
    @DisplayName("특정 user 검색한다.")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userid = "scoula";
        String sql ="select * from users where id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, userid);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            System.out.println(rs.getString("name"));
        } else {
            throw new SQLException("scoula not found");
        }
        stmt.close();
        rs.close();
    }

    @Test
    @DisplayName("특정 user 수정한다.")
    @Order(4)
    public void updateUser() throws SQLException {
        String userid = "scoula";
        String sql ="update users set name= ?  where id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "스콜라 수정");
        stmt.setString(2, userid);
        int count = stmt.executeUpdate();
        Assertions.assertEquals(1, count);
        stmt.close();
    }

    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql ="delete from users where id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, userid);
        int count = stmt.executeUpdate();
        Assertions.assertEquals(1, count);
        stmt.close();
    }
}