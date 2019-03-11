package 界面;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import dao访问数据库方法.BookDao;
import dao访问数据库方法.BookTypeDao;
import 工具类util.DbUtil;
import 工具类util.StringUtil;
import 用户对象.BookType;

public class BookTypeManageInterFrm extends JInternalFrame {
	private JTable bookTypeTable;
	private DbUtil dbUtil=new DbUtil();
	private BookTypeDao bookTypeDao=new BookTypeDao();
	private JTextField s_bookTypeNameTxt;
	private JTextField idTxt;
	private JTextField bookTypeNameTxt;
	private JTextArea bookTypeDescTxt;
	private BookDao bookDao=new BookDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookTypeManageInterFrm frame = new BookTypeManageInterFrm();
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
	public BookTypeManageInterFrm() {
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
		setIconifiable(true);
		setClosable(true);
		setTitle("图书类别管理");
		setBounds(100, 100, 450, 435);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("图书类别名称：");
		label.setFont(new Font("宋体", Font.PLAIN, 15));
		
		s_bookTypeNameTxt = new JTextField();
		s_bookTypeNameTxt.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bookTypeSearchActionPerformed(e);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/search_16px_1200688_easyicon.net.png")));
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)))
					.addGap(21))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(s_bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel label_1 = new JLabel("编号:");
		
		idTxt = new JTextField();
		idTxt.setEditable(false);
		idTxt.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("图示类别名称：");
		
		bookTypeNameTxt = new JTextField();
		bookTypeNameTxt.setColumns(10);
		
		bookTypeDescTxt = new JTextArea();
		
		JLabel label_2 = new JLabel("描述：");
		
		JButton button_1 = new JButton("修改");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookTypeUpdateActionEvent(e);
			}
		});
		button_1.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/Modify_16px_1060983_easyicon.net.png")));
		button_1.setFont(new Font("宋体", Font.PLAIN, 15));
		
		JButton button_2 = new JButton("删除");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bookTypeDeleteActionEvent(e);
			}
		});
		button_2.setIcon(new ImageIcon(BookTypeManageInterFrm.class.getResource("/images/Delete_16px_1181442_easyicon.net.png")));
		button_2.setFont(new Font("宋体", Font.PLAIN, 15));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(73)
					.addComponent(button_1)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(button_2)
					.addGap(77))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(bookTypeDescTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
							.addGap(14)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(idTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel)
						.addComponent(bookTypeNameTxt, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(bookTypeDescTxt, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		bookTypeTable = new JTable();
		bookTypeTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTypeTableMousePressed(e);
				
			}
		});
		bookTypeTable.setFont(new Font("宋体", Font.PLAIN, 15));
		bookTypeTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u7C7B\u522B\u540D\u79F0", "\u56FE\u4E66\u7C7B\u522B\u63CF\u8FF0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		bookTypeTable.getColumnModel().getColumn(1).setPreferredWidth(127);
		bookTypeTable.getColumnModel().getColumn(2).setPreferredWidth(194);
		scrollPane.setViewportView(bookTypeTable);
		getContentPane().setLayout(groupLayout);

		this.fillTable(new BookType());
		
		//设置文本域边框
		bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
		
	}
	/**
	 * 图书类别删除事件处理
	 * @param e
	 */
	private void bookTypeDeleteActionEvent(ActionEvent e) {
		String id=idTxt.getText();
		if(StringUtil.isEmpty(id)){//没有用鼠标选择的时候
			JOptionPane.showMessageDialog(null,"请选择要删除的记录！" );
			return;
		}
		int n=JOptionPane.showConfirmDialog(null, "确认删除该记录吗？");
		if(n==0){
			Connection con=null;
			try {
				con=dbUtil.getCon();
				boolean flag=bookDao.existBookByBookTyped(con, id);
				if(flag){
					JOptionPane.showMessageDialog(null, "该图书类别下存在相应图书，不能删除此类别！");
					return;
				}
				int deleteNum=bookTypeDao.delete(con, id);
				if(deleteNum==1){
					JOptionPane.showMessageDialog(null,"删除成功！" );
					this.resetValue();
					this.fillTable(new BookType());
				}else{
					JOptionPane.showMessageDialog(null,"删除失败！" ); 
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null,"删除失败！" ); 
				
			}finally{
				try {
					dbUtil.closeCon(con);
				} catch (Exception e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		}
	}
	/**
	 * 图书类别修改事件处理
	 * @param e
	 */
	private void bookTypeUpdateActionEvent(ActionEvent e) {

		String id=idTxt.getText();
		String bookTypeName=bookTypeNameTxt.getText();
		String bookTypeDesc=bookTypeDescTxt.getText();
		if(StringUtil.isEmpty(id)){//没有用鼠标选择的时候
			JOptionPane.showMessageDialog(null,"请选择要修改的记录！" );
			return;
		}
		if(StringUtil.isEmpty(bookTypeName)){//图书类别为空的时候
			JOptionPane.showMessageDialog(null,"图书名称不能为空！" );
			return;
		}
		//Integer.parseInt(id)  将id从String转换为整型
		BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
		Connection con=null;
		try {
			con=dbUtil.getCon();
			int modifyNum=bookTypeDao.update(con, bookType);
			if(modifyNum==1){
				JOptionPane.showMessageDialog(null, "修改成功！");
				this.resetValue();//重置表单
				this.fillTable(new BookType());//刷新上面表格
			}else{
				JOptionPane.showMessageDialog(null, "修改失败！");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null,"修改失败！" ); 
		} finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 表格行点击事件处理
	 * @param e
	 */
	private void bookTypeTableMousePressed(MouseEvent e) {

		int row=bookTypeTable.getSelectedRow();
		idTxt.setText((String)bookTypeTable.getValueAt(row, 0));
		bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row, 1));
		//每次都要把文本域的定义移到上面去才可以使用如bookTypeDescTxt
		bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row, 2));
		
	}

	/**
	 * 图书类别搜索事件处理
	 * @param evt
	 */
	private void bookTypeSearchActionPerformed(ActionEvent evt) {
		
		String s_bookTypeName=this.s_bookTypeNameTxt.getText();
		BookType bookType=new BookType();
		bookType.setBookTypeName(s_bookTypeName);
		this.fillTable(bookType);
	}

	/**
	 * 初始化表
	 * @param bookType
	 */
	private void fillTable(BookType bookType){
		DefaultTableModel dtm=(DefaultTableModel) bookTypeTable.getModel();
		dtm.setRowCount(0);//设置成0行，每次查询前清空
		Connection con=null;
		try{
			con=dbUtil.getCon();
			ResultSet rs=bookTypeDao.list(con, bookType);
			while(rs.next()){
				Vector v=new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("bookTypeName"));
				v.add(rs.getString("bookTypeDesc"));
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
	/**
	 * 重置表单数据
	 */
	private void resetValue(){
		this.idTxt.setText("");
		this.bookTypeNameTxt.setText("");
		this.bookTypeDescTxt.setText("");
	}
}
