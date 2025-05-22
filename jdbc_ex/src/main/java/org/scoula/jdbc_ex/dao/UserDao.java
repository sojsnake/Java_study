package org.scoula.jdbc_ex.dao;
import org.scoula.jdbc_ex.domain.UserVO;
import java.sql.SQLException;
import java.util.List;

/*
* DAO(Data Access Object)
* - DB 접근을 담당하는 객체
* - VO을 이용
* */

public interface UserDao {
    // 회원 등록
    int create(UserVO user) throws SQLException;
    // 회원 목록 조회
    List<UserVO> getList() throws SQLException;
    // 회원 정보 조회
    UserVO get(String id) throws SQLException;
    // 회원 수정
    int update(UserVO user) throws SQLException;
    // 회원 삭제
    int delete(String id) throws SQLException;


    //메서드를 여러 개 호출했으므로 예외 처리는 메서드 단위로 해줘야 함.
}