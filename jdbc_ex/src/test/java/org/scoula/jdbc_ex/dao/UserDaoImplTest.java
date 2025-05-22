package org.scoula.jdbc_ex.dao;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserDaoImplTest {
    Connection conn = JDBCUtil.getConnection();
    private UserDaoImpl userDao;

    @BeforeEach
    void setUp() {
        userDao = new UserDaoImpl();
    }

    @AfterAll
    static void tearDown() throws SQLException {
        JDBCUtil.close();
    }

    @Test
    @Disabled
    void create() {
    }

    @Test
    @Disabled
    void getList() {
    }

    @Test
    @Disabled
    void get() {
    }

    @Test
    @Disabled
    void update() throws SQLException {
        //given
        UserVO user = new UserVO(".ice", "pass123", "Updated Name", "ADMIN");
        //user 객체 생성

        //when
        int result = userDao.update(user);

        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
//    @Disabled
    void delete() throws SQLException {
        //given
        String id = ".ice";

        //when
        int result = userDao.delete(id);

        //then
        assertThat(result).isEqualTo(1);
    }
}