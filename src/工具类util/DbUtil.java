package 工具类util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * 数据库工具类
 * @author peng
 */
public class DbUtil {

	private String dbUrl="jdbc:mysql://localhost:3306/db_book";
	private String dbUser="root";
	private String dbPassword="123456";
	private String jdbcName="com.mysql.jdbc.Driver";
	/*
	 * 获取数据库连接
	 */
	public Connection getCon()throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		return con;
	}
	/*
	 * 关闭数据库连接
	 */
	public void closeCon(Connection con)throws Exception{
		if(con!=null){      //null的话会报空指针异常
			con.close();
		}
	}

	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}
