package org.lsm.dao;

import Todo.dao.ConnectionUtil;
import Todo.dao.TodoDAO;
import Todo.domain.TodoVO;
import lombok.Cleanup;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class TodoDaoTest {

    @BeforeEach
    public void ready(){
       TodoDAO dao = new TodoDAO();
    }

    @Test
    public void testTime() throws Exception{
        TodoDAO dao = new TodoDAO();
        System.out.println(dao.getTime());
    }

    public String testTime2() throws Exception{
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }

    @Test
    public void insertTest() throws Exception{
        TodoVO vo = TodoVO.builder().title("111").localDate(LocalDate.now()).build();
        TodoDAO dao = new TodoDAO();
        dao.insert(vo);
    }
}
