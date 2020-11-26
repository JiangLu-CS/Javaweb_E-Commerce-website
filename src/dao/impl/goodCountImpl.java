package dao.impl;

import dao.BaseDao;
import dao.goodCountDao;
import entity.goodcount;
import entity.userlook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class goodCountImpl extends BaseDao implements goodCountDao {
    @Override
    public int addgood(goodcount good) {
        String sql="update goodtotal set profit=?,number=? where goodname = ?";
        Object[]obj={good.getProfit(), good.getNumber(), good.getName()};
        return this.executeUpdate(sql, obj);
    }

    @Override
    public List<goodcount> getAll() {
        Connection conn=this.getConnection();
        List<goodcount> list=new ArrayList<goodcount>();
        try {
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from goodtotal");
            while(rs.next()){
                goodcount u=new goodcount();
                u.setName(rs.getString("goodname"));
                u.setProfit(rs.getInt("profit"));
                u.setNumber(rs.getInt("number"));
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

    @Override
    public goodcount findGood(goodcount good) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            String sql = "select * from goodtotal where goodname = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,good.getName());
            rs = pstmt.executeQuery();
            while(rs.next()){
                goodcount u = new goodcount();
                u.setNumber(rs.getInt("number"));
                u.setProfit(rs.getInt("profit"));
                return u;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int findnum(goodcount good) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            String sql = "select number from goodtotal where goodname = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,good.getName());
            rs = pstmt.executeQuery();
            while(rs.next()){
                return rs.getInt("number");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int findProfit(goodcount good) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            String sql = "select profit from goodtotal where goodname = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,good.getName());
            rs = pstmt.executeQuery();
            while(rs.next()){
                return rs.getInt("profit");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
}
