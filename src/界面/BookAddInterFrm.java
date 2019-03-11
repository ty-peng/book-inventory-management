package 界面;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

import dao访问数据库方法.BookDao;
import dao访问数据库方法.BookTypeDao;
import 工具类util.DbUtil;
import 工具类util.StringUtil;
import 用户对象.Book;
import 用户对象.BookType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookAddInterFrm extends JInternalFrame {
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;

	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JComboBox bookTypeJcb;
	private JTextArea bookDescTxt;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField countryTxt;
	private JRadioButton normalJrb;
	private JRadioButton condemnedJrb;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAddInterFrm frame = new BookAddInterFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAddInterFrm() {
		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
		setClosable(true);
		setIconifiable(true);
		setTitle("图书添加");
		setBounds(100, 100, 421, 376);
		
		JLabel lblNewLabel = new JLabel("图书名称：");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label = new JLabel("图书作者：");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("作者国家：");
		
		JLabel label_2 = new JLabel("图书价格：");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		JLabel label_3 = new JLabel("图书描述：");
		
		bookDescTxt = new JTextArea();
		
		JLabel label_4 = new JLabel("图书类别：");
		
		bookTypeJcb = new JComboBox();
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bookAddActionPerformed(e);
			}
		});
		button.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/add_16px_1175496_easyicon.net.png")));
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValueActionPerformed(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookAddInterFrm.class.getResource("/images/reset_16px_28523_easyicon.net.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JLabel label_5 = new JLabel("图书状态：");
		
		normalJrb = new JRadioButton("正常");
		normalJrb.setSelected(true);
		buttonGroup_1.add(normalJrb);
		
		condemnedJrb = new JRadioButton("报废");
		buttonGroup_1.add(condemnedJrb);
		
		countryTxt = new JTextField();
		countryTxt.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(lblNewLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)))
									.addGap(10)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label_1)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(countryTxt, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addGap(9)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(button)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(button_1)
											.addGap(35))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(13)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(normalJrb)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(condemnedJrb)))
					.addGap(63))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(countryTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(label_5))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(normalJrb)
								.addComponent(condemnedJrb))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(44)
							.addComponent(label_3))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		//设置文本域边框
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		fillBookType();

	}
	/**
	 * 重置事件处理
	 * @param e
	 */
	private void resetValueActionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		this.resetValue();
	}

	/**
	 * 图书添加事件处理
	 * @param e
	 */
	private void bookAddActionPerformed(ActionEvent e) {

		String bookName=this.bookNameTxt.getText();
		String author=this.authorTxt.getText();
		String price=this.priceTxt.getText();
		String bookDesc=this.bookDescTxt.getText();
		
		if(StringUtil.isEmpty(bookName)){
			JOptionPane.showMessageDialog(null, "图书名称不能为空！");
			return;
		}
		if(StringUtil.isEmpty(author)){
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}
		if(StringUtil.isEmpty(price)){
			JOptionPane.showMessageDialog(null, "图书价格不能为空！");
			return;
		}
		
		if(!StringUtil.isNum(price)){
			JOptionPane.showMessageDialog(null, "价格必须输入实数！");
			return;
		}
		
		
		String country=this.countryTxt.getText();
		if(StringUtil.isEmpty(country)){
			JOptionPane.showMessageDialog(null, "作者国家不能为空！");
			return;
		}
		
		Connection con=null;
		try {
			con = dbUtil.getCon();
			ResultSet rs = bookDao.sameName(con, bookName);
			while (rs.next()) {
				if (rs.getString("bookName").equals(bookName)) {//图书类型相同只看名字就可以了

					JOptionPane.showMessageDialog(null, "存在相同图书，已自动归入该类别！");
					int n = this.bookTypeJcb.getItemCount();//一共有多少项
					for (int i = 0; i < n; i++) {//下拉框选项依次和bookTypeName比较，相同则设置为该项
						BookType item = (BookType) this.bookTypeJcb.getItemAt(i);
						if (item.getBookTypeName().equals(rs.getString("bookTypeName"))) {
							this.bookTypeJcb.setSelectedIndex(i);
						}
					}

					break;
				}
			} 
			rs = bookDao.sameNameC(con, bookName);
			while (rs.next()) {
				if (rs.getString("bookName").equals(bookName)) {//图书类型相同只看名字就可以了

					JOptionPane.showMessageDialog(null, "存在相同图书，已自动归入该类别！");
					int n = this.bookTypeJcb.getItemCount();//一共有多少项
					for (int i = 0; i < n; i++) {//下拉框选项依次和bookTypeName比较，相同则设置为该项
						BookType item = (BookType) this.bookTypeJcb.getItemAt(i);
						if (item.getBookTypeName().equals(rs.getString("bookTypeName"))) {
							this.bookTypeJcb.setSelectedIndex(i);
						}
					}

					break;
				}
			} 
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
		BookType bookType=(BookType)bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		
		

		Book book=new Book(bookName,author,country,Float.parseFloat(price),bookTypeId,bookDesc);
		
		
		
		
		
		try {
			int addNum;
			if(this.normalJrb.isSelected()){
				addNum=bookDao.add(con, book);
			}else{
				addNum=bookDao.addC(con, book);
			}
			
			if(addNum==1){
				JOptionPane.showMessageDialog(null, "图书添加成功！");
				
			}else {
				JOptionPane.showMessageDialog(null, "图书添加失败！");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书添加失败！");
		} finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
	}
	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.bookNameTxt.setText("");
		this.authorTxt.setText("");
		this.priceTxt.setText("");
		this.countryTxt.setText("");
		this.bookDescTxt.setText("");
		if(this.bookTypeJcb.getItemCount()>0){
			this.bookTypeJcb.setSelectedIndex(0);
			
		}
		
		
	}

	/**
	 * 初始化图书类别下拉框
	 */
	private void fillBookType(){
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			while(rs.next()){
				bookType=new BookType();
				bookType.setId(rs.getInt("id"));
				bookType.setBookTypeName(rs.getString("bookTypeName"));
				this.bookTypeJcb.addItem(bookType);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
}
