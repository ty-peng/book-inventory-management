package dao访问数据库方法;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 工具类util.StringUtil;
import 用户对象.BookType;

public class BookTypeDao {

	/**
	 * 添加
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,BookType bookType)throws Exception{//int返回操作次数
		String sql="insert into t_bookType values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		return pstmt.executeUpdate();
	}
	/**
	 * 查询图书类别集合
	 * 只需要按名称查询，id太多时记不住
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,BookType bookType)throws Exception{
		/*
		 * StringBuffer类和String一样，也用来代表字符串，只是由于StringBuffer的内部实现方式和String不同，所以
		 * StringBuffer在进行字符串处理时，不生成新的对象，在内存使用上要优于String类。 
         *所以在实际使用时，如果经常需要对一个字符串进行修改，例如插入、删除等操作，使用StringBuffer要更加适合一些。

         *在StringBuffer类中存在很多和String类一样的方法，这些方法在功能上和String类中的功能是完全一样的。

		 *但是有一个最显著的区别在于，对于StringBuffer对象的每次修改都会改变对象自身，这点是和String类最大的区别。

		 */
		StringBuffer sb=new StringBuffer("select * from t_bookType");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())){
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and", "where"));//替换语句
		return pstmt.executeQuery();
		
	}
	/**
	 * 删除图书类别
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_bookType where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,id);
		return pstmt.executeUpdate();
	}
	/**
	 * 修改更新图书类别
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,BookType bookType)throws Exception{
		String sql="update t_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookTypeName());
		pstmt.setString(2, bookType.getBookTypeDesc());
		pstmt.setInt(3, bookType.getId());
		return pstmt.executeUpdate();
	}
}
