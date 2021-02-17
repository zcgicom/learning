package com.itcat.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 步骤：
 *      1.导入驱动jar包（需要add as library）
 *      2.注册驱动
 *      3.获取数据库连接
 *      4.定义SQL语句
 *      5.获取执行sql对象的Statement
 *      6.执行sql
 *      7.处理结果
 *      8.释放资源
 *
 * 对象：
 *      1.DriverManager：驱动管理对象
 *      2.Connection：数据库连接对象
 *      3.Statement：执行sql的对象
 *      4.ResultSet：结果集对象
 *      5.PrepareStatement：执行sql的对象
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db01?useUnicode=true&characterEncoding=UTF-8"
                , "root"
                , "fishbrain");
        //4.定义SQL语句
        String sql = "update dept set dname = '技术部'where deptno = '1'";
        //5.获取执行sql对象的Statement
        Statement st = connection.createStatement();
        //6.执行sql
        int count = st.executeUpdate(sql);//影响的行数
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        st.close();
        connection.close();
    }
}
