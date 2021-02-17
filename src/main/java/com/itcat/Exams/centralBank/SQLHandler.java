package com.itcat.Exams.centralBank;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class SQLHandler {
    public static void update(String sql, Connection con) throws SQLException {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            con.close();
        }
    }
    public static String insertSql(String sql,Connection con,Object[] params) throws SQLException {
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        }catch (SQLException e){
            return "failed";
        }finally {
            con.close();
        }
        return "success";
    }
    public static Map<String ,Object> query(String sql, Connection con) throws SQLException {
        Map<String, Object> res = null;
        try {
            //获取连接对象
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int nums = rsmd.getColumnCount();
            res = new HashMap<String, Object>();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
            }
            for (int i = 0; i < nums; i++) {
                res.put(rsmd.getColumnName(i), rs.getObject(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return res;
    }
    public static String  del(String sql, Connection con, Object[] params) throws SQLException {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        }catch (SQLException e){
            return "failed";
        }finally {
            con.close();
        }
        return "success";
    }
}
