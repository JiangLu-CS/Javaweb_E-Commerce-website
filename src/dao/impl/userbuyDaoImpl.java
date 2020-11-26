package dao.impl;

        import dao.BaseDao;
        import dao.userDao;
        import dao.userbuyDao;
        import entity.User;
        import entity.userbuy;

        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;

public class userbuyDaoImpl extends BaseDao implements userbuyDao {
    @Override
    public int adduserbuy(userbuy userbuy) {
        String sql="insert into userbuy(username,goodname,timing)values(?,?,?)";
        Object[]obj={userbuy.getName(), userbuy.getGood(), userbuy.getTime()};
        return this.executeUpdate(sql, obj);
    }

    @Override
    public List<userbuy> getAll() {
        Connection conn=this.getConnection();
        List<userbuy> list=new ArrayList<userbuy>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from userbuy");
            while(rs.next()){
                userbuy u=new userbuy();
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
