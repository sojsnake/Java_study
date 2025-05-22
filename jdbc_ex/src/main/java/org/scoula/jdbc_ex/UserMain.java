package org.scoula.jdbc_ex;
import org.scoula.jdbc_ex.dao.UserDao;
import org.scoula.jdbc_ex.dao.UserDaoImpl;
import org.scoula.jdbc_ex.domain.UserVO;
import org.scoula.jdbc_ex.service.LoginUser;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserMain {
    static UserDao userDao = new UserDaoImpl();
    static Scanner sc = new Scanner(System.in);
    static final LoginUser loginUser = new LoginUser();

    public static void main(String[] args) throws SQLException {
        UserVO loggedInUser = null;

        while(loggedInUser == null){
            loggedInUser = login();
        }

        while (true) {
            System.out.println("원하는 작업을 선택하시오.");
            System.out.println("=====================");
            System.out.println("1. insert");
            System.out.println("2. selectList");
            System.out.println("3. selectOne");
            System.out.println("4. update");
            System.out.println("5. delete");
            System.out.println("6. exit");
            System.out.println("=====================");
            System.out.print("번호 입력>> ");
            int choice = sc.nextInt();
            if (choice == 1) {
                insert();
            } else if (choice == 2) {
                selectList(); //vo 여러개 -> list를 리턴
            } else if (choice == 3) {
                selectOne(); //vo 하나를 리턴
            } else if (choice == 4) {
                update();
            } else if (choice == 5) {
                delete();
            } else if (choice == 6) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0); //프로그램 종료
            } else {
                System.out.println("선택이 올바르지 않음.");
            }
        }
    }

    public static void insert() throws SQLException {
        UserVO user = new UserVO(); //가방 만들어서 값 받고

        System.out.println("id, pw, name, role을 순서대로 입력하시오.");

        System.out.print("id(12글자 이내) >> ");
        user.setId(sc.next());

        System.out.print("pw(12글자 이내) >> ");
        user.setPassword(sc.next());

        System.out.print("name(30글자 이내) >> ");
        user.setName(sc.next());

        System.out.print("role(6글자 이내) >> ");
        user.setRole(sc.next());

        int result = userDao.create(user); //dao에 가방 전달

        if (result == 1) {
            System.out.println("insert 성공!");
        }
    }

    public static void selectList() throws SQLException {
        //List<UserVO> 리스트로 리턴받음
        List<UserVO> list = userDao.getList();

        //for문 돌려서 list에서 가방 꺼내주고 가방을 프린트
        for(UserVO user : list){
            printVO(user);
        }
    }

    private static void printVO(UserVO userVO) {
        System.out.println("아이디 : " + userVO.getId() + ", 패스워드 : " + userVO.getPassword() + ", 이름 : " + userVO.getName() + ", 역할 : " + userVO.getRole());
    }

    public static void selectOne() throws SQLException {
        System.out.println("검색하고자하는 id를 입력하시오.");
        System.out.print("id(12글자 이내) >> ");

        //입력받아서 id에 넣어줌
        String id = sc.next();

        //dao에 상세정보 검색해서 리턴 -> 상세정보는 vo를 리턴
        UserVO user  = userDao.get(id);

        //vo를 예쁘게 프린트 printVO() 메서드
        printVO(user);
    }

    public static void update() throws SQLException {
        //가방 만들고
        UserVO user = new UserVO();

        //입력받아 가방에 넣고
        System.out.println("name, role, id를 순서대로 입력하시오.");
        System.out.print("name(30글자 이내) >> ");
        user.setName(sc.next());

        System.out.print("role(6글자 이내) >> ");
        user.setRole(sc.next());

        System.out.print("id(12글자 이내) >> ");
        user.setId(sc.next());

        //userDao.update() 호출
        int result = userDao.update(user);

        if(result == 1){
            System.out.println("Update 성공!");
        } else{
            System.out.println("Update 실패!");
        }
    }

    public static void delete() throws SQLException {
        System.out.println("삭제하고자하는 id를 입력하시오.");
        System.out.print("id(12글자 이내) >> ");
        String id = sc.next();

        int result = userDao.delete(id);

        if(result ==1){
            System.out.println("Delete 성공");
        } else{
            System.out.println("Delete 실패");
        }
    }

    public static UserVO login(){
        System.out.println("🔐 로그인 정보를 입력하시오.");
        System.out.print("id >> ");
        String id = sc.next();
        System.out.print("password >> ");
        String pw = sc.next();

        UserVO user = null;
        try {
            user = loginUser.login(id, pw);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //login에서 던져준 예외 처리

        return user;
    }
}