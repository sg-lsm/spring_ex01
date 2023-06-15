package Todo.dao;

import Todo.domain.TodoVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<TodoVO> selectAll() throws Exception{
        String sql = "select * from tbl_todo";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        while(rs.next()){
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .localDate(rs.getDate("localDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();
            list.add(vo);
        }
        return list;
    }
    public TodoVO searchByTno(Long tno) throws Exception{
        String sql = "select * from tbl_todo where tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, tno);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        TodoVO vo = TodoVO.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .localDate(rs.getDate("localDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();
        return vo;
    }

    public void deleteByTno(Long tno) throws Exception{
        String sql = "delete from tbl_todo where tno = ?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, tno);
        pstmt.executeUpdate();
    }

    public void updateOne(TodoVO vo) throws Exception{
        String sql = "update tbl_todo set title=?, localDate=?, finished=? where tno=?";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, vo.getTitle());
        pstmt.setDate(2, Date.valueOf(vo.getLocalDate()));
        pstmt.setBoolean(3, vo.isFinished());
        pstmt.setLong(4, vo.getTno());

        pstmt.executeUpdate();

    }
}