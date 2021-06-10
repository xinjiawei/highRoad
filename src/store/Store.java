package store;
import net.sf.json.*;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Store {
 //0000000000000000000000000000000000000000000000000
    private String name;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/road";
	static final String USER = "road";
	static final String PASS = "o7WV5zY111YnfTHZ";

    public Store(String name) {
        this.name = name;
    }

    protected String getJson() {
        return name;
    }
 //0000000000000000000000000000000000000000000000000


    public String JsonAray() {
		Connection conn = null;
        PreparedStatement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
			//0000000000000000000000000000000000000000000000000000000000000000000000
			String json = getJson();
			JSONObject jsonObject = JSONObject.fromObject(json);
			// JSONObject data = jsonObject.getJSONObject("data");
			JSONArray items = jsonObject.getJSONObject("data").getJSONArray("items");
			JSONObject row = null;
			for (int i = 0; i < items.size(); i++) {
				row = items.getJSONObject(i);

				String sql = "insert into websites values (?,?,?,?,?,?,?,?,?,?)";
				stmt = (PreparedStatement) conn.prepareStatement(sql);
				stmt.setInt(1, Integer.parseInt(String.valueOf(row.get("id"))));
				stmt.setString(2, String.valueOf(row.get("Country")));
				stmt.setString(3, String.valueOf(row.get("Road_No")));
				stmt.setString(4, String.valueOf(row.get("Road_Category")));
				stmt.setString(5, String.valueOf(row.get("Province_Name")));

				stmt.setString(6, String.valueOf(row.get("Start_Point_City")));
				stmt.setString(7, String.valueOf(row.get("End_Point_City")));
				stmt.setString(8, String.valueOf(row.get("Section_Length")));
				stmt.setString(9, String.valueOf(row.get("Year_of_Construction")));
				stmt.setString(10, String.valueOf(row.get("Year_of_Recent_Improvement")));

				stmt.executeUpdate();

			}

		}catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(
	Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally
	{
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

        return "ok";

    }
    
}
