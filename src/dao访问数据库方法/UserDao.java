package dao访问数据库方法;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 用户对象.User;

public class UserDao {
	
	/*
	 * 管理员登录验证
	 */
	public User login(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from t_user where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
		
	}
	
	/*
	 * 一般用户登录验证
	 */
	public User normallogin(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="select * from t_normal where userName=? and password=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			resultUser=new User();
			resultUser.setId(rs.getInt("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		
		return resultUser;
		
	}
	/*
	 * 一般用户注册
	 */
	public int register(Connection con,User user)throws Exception{
		User resultUser=null;
		String sql="insert into t_normal values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		int n=pstmt.executeUpdate();
		
		
		return n;
	}
}
