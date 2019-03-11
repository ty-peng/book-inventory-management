package 界面;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao访问数据库方法.BookDao;
import dao访问数据库方法.BookTypeDao;
import 工具类util.DbUtil;
import 用户对象.Book;
import 用户对象.BookType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserBookInterFrm extends JInternalFrame {
	private JTable bookTable;
	private JTextField s_bookNameTxt;
	private JTextField s_authorTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private BookDao bookDao=new BookDao();
	private JComboBox s_bookTypeJcb;
	private JTextField idTxt;
	private JTextField bookNameTxt;
	private JTextField authorTxt;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField priceTxt;
	private JRadioButton chinaJrb;
	private JRadioButton otherJrb;
	private JTextArea bookDescTxt;
	private JComboBox bookTypeJcb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookManageInterFrm frame = new BookManageInterFrm();
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
	public UserBookInterFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("图书查看");
		setBounds(100, 60, 633, 590);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u641C\u7D22\u6761\u4EF6", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 255, 0)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(14, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 588, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(panel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
							.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)))
					.addGap(13))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		JLabel label_3 = new JLabel("编号：");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel label_4 = new JLabel("图书名称：");
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		JLabel label_5 = new JLabel("作        者：");
		
		JLabel label_6 = new JLabel("国家：");
		
		authorTxt = new JTextField();
		authorTxt.setColumns(10);
		
		JLabel label_7 = new JLabel("图书种类：");
		
		chinaJrb = new JRadioButton("中");
		buttonGroup.add(chinaJrb);
		chinaJrb.setSelected(true);
		
		otherJrb = new JRadioButton("外");
		buttonGroup.add(otherJrb);
		
		JLabel label_8 = new JLabel("价        格：");
		
		priceTxt = new JTextField();
		priceTxt.setColumns(10);
		
		bookTypeJcb = new JComboBox();
		
		JLabel label_9 = new JLabel("图书描述：");
		
		bookDescTxt = new JTextArea();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(7)
							.addComponent(label_6)
							.addGap(3)
							.addComponent(chinaJrb)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(otherJrb)
							.addGap(32)
							.addComponent(label_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addComponent(label_8)
							.addGap(15)
							.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(label_3)
							.addGap(2)
							.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(label_4)
							.addGap(3)
							.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(41)
							.addComponent(label_7)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(5)
							.addComponent(label_9))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(4)
							.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 527, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(8)
									.addComponent(label_3))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(8)
									.addComponent(label_7))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(5)
									.addComponent(bookTypeJcb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(8)
									.addComponent(label_4))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(5)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(14)
											.addComponent(label_6))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(10)
											.addComponent(chinaJrb))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(10)
											.addComponent(otherJrb))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGap(15)
											.addComponent(label_5)))
									.addGap(8)
									.addComponent(label_9))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(16)
									.addComponent(label_8))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(15)
									.addComponent(priceTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(2)
					.addComponent(bookDescTxt, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(68, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookSearchActionPerformed(e);
				
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setIcon(new ImageIcon(BookManageInterFrm.class.getResource("/images/search_16px_1200688_easyicon.net.png")));
		
		JLabel label = new JLabel("图书名称：");
		
		s_bookNameTxt = new JTextField();
		s_bookNameTxt.setColumns(10);
		
		JLabel label_1 = new JLabel("图书作者：");
		
		s_authorTxt = new JTextField();
		s_authorTxt.setColumns(10);
		
		JLabel label_2 = new JLabel("图书类别：");
		
		s_bookTypeJcb = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addContainerGap(42, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(s_authorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(s_bookTypeJcb, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				bookTableMousePressed(e);
				
			}
		});
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", " \u56FE\u4E66\u540D\u79F0", "\u56FE\u4E66\u4F5C\u8005", "\u4F5C\u8005\u56FD\u5BB6", "\u56FE\u4E66\u4EF7\u683C", "\u56FE\u4E66\u63CF\u8FF0", "\u56FE\u4E66\u7C7B\u522B"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTable.getColumnModel().getColumn(0).setPreferredWidth(58);
		bookTable.getColumnModel().getColumn(1).setPreferredWidth(105);
		bookTable.getColumnModel().getColumn(2).setPreferredWidth(81);
		bookTable.getColumnModel().getColumn(3).setPreferredWidth(60);
		bookTable.getColumnModel().getColumn(4).setPreferredWidth(63);
		bookTable.getColumnModel().getColumn(5).setPreferredWidth(146);
		scrollPane.setViewportView(bookTable);
		getContentPane().setLayout(groupLayout);
		
		this.fillBookType("search");
		this.fillTable(new Book());
		this.fillBookType("modify");
		//设置文本域边框
		bookDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));


	}
	
	
	

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void bookTableMousePressed(MouseEvent e) {

		int row=this.bookTable.getSelectedRow();
		this.idTxt.setText((String)bookTable.getValueAt(row, 0));
		this.bookNameTxt.setText((String)bookTable.getValueAt(row, 1));
		this.authorTxt.setText((String)bookTable.getValueAt(row, 2));
		String country=(String)bookTable.getValueAt(row, 3);
		if("[中]".equals(country)){
			this.chinaJrb.setSelected(true);
		}else if("[外]".equals(country)){
			this.otherJrb.setSelected(true);
		}
		this.priceTxt.setText((Float)bookTable.getValueAt(row, 4)+"");
		this.bookDescTxt.setText((String)bookTable.getValueAt(row, 5));
		String bookTypeName=(String)this.bookTable.getValueAt(row, 6);
		int n=this.bookTypeJcb.getItemCount();//一共有多少项
		for(int i=0;i<n;i++){//下拉框选项依次和bookTypeName比较，相同则设置为该项
			BookType item=(BookType)this.bookTypeJcb.getItemAt(i);
			if(item.getBookTypeName().equals(bookTypeName)){
				this.bookTypeJcb.setSelectedIndex(i);
			}
		}
	}

	/**
	 * 图书查询事件处理
	 * @param e
	 */
	private void bookSearchActionPerformed(ActionEvent e) {

		String bookName=this.s_bookNameTxt.getText();
		String author=this.s_authorTxt.getText();
		BookType bookType=(BookType)this.s_bookTypeJcb.getSelectedItem();
		int bookTypeId=bookType.getId();
		
		
		Book book=new Book(bookName,author,bookTypeId);
		this.fillTable(book);
	}

	/**
	 * 初始化下拉框
	 * @param type
	 */
	private void fillBookType(String type){
		Connection con=null;
		BookType bookType=null;
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, new BookType());
			
				if("search".equals(type)){
					bookType=new BookType();
					bookType.setBookTypeName("请选择……");
					bookType.setId(-1);
					this.s_bookTypeJcb.addItem(bookType);
				}
				while(rs.next()){
					bookType=new BookType();
					bookType.setId(rs.getInt("id"));
					bookType.setBookTypeName(rs.getString("bookTypeName"));
					if("search".equals(type)){
						this.s_bookTypeJcb.addItem(bookType);
					}else if("modify".equals(type)){
						this.bookTypeJcb.addItem(bookType);
					}
					
				
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

	/**
	 * 初始化表格数据
	 * @param book
	 */
	private void fillTable(Book book){
		DefaultTableModel dtm=(DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);//设置成0行，每次查询前清空
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookDao.list(con, book);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookName"));
				v.add(rs.getString("author"));
				v.add(rs.getString("country"));
				v.add(rs.getFloat("price"));
				v.add(rs.getString("bookDesc"));
				v.add(rs.getString("bookTypeName"));
				dtm.addRow(v);
				
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
