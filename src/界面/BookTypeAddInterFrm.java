package 界面;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import dao访问数据库方法.BookTypeDao;
import 工具类util.DbUtil;
import 工具类util.StringUtil;
import 用户对象.BookType;

public class BookTypeAddInterFrm extends JInternalFrame {
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeAddInterFrm frame = new BookTypeAddInterFrm();
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
	public BookTypeAddInterFrm() {
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
		getContentPane().setBackground(UIManager.getColor("FormattedTextField.disabledBackground"));
		setClosable(true);
		setIconifiable(true);
		setTitle("图书类别添加");
		setBounds(100, 100, 450, 300);
		
		JLabel label = new JLabel("图书类别名称");
		
		JLabel label_1 = new JLabel("图书类别描述");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		
		JButton button = new JButton("添加");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bookTypeAddActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/add_16px_1175496_easyicon.net.png")));
		
		JButton button_1 = new JButton("重置");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValueActionPerformed(e);
				
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		button_1.setIcon(new ImageIcon(BookTypeAddInterFrm.class.getResource("/images/reset_16px_28523_easyicon.net.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(58)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(label_1))
							.addGap(45)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(bookTypeNameTxt)
								.addComponent(bookTypeDescTxt, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(93)
							.addComponent(button_1)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));

	}
	
	/**
	 * 图书类别添加事件处理
	 * @param e
	 */
	private void bookTypeAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String bookTypeName=this.bookTypeNameTxt.getText();
		String bookTypeDesc=this.bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(bookTypeName)){
			JOptionPane.showMessageDialog(null, "图书类别名称不能为空！");
			return;
		}
		BookType bookType=new BookType(bookTypeName,bookTypeDesc);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, bookType);
			while(rs.next()){
				if(rs.getString("bookTypeName").equals(bookTypeName)||rs.getString("bookTypeName").equals(bookTypeName+"类")){
					JOptionPane.showMessageDialog(null, "该类别已存在，请重新输入！");
					return;
				}
			}
			int n=bookTypeDao.add(con, bookType);
			if(n==1){
				JOptionPane.showMessageDialog(null, "图书类别添加成功！");
				resetValue();//添加之后重置一下
			}else{
				JOptionPane.showMessageDialog(null, "图书类别添加失败！");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "图书类别添加失败！");

		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.resetValue();
		
	}

	/**
	 * 重置表单
	 */
	private void resetValue(){
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}

}
