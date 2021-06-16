package view;
import java.sql.*;

import gui.Gui;
//进行数据的读取，从数据库中，然后控制台打印
public class View {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/road";
    static final String USER = "road";
    static final String PASS = "o7WV5zY111YnfTHZ";




    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, Country, Road_No, Road_Category, Province_Name, Start_Point_City, End_Point_City, Section_Length, Year_of_Construction, Year_of_Recent_Improvement FROM websites";
            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String country = rs.getString("Country");
                String roadno = rs.getString("Road_No");
                String roadcatalog = rs.getString("Road_Category");
                String provincename = rs.getString("Province_Name");
                String startcity = rs.getString("Start_Point_City");
                String endcity = rs.getString("End_Point_City");
                String sectionlength = rs.getString("Section_Length");
                String yearofcon = rs.getString("Year_of_Construction");
                String yearofrecentim = rs.getString("Year_of_Recent_Improvement");


                // 输出数据
                System.out.print("ID: " + id + "\n");
                System.out.print(" Country: " + country + "\n");
                System.out.print(" Road_No: " + roadno + "\n");
                System.out.print(" Road_Category: " + roadcatalog + "\n");
                System.out.print(" Province_Name: " + provincename + "\n");
                System.out.print(" Start_Point_City: " + startcity + "\n");
                System.out.print(" End_Point_City: " + endcity + "\n");
                System.out.print(" Section_Length: " + sectionlength + "\n");
                System.out.print(" Year_of_Construction: " + yearofcon + "\n");
                System.out.print(" Year_of_Recent_Improvement: " + yearofrecentim + "\n");
                System.out.print("\n");
                System.out.println("----------------------------------");
                System.out.print("\n");

                Gui e = new Gui(country);
                e.gui();

            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            } // 什么都不做
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("----------select data complete!----------");

    }
    
}
