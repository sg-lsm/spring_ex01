package Todo.dao;

import Todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TodoDAO{
    public String getTime() throws Exception{
    @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
    @Cleanup PreparedStatement pstmt = conn.prepareStatement("select now()");
    @Cleanup ResultSet rs = pstmt.executeQuery();
    rs.next();
    String now = rs.getString(1);
    return now;
    }

    public void insert(TodoVO vo) throws Exception{
        String sql = "insert into tbl_todo (title, localDate, finished) values (?, ?, ?)";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getTitle());
        pstmt.setDate(2, Date.valueOf(vo.getLocalDate()));
        pstmt.setBoolean(3, vo.isFinished());
        pstmt.executeUpdate();
    }
}