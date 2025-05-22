package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    //인터페이스 메서드를 재정의해서 구현해 줌.

    Connection conn = JDBCUtil.getConnection();

    //USERS 테이블 관련 sql 명령어
    private String USER_LIST = "select * from users";
    private String USER_GET = "select * from users where id = ?";
    private String USER_INSERT = "insert into users values(?, ?, ?, ?)";
    private String USER_UPDATE = "update users set name = ?, role = ? where id = ?";
    private String USER_DELETE = "delete from users where id = ?";

    @Override
    public int create(UserVO user) throws SQLException {
        //1,2,3,4 단계 코드 필요. 1,2 단계는 해놨기 때문에 함수 호출만 하면 연결됨
        //3,4단계만 코드하기
        PreparedStatement pstmt = conn.prepareStatement(USER_INSERT); //객체 만들기. 아직 ?로 되어있는 불완전 상태
        System.out.println("3단계 : sql문 객체로 만들기 성공함.");

        //set으로 '?'에 해당하는 값 넣어주기
        //set + 타입(위치 값, 넣을 값)
        pstmt.setString(1, user.getId()); //id
        pstmt.setString(2, user.getPassword()); //password
        pstmt.setString(3, user.getName()); //name
        pstmt.setString(4, user.getRole()); //role

        //4단계 - sql문 db 서버로 전송하고 뒷처리
        int count = pstmt.executeUpdate(); //보내고 결과를 받아옴
        //insert문의 결과는 실행된 row 수

//        Assertions.assertEquals(0, count); //맞으면 아무것도 안 뜸 => 확인 위해 그냥 0과 비교해봄 : 테스트 시에만 필요
        //자원 해제 - db 관련 자원은 close 필요
        pstmt.close();
        return count;
    }

    //여러 개 가방을 리스트로 묶어서 가져올 때
    @Override
    public List<UserVO> getList() throws SQLException {
        // 리스트로 여러 개의 vo 한 번에 가지고 옴

        //3. SQL문 객체 생성
        PreparedStatement pstmt = conn.prepareStatement(USER_LIST);
//        pstmt.setString(1, id); ?가 없기 때문에 필요 없음

        //4. select문을 mysql에 전송해보자
        //테이블 반환 받으려면 resultset
        ResultSet rs = pstmt.executeQuery(); //select
        //검색 행이 많은 경우에는
        //행 하나당 vo가 하나가 필요
        //행이 여러 개이면 이 vo를 넣어줄 list가 필요함
        List<UserVO> list = new ArrayList<>();

        while(rs.next()){ //반복할 때마다 다음 행을 가리키면서(내부적으로 커서가 가리킴) 있는지 체크해줌
            //행 여러개일 땐, 있을때 가방 만들어주기
            UserVO user = new UserVO(); //가방 만들어주기

            //각 컬럼 값을 꺼내와서 vo(bag)에 넣어주자 : 넣을 땐 set
            user.setId(rs.getString("id")); //스트링 가져와서 user에 넣기. id는 컬럼명
            user.setName(rs.getString("name"));
            //컬럼명대신 resultset(table)에 있는 인덱스를 쓸 수 있지만, 컬럼명을 권장
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));

            list.add(user);
            //가방을 list에 넣어주자
        }

        //리턴 전에 close
        pstmt.close();
        rs.close();

        return list; //자바는 리턴할 때 무조건 하나로 묶어주어야 함.
    }

    //하나의 가방만 가져올 때
    @Override
    public UserVO get(String id) throws SQLException {
        //3. SQL문 객체 생성
        PreparedStatement pstmt = conn.prepareStatement(USER_GET);
        pstmt.setString(1, id);

        //4. select문을 mysql에 전송해보자
        //테이블 반환 받으려면 resultset
        ResultSet rs = pstmt.executeQuery(); //select
        UserVO user = new UserVO(); //가방 만들어주기
        if(rs.next()){
            //테이블 있으면 true, 없으면 false
            //있으면 각 컬럼 값을 꺼내와서 vo(bag)에 넣어주자 : 넣을 땐 set
            user.setId(rs.getString("id")); //스트링 가져와서 user에 넣기. id는 컬럼명
            user.setName(rs.getString("name"));
            //컬럼명대신 resultset(table)에 있는 인덱스를 쓸 수 있지만, 컬럼명을 권장
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }//여기까지 하면 테이블 들어감

        //리턴 전에 close
        pstmt.close();
        rs.close();

        return user; //가방에 다 넣었기 때문에 가방을 리턴(하나로 묶어서 리턴)
        //dao에서는 컬럼의 추출값을 묶어줄 때 vo를 사용함
    }

    @Override
    public int update(UserVO user) throws SQLException {
        //private String USER_UPDATE = "update users set name = ?, role = ? where id = ?";

        PreparedStatement pstmt = conn.prepareStatement(USER_UPDATE); //객체 만들기. 아직 ?로 되어있는 불완전 상태
        System.out.println("3단계 : sql문 객체로 만들기 성공함.");

        //set으로 '?'에 해당하는 값 넣어주기
        //set + 타입(위치 값, 넣을 값)
        pstmt.setString(1, user.getName());
        pstmt.setString(2, user.getRole());
        pstmt.setString(3, user.getId());

        //executeUpdate : int값 반환 -> 몇 개의 행에 쿼리문이 영향을 끼쳤는지
        int row = pstmt.executeUpdate(); // -> DB에 쿼리 요청 보냄. 제대로 처리되면 int 값을 반환

        pstmt.close();

        return row;
    }

    @Override
    public int delete(String id) throws SQLException {
        //private String USER_DELETE = "delete from users where id = ?";
        PreparedStatement pstmt = conn.prepareStatement(USER_DELETE);
        pstmt.setString(1,id);

        // DB에 쿼리 요청 -> id가 pk일 때 정상동작하면 row = 1
        int row = pstmt.executeUpdate();

        pstmt.close();

        return row;
    }
}
