package 界面;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;

public class UserFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserFrm frame = new UserFrm();
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
	public UserFrm() {
		setTitle("用户界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 727);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("图书查看");
		menu.setIcon(new ImageIcon(UserFrm.class.getResource("/images/search_16px_1200688_easyicon.net.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("图书查看");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBookInterFrm userBookInterFrm=new UserBookInterFrm();
				userBookInterFrm.setVisible(true);//可见
				table.add(userBookInterFrm);
			}
		});
		menuItem.setIcon(new ImageIcon(UserFrm.class.getResource("/images/book_books_16px_511653_easyicon.net.png")));
		menu.add(menuItem);
		
		JMenuItem menuItem_2 = new JMenuItem("退出");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"是否退出系统？");//是返回0，否1，取消2
				if(result==0){
					dispose();
				}
			}
		});
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("关于");
		menu_1.setIcon(new ImageIcon(UserFrm.class.getResource("/images/about_2_16px_539850_easyicon.net.png")));
		menuBar.add(menu_1);
		
		JMenuItem menuItem_1 = new JMenuItem("关于");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutFrm aboutFrm=new AboutFrm();
				aboutFrm.setVisible(true);//可见
				table.add(aboutFrm);
			}
		});
		menuItem_1.setIcon(new ImageIcon(UserFrm.class.getResource("/images/about_2_16px_539850_easyicon.net.png")));
		menu_1.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JDesktopPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 664, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		//设置窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//设置窗口居中   null为默认居中
		this.setLocationRelativeTo(null);
	
	}
}
