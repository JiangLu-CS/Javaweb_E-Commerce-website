package dao;
import java.sql.*;


import javax.naming.Context;
import javax.naming.InitialContext;

import javax.print.attribute.standard.JobKOctets;
import javax.sql.DataSource;

public class BaseDao {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=estore;user=jianglu;password=123";
    Connection conn = null;

    public Connection getConnection(){
        if(conn == null){
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public int executeUpdate(String sql, Object[]obj){
        PreparedStatement pstmt = null;
        int num = 0;
        conn = getConnection();
        try{
            pstmt = conn.prepareStatement(sql);
            if(obj != null){
                for(int i = 0; i < obj.length; i++){
                    pstmt.setObject(i+1, obj[i]);
                }
            }
            num = pstmt.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            closeAll(conn, pstmt, null);
        }
        return num;
    }

    }
