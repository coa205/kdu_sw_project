package kr.or.dgit.kdu_sw_project.table;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class SoftwareTable extends JFrame implements ActionListener {
	public static SoftwareTable softwareTable = new SoftwareTable();
	private String[] comboList;
	private JPanel contentPane;
	private JTextField tfNo;
	private JTextField tfDate;
	private JTextField tfAnt;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JComboBox cbSw;
	private JComboBox cbClnt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SoftwareTable frame = new SoftwareTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SoftwareTable() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 584, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("소프트웨어 주문");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(14);
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEADING);
		panel.add(panel_2);
		
		JLabel lblNo = new JLabel("주문번호 :    ");
		panel_2.add(lblNo);
		
		tfNo = new JTextField();
		panel_2.add(tfNo);
		tfNo.setColumns(10);
		tfNo.setFocusable(false);
		tfNo.setEditable(false);
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		flowLayout_1.setVgap(14);
		flowLayout_1.setHgap(10);
		panel.add(panel_3);
		
		JLabel lblDate = new JLabel("주문일자 :    ");
		panel_3.add(lblDate);
		
		tfDate = new JTextField();
		panel_3.add(tfDate);
		tfDate.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		flowLayout_2.setVgap(14);
		flowLayout_2.setHgap(10);
		panel.add(panel_4);
		
		JLabel lblClnt = new JLabel("고객상호명 :");
		panel_4.add(lblClnt);
		
		cbClnt = new JComboBox();
		panel_4.add(cbClnt);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_5.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		flowLayout_3.setVgap(14);
		flowLayout_3.setHgap(10);
		panel.add(panel_5);
		
		JLabel lblSw = new JLabel("품 목 명 :      ");
		panel_5.add(lblSw);
		
		cbSw = new JComboBox();
		panel_5.add(cbSw);
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_6.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		flowLayout_4.setVgap(14);
		flowLayout_4.setHgap(10);
		panel.add(panel_6);
		
		JLabel lblAnt = new JLabel("주문수량:    ");
		panel_6.add(lblAnt);
		
		tfAnt = new JTextField();
		panel_6.add(tfAnt);
		tfAnt.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_7.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		flowLayout_5.setVgap(14);
		flowLayout_5.setHgap(10);
		panel.add(panel_7);
		
		JLabel lblIsDe = new JLabel("입금여부 :  ");
		panel_7.add(lblIsDe);
		
		JCheckBox cheIsDe = new JCheckBox("");
		panel_7.add(cheIsDe);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnNewButton = new JButton("등록");
		btnNewButton.addActionListener(this);
		panel_1.add(btnNewButton);
		
		btnNewButton_1 = new JButton("취소");
		btnNewButton_1.addActionListener(this);
		panel_1.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("닫기");
		btnNewButton_2.addActionListener(this);
		panel_1.add(btnNewButton_2);
	}
	
	public void getComboBox(String[] comboList, int key){
		if(key==0){
			cbClnt.setModel(new DefaultComboBoxModel(comboList));
		}else{
			cbSw.setModel(new DefaultComboBoxModel(comboList));
		}
	}
	
	public void getTfNo(int saleNoCnt){
		String value = String.format("SL%03d", saleNoCnt+1);
		tfNo.setText(String.valueOf(value));
	}
	
	public void getDate(String date){
		tfDate.setText(date);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton_2) {
			actionPerformedBtnNewButton_2(e);
		}
		if (e.getSource() == btnNewButton_1) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		
	}
	protected void actionPerformedBtnNewButton_2(ActionEvent e) {
		
	}
}
