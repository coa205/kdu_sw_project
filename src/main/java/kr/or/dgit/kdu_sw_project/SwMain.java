package kr.or.dgit.kdu_sw_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.kdu_sw_project.dto.Category;
import kr.or.dgit.kdu_sw_project.dto.Client;
import kr.or.dgit.kdu_sw_project.dto.Software;
import kr.or.dgit.kdu_sw_project.dto.Supply_company;
import kr.or.dgit.kdu_sw_project.service.CategoryService;
import kr.or.dgit.kdu_sw_project.service.ClientService;
import kr.or.dgit.kdu_sw_project.service.SaleService;
import kr.or.dgit.kdu_sw_project.service.SoftwareService;
import kr.or.dgit.kdu_sw_project.service.Supply_companyService;
import kr.or.dgit.kdu_sw_project.table.SoftwareTable;

@SuppressWarnings("serial")
public class SwMain extends JFrame implements ActionListener {
	private static Supply_companyService supply_companyService;
	private static ClientService clientService;
	private static SoftwareService softwareService;
	private static CategoryService categoryService;
	private static SaleService saleService;
	private JPanel contentPane;
	private JButton btnSwOrder;
	private JButton btnComp;
	private JButton btnCate;
	private JButton btnSw;
	private JButton btnClnt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwMain frame = new SwMain();
					frame.setVisible(true);
					/*InitSettingService init = new InitSettingService();
					init.initSetting();*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SwMain() {
		setTitle("S/W 판매관리프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JLabel lblSw = new JLabel("S/W 판매관리프로그램");
		lblSw.setFont(new Font("굴림", Font.BOLD, 25));
		lblSw.setHorizontalAlignment(SwingConstants.CENTER);
		tabbedPane.addTab("타이틀", null, lblSw, null);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("고객관리", null, panel, null);
		panel.setLayout(new GridLayout(3, 0, 0, 20));
		
		btnComp = new JButton("공급회사등록");
		btnComp.addActionListener(this);
		panel.add(btnComp);
		
		btnSw = new JButton("소프트웨어 등록");
		btnSw.addActionListener(this);
		panel.add(btnSw);
		
		btnClnt = new JButton("거래회사등록");
		btnClnt.addActionListener(this);
		panel.add(btnClnt);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("주문관리", null, panel_1, null);
		panel_1.setLayout(new GridLayout(3, 0, 0, 20));
		
		btnSwOrder = new JButton("소프트웨어 주문");
		btnSwOrder.addActionListener(this);
		
		btnCate = new JButton("분류");
		btnCate.addActionListener(this);
		panel_1.add(btnCate);
		panel_1.add(btnSwOrder);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("현황관리", null, panel_2, null);
		panel_2.setLayout(new GridLayout(3, 0, 0, 20));
		
		JButton btnClntSale = new JButton("고객별 판매현황조회");
		panel_2.add(btnClntSale);
		
		JButton btnSwSale = new JButton("S/W별 판매현황조회");
		panel_2.add(btnSwSale);
		
		JButton btnDateSale = new JButton("날짜별 판매현황조회");
		panel_2.add(btnDateSale);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("보고서", null, panel_3, null);
		panel_3.setLayout(new GridLayout(3, 0, 0, 20));
		
		JButton btnSaleReport = new JButton("판매현황보고서");
		panel_3.add(btnSaleReport);
		
		JButton btnOrderCur = new JButton("주문현황");
		panel_3.add(btnOrderCur);
	}
	
	@SuppressWarnings("rawtypes")
	public void setComboBox(List list, int key){
		String[][] getComboObj = new String[list.size()][];
		String[] comboObj = new String[list.size()];
		
		for(int i=0 ; i<list.size() ; i++){
			if(key==0){
				getComboObj[i] = ((Client) list.get(i)).toArray();
			}else{
				getComboObj[i] = ((Software) list.get(i)).toArray();
			}
			comboObj[i] = getComboObj[i][0];
		}
		SoftwareTable.softwareTable.getComboBox(comboObj, key);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClnt) {
			actionPerformedBtnClnt(e);
		}
		if (e.getSource() == btnSw) {
			actionPerformedBtnSw(e);
		}
		if (e.getSource() == btnCate) {
			actionPerformedBtnCate(e);
		}
		if (e.getSource() == btnComp) {
			actionPerformedBtnComp(e);
		}
		if (e.getSource() == btnSwOrder) {
			actionPerformedBtnSwOrder(e);
		}
	}
	protected void actionPerformedBtnSwOrder(ActionEvent e) {
		clientService = new ClientService();
		softwareService = new SoftwareService();
		saleService = new SaleService();
		SoftwareTable.softwareTable.setVisible(true);
		
		List<Client> ClntList = clientService.selectClntNameAll();
		List<Software> SwList = softwareService.selectSwNameAll();
		int saleNoCnt = saleService.selectSaleNoLength();
		
		SoftwareTable.softwareTable.getTfNo(saleNoCnt);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SoftwareTable.softwareTable.getDate(sdf.format(new Date()));
		setComboBox(ClntList, 0);
		setComboBox(SwList, 1);
	}
	protected void actionPerformedBtnComp(ActionEvent e) {
		supply_companyService = new Supply_companyService();
		
		List<Supply_company> supCompLists = supply_companyService.selectAllCompany();
		
		Supply_company supCompByNo = supply_companyService.selectByNoCompany(new Supply_company("SC001"));
		
		int supCompInsertRow = supply_companyService.insertRowCompany(new Supply_company("SC999",
				"테스트소프트","경기도 부천시 계산동","02-930-4551",true));
		
		int supCompUpdateRow = supply_companyService.updateRowCompany(new Supply_company("SC999",
				"Update Test","Update Test","Update Test",true));
		
		int supCompDeleteRow = supply_companyService.deleteRowCompany(new Supply_company("SC999"));
		
	}
	protected void actionPerformedBtnCate(ActionEvent e) {
		categoryService = new CategoryService();
		
		List<Category> cateLists = categoryService.selectAllCategory();
		
		Category cateList = categoryService.selectByNoCategory(new Category("ED"));
		
		int cateInsertRow = categoryService.insertRowCategory(new Category("TS","Test"));
		
		Map<String, String> param = new HashMap<String, String>();
		param.put("groupCode1", "ZZ");
		param.put("groupName", "Test2");
		param.put("groupCode2", "TS");
		int cateUpdateRow = categoryService.updateRowCategory(param);
		
		int cateDeleteRow = categoryService.deleteRowCategory(new Category("ZZ"));
	}
	protected void actionPerformedBtnSw(ActionEvent e) {
		softwareService = new SoftwareService();
		
		List<Software> swLists = softwareService.selectAllSw();
		
		Software swList = softwareService.selectByNoSw(new Software("SW001"));
		
		int swInsertRow = softwareService.insertRowSw(new Software("SW999",
				"GM","TestSW",10000,1000,true));
		
		int swUpdateRow = softwareService.updateRowSw(new Software("SW999",
				"TS","Test",1000,10,true));
		
		int saleStopSw = softwareService.saleStopSw(new Software("SW999",false));
	}
	protected void actionPerformedBtnClnt(ActionEvent e) {
		clientService = new ClientService();
		
		List<Client> clntLists = clientService.selectAllClnt();
		
		Client clntList = clientService.selectByNoClnt(new Client("CL001"));
		
		int clntInsertRow = clientService.insertRowClnt(new Client("CL999",
				"테스트 게임방","서울시 동대문구 연희동","02-111-1111",true));
		
		int clntUpdateRow = clientService.updateRowClnt(new Client("CL999",
				"Update Test","Update Test","Update Test",true));
		
		int existClnt = clientService.existClnt(new Client("CL999"));
	}
}
