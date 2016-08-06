package com.ticket.yanyj.gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;

import com.ticket.yanyj.emty.Ticket;
import com.ticket.yanyj.util.StringUtil;
import com.ticket.yanyj.util.TicketUtil;

import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TicketGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketGUI window = new TicketGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicketGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setToolTipText("常用");
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("常用");
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 156, 710, 251);
		panel.add(panel_1);
		
		table = new JTable();
		panel_1.add(table);
		
		JLabel lblNewLabel = new JLabel("请输入你的注单：");
		lblNewLabel.setBounds(10, 59, 104, 32);
		panel.add(lblNewLabel);
		//注单Text
		JTextArea zdText = new JTextArea();
		zdText.setBounds(124, 41, 409, 105);
		panel.add(zdText);
		

		
		JButton button = new JButton("\u6570\u636E\u751F\u6210");
		button.setBounds(570, 116, 93, 23);
		panel.add(button);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 0, 93, 23);
		panel.add(btnNewButton_1);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				inintCaipiao(panel);
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			panel.add(inintTable(zdText.getText().trim()));
			}
		});
		
		
	}
	
	//彩票主界面
	private void inintCaipiao(JPanel panel) {
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 156, 710, 251);
		panel.add(panel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("请输入你的注单：");
		lblNewLabel.setBounds(10, 59, 104, 32);
		panel.add(lblNewLabel);
		//注单Text
		JTextArea zdText = new JTextArea();
		zdText.setBounds(124, 41, 409, 105);
		panel.add(zdText);
		
	
	}
	
	private JTable inintTable(String str) {
		
		String[] columnNames = {"序号","注单ID",  
                "彩票种类",  
                "彩票类型",    
                "队伍信息",
                "下注类型",
                "即时比分",
                "下注比例",
                "赔率",
                "结束比分",
                "盈亏"};
		List<Ticket> list = TicketUtil.convertStringToTicketMap(StringUtil.removeSpaceCharater(str));
		Object[][] date = new Object[list.size()][];
			for (int i = 0; i < list.size(); i++) {
				Ticket tc = list.get(i);
				Object[] obj = {i+1, tc.getID(), tc.getClazz(), tc.getType(), tc.getTeam(), tc.getBetType(),
						 tc.getJsbf(), String.valueOf(tc.getGmbl()), String.valueOf(tc.getStake()), tc.getEndScore(), " " };
				date[i] = obj;	
			}
			System.out.println(date[0][1]);
		JTable table = new JTable(date, columnNames);
		return table;
	}

}
