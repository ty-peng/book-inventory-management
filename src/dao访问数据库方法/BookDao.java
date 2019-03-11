package dao访问数据库方法;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import 工具类util.StringUtil;
import 用户对象.Book;

public class BookDao {

	/**
	 * 图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		String sql="insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3,book.getCountry());
		pstmt.setFloat(4,book.getPrice());
		pstmt.setInt(5,book.getBookTypeId());
		pstmt.setString(6,book.getBookDesc());
		return pstmt.executeUpdate();
	}
	/**
	 * 报废图书添加
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int addC(Connection con,Book book)throws Exception{
		String sql="insert into t_condemned values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3,book.getCountry());
		pstmt.setFloat(4,book.getPrice());
		pstmt.setInt(5,book.getBookTypeId());
		pstmt.setString(6,book.getBookDesc());
		pstmt.setString(7, "condemned");
		return pstmt.executeUpdate();
	}
	
	/**
	 * 精确图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet listCertain(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");//StringBuffer可以拼接
		
		/*
		 * 判断三个搜索条件框都已填或已选
		 */
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and b.bookName="+book.getBookName());
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author="+book.getAuthor());
		}
		if(StringUtil.isNotEmpty(book.getCountry())){
			sb.append(" and b.country="+book.getCountry());
		}
		if(book.getBookTypeId()!=null&&book.getBookTypeId()!=-1){
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());//替换语句
		return pstmt.executeQuery();
		
		
	}
	
	/**
	 * 图书信息查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");//StringBuffer可以拼接
		
		/*
		 * 判断三个搜索条件框都已填或已选
		 */
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null&&book.getBookTypeId()!=-1){
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());//替换语句
		return pstmt.executeQuery();
		
		
	}
	/**
	 * 报废图书查询
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet listC(Connection con,Book book)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_condemned b,t_bookType bt where b.bookTypeId=bt.id");//StringBuffer可以拼接
		
		/*
		 * 判断三个搜索条件框都已填或已选
		 */
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId()!=null&&book.getBookTypeId()!=-1){
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());//替换语句
		return pstmt.executeQuery();
		
		
	}
	/**
	 * 查询同名
	 * @param con
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public ResultSet sameName(Connection con,String bookName)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(bookName)){
			sb.append(" and b.bookName like '%"+bookName+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());//替换语句
		return pstmt.executeQuery();
	}
	/**
	 * 报废图书同名
	 * @param con
	 * @param bookName
	 * @return
	 * @throws Exception
	 */
	public ResultSet sameNameC(Connection con,String bookName)throws Exception{
		StringBuffer sb=new StringBuffer("select * from t_condemned b,t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(bookName)){
			sb.append(" and b.bookName like '%"+bookName+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());//替换语句
		return pstmt.executeQuery();
	}
	
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,String id)throws Exception{
		String sql="delete from t_book where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
		
	}
	/**
	 * 报废图书删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteC(Connection con,String id)throws Exception{
		String sql="delete from t_condemned where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
		
		
	}
	/**
	 * 报废图书全部删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int deleteCAll(Connection con)throws Exception{
		String sql="delete from t_condemned where status=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, "condemned");
		return pstmt.executeUpdate();
		
		
	}
	

	/**
	 * 图书信息更改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book)throws Exception{
		String sql="update t_book set bookName=?,author=?,country=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,book.getBookName());
		pstmt.setString(2,book.getAuthor());
		pstmt.setString(3,book.getCountry());
		pstmt.setFloat(4,book.getPrice());
		pstmt.setString(5,book.getBookDesc());
		pstmt.setInt(6,book.getBookTypeId());
		pstmt.setInt(7,book.getId());
		return pstmt.executeUpdate();
	}
	
	/**
	 * 判断指定的图书类别下是否存在图书
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByBookTyped(Connection con,String bookTypeId)throws Exception{
		String sql="select * from t_book where bookTypeId=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,bookTypeId);
		ResultSet rs=pstmt.executeQuery();
		return rs.next();
	}
	
}
