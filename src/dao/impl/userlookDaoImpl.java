package dao.impl;

import dao.BaseDao;
import dao.userlookDao;
import entity.userbuy;
import entity.userlook;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class userlookDaoImpl extends BaseDao implements userlookDao {
    @Override
    public int adduserlook(userlook userlook) {
        String sql="insert into userlook(username,goodname,timing)values(?,?,?)";
        Object[]obj={userlook.getName(), userlook.getGood(), userlook.getTime()};
        return this.executeUpdate(sql, obj);
    }

    @Override
    public List<userlook> getAll() {
        Connection conn=this.getConnection();
        List<userlook> list=new ArrayList<userlook>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from userlook");
            while(rs.next()){
                userlook u=new userlook();
                u.setName(rs.getString("username"));
                u.setGood(rs.getString("goodname"));
                u.setTime(rs.getString("timing"));
                list.add(u);

            }
            this.closeAll(conn, stmt, rs);
            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
