package 界面;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class MainFrm extends JFrame {

	private JPanel contentPane;
	private JDesktopPane table=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrm frame = new MainFrm();
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
	public MainFrm() {
		
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
		
		setTitle("图书库存管理系统主界面");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("基本数据菜单");
		mnNewMenu.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 13));
		mnNewMenu.setIcon(new ImageIcon(MainFrm.class.getResource("/images/config_stock_16px_43339_easyicon.net.png")));
		menuBar.add(mnNewMenu);
		
		JMenu menu = new JMenu("图书类别管理");
		mnNewMenu.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("图书类别添加");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeAddInterFrm bookTypeAddInterFrm=new BookTypeAddInterFrm();
				bookTypeAddInterFrm.setVisible(true);//可见
				table.add(bookTypeAddInterFrm);
			}
		});
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("图书类别维护");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookTypeManageInterFrm bookTypeManageInterFrm=new BookTypeManageInterFrm();
				bookTypeManageInterFrm.setVisible(true);//可见
				table.add(bookTypeManageInterFrm);
			}
		});
		menu.add(menuItem_2);
		
		JMenu menu_1 = new JMenu("图书管理");
		mnNewMenu.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("图书添加");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAddInterFrm bookAddInterFrm=new BookAddInterFrm();
				bookAddInterFrm.setVisible(true);//可见
				table.add(bookAddInterFrm);
				
			}
		});
		menu_1.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("图书维护");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManageInterFrm bookManageInterFrm=new BookManageInterFrm();
				bookManageInterFrm.setVisible(true);//可见
				table.add(bookManageInterFrm);
				
			}
		});
		menu_1.add(menuItem_4);
		
		JMenuItem menuItem_6 = new JMenuItem("报废图书管理");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CondemnedInterFrm condemnedInterFrm=new CondemnedInterFrm();
				condemnedInterFrm.setVisible(true);//可见
				table.add(condemnedInterFrm);
				
			}
		});
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem = new JMenuItem("安全退出");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(null,"是否退出系统？");//是返回0，否1，取消2
				if(result==0){
					dispose();
				}
			}
		});
		mnNewMenu.add(menuItem);
		
		JMenu menu_2 = new JMenu("关于");
		menu_2.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about_2_16px_539850_easyicon.net.png")));
		menuBar.add(menu_2);
		
		JMenuItem menuItem_5 = new JMenuItem("哈哈哈哈哈哈哈哈哈");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutFrm aboutFrm=new AboutFrm();
				aboutFrm.setVisible(true);//可见
				table.add(aboutFrm);
				
			}
		});
		menuItem_5.setIcon(new ImageIcon(MainFrm.class.getResource("/images/about_2_16px_539850_easyicon.net.png")));
		menu_2.add(menuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		table = new JDesktopPane();//放到上面定义（已改）以便哈哈哈哈哈哈哈里面的table生效
		table.setBackground(Color.WHITE);
		contentPane.add(table, BorderLayout.CENTER);
		//设置窗口最大化
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		//设置窗口居中   null为默认居中
				this.setLocationRelativeTo(null);
	}
}
