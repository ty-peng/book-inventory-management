package 界面;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dao访问数据库方法.UserDao;
import 工具类util.DbUtil;
import 工具类util.StringUtil;
import 用户对象.BookType;
import 用户对象.User;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class LogOnFrm extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	private DbUtil dbUtil=new DbUtil();
	private UserDao userDao=new UserDao();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton managerJrb;
	private JRadioButton normalJrb;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogOnFrm frame = new LogOnFrm();
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
	public LogOnFrm() {
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
		setResizable(false);
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("图书库存管理系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/books_70.517162471396px_1144059_easyicon.net.png")));
		
		JLabel lblNewLabel_1 = new JLabel("用户名");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/User_16px_1187247_easyicon.net.png")));
		
		JLabel lblNewLabel_2 = new JLabel("密    码");
		lblNewLabel_2.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/password_manager_16px_1118073_easyicon.net.png")));
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				loginActionPerformed(e);
			}
		});
		btnNewButton.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/Door_In_16px_529471_easyicon.net.png")));
		
		JButton btnNewButton_1 = new JButton("重置");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				resetValueActionPerformed(e);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(LogOnFrm.class.getResource("/images/reset_16px_28523_easyicon.net.png")));
		
		passwordTxt = new JPasswordField();
		
		managerJrb = new JRadioButton("管理员");
		buttonGroup.add(managerJrb);
		
		normalJrb = new JRadioButton("普通用户");
		normalJrb.setSelected(true);
		buttonGroup.add(normalJrb);
		
		JButton button = new JButton("普通注册");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registerActionPerformed(e);
				
			}
		});
		button.setIcon(null);
		button.setFont(new Font("宋体", Font.PLAIN, 12));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(16)
									.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
									.addGap(12)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_2)))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(passwordTxt, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
										.addComponent(userNameTxt, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(139)
							.addComponent(managerJrb)
							.addGap(4)
							.addComponent(normalJrb)))
					.addGap(98))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(166)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(185, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(93)
					.addComponent(lblNewLabel)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(13)
							.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(normalJrb)
							.addGap(2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(managerJrb)
							.addGap(3)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(button)
					.addGap(1)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(5)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(6)
							.addComponent(btnNewButton_1)))
					.addGap(15))
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗口居中   null为默认居中
		this.setLocationRelativeTo(null);
	}
	/**
	 * 注册事件处理
	 * @param e
	 */
	protected void registerActionPerformed(ActionEvent e) {
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null,"用户名不能为空！" );
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null,"密码不能为空！" );
			return;
		}
		User user=new User(userName,password);
		Connection con=null;
		
		try {
			con=dbUtil.getCon();
			int n=userDao.register(con, user);
			if(n==1){
				JOptionPane.showMessageDialog(null, "注册成功！");
				
			}else{
				JOptionPane.showMessageDialog(null, "注册失败！");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "注册失败！");

		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * 登录事件处理
	 * @param e
	 */
	private void loginActionPerformed(ActionEvent e) {
		String userName=this.userNameTxt.getText();
		String password=new String(this.passwordTxt.getPassword());
		if(StringUtil.isEmpty(userName)){
			JOptionPane.showMessageDialog(null,"用户名不能为空！" );
			return;
		}
		if(StringUtil.isEmpty(password)){
			JOptionPane.showMessageDialog(null,"密码不能为空！" );
			return;
		}
		User user=new User(userName,password);
		Connection con=null;
		User currentUser;
		try {
			con=dbUtil.getCon();
			if(this.managerJrb.isSelected()){
				currentUser=userDao.login(con, user);
				if(currentUser!=null){
					dispose();
					new MainFrm().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"用户名或者密码错误！" );
				}
				
			}else{
				currentUser=userDao.normallogin(con, user);
				if(currentUser!=null){
					dispose();
					new UserFrm().setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"用户名或者密码错误！" );
				}
			}
			
		} catch (Exception e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	
	/**
	 * 重置事件处理
	 * @param evt
	 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.userNameTxt.setText("");
		this.passwordTxt.setText("");
	}
	

	
}
