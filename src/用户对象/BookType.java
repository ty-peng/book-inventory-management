package 用户对象;


public class BookType {
	
	private int id;
	private String bookTypeName;
	private String bookTypeDesc;//描述
	
	
	
	/**
	 * 从父类生成的构造方法，必须要加
	 */
	public BookType() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
	
	
	public BookType(String bookTypeName, String bookTypeDesc) {
		super();
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}

	
	


	public BookType(int id, String bookTypeName, String bookTypeDesc) {
		super();
		this.id = id;
		this.bookTypeName = bookTypeName;
		this.bookTypeDesc = bookTypeDesc;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookTypeDesc() {
		return bookTypeDesc;
	}
	public void setBookTypeDesc(String bookTypeDesc) {
		this.bookTypeDesc = bookTypeDesc;
	}



	/**
	 * 重写输出方法给图书类别下拉框
	 */
	@Override
	public String toString() {
		return bookTypeName;
	}
	
	
	
}
