package 用户对象;

public class Book {

	private int id;
	private String bookName;
	private String author;
	private String country;
	private Float price;
	private Integer bookTypeId;
	private String bookTypeName;
	private String bookDesc;
	
	
	
	
	public Book() {
		super();
		// TODO 自动生成的构造函数存根
	}
	
	
	
	public Book(String bookName, String author, String country, Float price, Integer bookTypeId, String bookDesc) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.country = country;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}


	

	public Book(int id, String bookName, String author, String country, Float price, Integer bookTypeId,
			String bookDesc) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.author = author;
		this.country = country;
		this.price = price;
		this.bookTypeId = bookTypeId;
		this.bookDesc = bookDesc;
	}



	public Book(String bookName, String author, Integer bookTypeId) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.bookTypeId = bookTypeId;
	}


	





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(Integer bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getBookTypeName() {
		return bookTypeName;
	}
	public void setBookTypeName(String bookTypeName) {
		this.bookTypeName = bookTypeName;
	}
	public String getBookDesc() {
		return bookDesc;
	}
	public void setBookDesc(String bookDesc) {
		this.bookDesc = bookDesc;
	}
	
	
	
}
