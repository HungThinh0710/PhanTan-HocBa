package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import core.DashboardControl;
import core.InputPointControl;
import model.Report;
import model.Student;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputPoint extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblReport1;
	private JTextField txtFullName;
	private JTextField txtClass;
	private JTextField txtSchool;
	private JTextField txtAcademicYear;
	private JTextField txtGender;
	private JButton btnSave;
	private JTabbedPane tabbedPane;
	private JTable tblReport2;
	private JPanel panelSchoolYear2;
	private JPanel panelSchoolYear1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextField txtSubject;
	private JTextField txtSemester;
	private JTextField txtYearReport;
	private JTextField txtDailyExam;
	private JTextField txtfifteenMinutes;
	private JTextField txtOnePeriodExam;
	private JTextField txtFinalExam;
	private JTextField txtMiddleExam;
	private InputPointControl inputPointControl;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					InputPoint frame = new InputPoint(2333);
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

	
	public InputPoint(int studentId) {
		initialize(studentId);

	}
	
	private void initialize(int studentId) {
		setTitle("Qu\u1EA3n l\u00FD \u0111i\u1EC3m");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 783, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "B\u1EA3ng \u0111i\u1EC3m c\u00E1c m\u00F4n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 57, 747, 164);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 24, 727, 129);
		panel.add(tabbedPane);
		
		panelSchoolYear1 = new JPanel();
		tabbedPane.addTab("New tab", null, panelSchoolYear1, null);
		panelSchoolYear1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 722, 101);
		panelSchoolYear1.add(scrollPane);
		
		tblReport1 = new JTable() {
			public boolean isCellEditable(int row, int column){
		        return false;
		   }
		};
		tblReport1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = tblReport1.getSelectedRow();
				TableModel tableModel = tblReport1.getModel();
				txtSemester.setText(tableModel.getValueAt(i, 0).toString());
				txtSubject.setText(tableModel.getValueAt(i, 1).toString());
				txtDailyExam.setText(tableModel.getValueAt(i, 2).toString());
				txtfifteenMinutes.setText(tableModel.getValueAt(i, 3).toString());
				txtOnePeriodExam.setText(tableModel.getValueAt(i, 4).toString());
				txtMiddleExam.setText(tableModel.getValueAt(i, 6).toString());
				txtFinalExam.setText(tableModel.getValueAt(i, 7).toString());
				
				//Checked
//				if(txtID.getText().length() <= 0) {
//					btnReport.setEnabled(false);
//					btnChange.setEnabled(false);
//				}
//				else {
//					btnReport.setEnabled(true);
//					btnChange.setEnabled(true);
//				}
			}
		});
		scrollPane.setViewportView(tblReport1);
		
		panelSchoolYear2 = new JPanel();
		tabbedPane.addTab("New tab", null, panelSchoolYear2, null);
		panelSchoolYear2.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 722, 101);
		panelSchoolYear2.add(scrollPane_1);
		
		tblReport2 = new JTable();
		scrollPane_1.setViewportView(tblReport2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Qu\u1EA3n l\u00FD \u0111i\u1EC3m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 232, 747, 196);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u1ECDc sinh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 22, 236, 163);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblFullName = new JLabel("H\u1ECD V\u00E0 T\u00EAn");
		lblFullName.setBounds(10, 24, 62, 14);
		panel_2.add(lblFullName);
		
		txtFullName = new JTextField();
		txtFullName.setEditable(false);
		txtFullName.setBounds(82, 21, 136, 20);
		panel_2.add(txtFullName);
		txtFullName.setColumns(10);
		
		JLabel lblClass = new JLabel("L\u1EDBp");
		lblClass.setBounds(10, 52, 62, 14);
		panel_2.add(lblClass);
		
		txtClass = new JTextField();
		txtClass.setEditable(false);
		txtClass.setColumns(10);
		txtClass.setBounds(82, 49, 136, 20);
		panel_2.add(txtClass);
		
		JLabel lblTrng = new JLabel("Tr\u01B0\u1EDDng");
		lblTrng.setBounds(10, 80, 62, 14);
		panel_2.add(lblTrng);
		
		txtSchool = new JTextField();
		txtSchool.setEditable(false);
		txtSchool.setColumns(10);
		txtSchool.setBounds(82, 77, 136, 20);
		panel_2.add(txtSchool);
		
		JLabel lblNmNhpHc = new JLabel("N\u0103m nh\u1EADp h\u1ECDc");
		lblNmNhpHc.setBounds(10, 108, 74, 14);
		panel_2.add(lblNmNhpHc);
		
		txtAcademicYear = new JTextField();
		txtAcademicYear.setEditable(false);
		txtAcademicYear.setColumns(10);
		txtAcademicYear.setBounds(82, 105, 136, 20);
		panel_2.add(txtAcademicYear);
		
		JLabel lblGender = new JLabel("N\u0103m nh\u1EADp h\u1ECDc");
		lblGender.setBounds(10, 135, 74, 14);
		panel_2.add(lblGender);
		
		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setColumns(10);
		txtGender.setBounds(82, 132, 136, 20);
		panel_2.add(txtGender);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "C\u1ED9t \u0111i\u1EC3m", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(248, 22, 489, 163);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "H\u00E0nh \u0111\u1ED9ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 103, 469, 49);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		btnSave = new JButton("L\u01B0u");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Save scores
			}
		});
		btnSave.setBounds(10, 15, 89, 23);
		panel_4.add(btnSave);
		
		JButton btnNewButton = new JButton("Xem tổng kết");
		btnNewButton.setBounds(103, 15, 114, 23);
		panel_4.add(btnNewButton);
		
		txtSubject = new JTextField();
		txtSubject.setEditable(false);
		txtSubject.setBounds(63, 22, 96, 20);
		panel_3.add(txtSubject);
		txtSubject.setColumns(10);
		
		JLabel lblMon = new JLabel("Môn");
		lblMon.setBounds(10, 25, 48, 14);
		panel_3.add(lblMon);
		
		txtSemester = new JTextField();
		txtSemester.setEditable(false);
		txtSemester.setColumns(10);
		txtSemester.setBounds(224, 22, 96, 20);
		panel_3.add(txtSemester);
		
		JLabel lblHcK = new JLabel("Học kỳ");
		lblHcK.setBounds(171, 25, 48, 14);
		panel_3.add(lblHcK);
		
		txtYearReport = new JTextField();
		txtYearReport.setEditable(false);
		txtYearReport.setColumns(10);
		txtYearReport.setBounds(383, 22, 96, 20);
		panel_3.add(txtYearReport);
		
		JLabel lblNawm = new JLabel("Năm");
		lblNawm.setBounds(330, 25, 48, 14);
		panel_3.add(lblNawm);
		
		JLabel lblimMing = new JLabel("Miệng");
		lblimMing.setBounds(10, 53, 48, 14);
		panel_3.add(lblimMing);
		
		txtDailyExam = new JTextField();
		txtDailyExam.setColumns(10);
		txtDailyExam.setBounds(63, 50, 96, 20);
		panel_3.add(txtDailyExam);
		
		JLabel lblMtTit = new JLabel("15 Phút");
		lblMtTit.setBounds(171, 53, 48, 14);
		panel_3.add(lblMtTit);
		
		txtfifteenMinutes = new JTextField();
		txtfifteenMinutes.setColumns(10);
		txtfifteenMinutes.setBounds(224, 50, 96, 20);
		panel_3.add(txtfifteenMinutes);
		
		JLabel lblTit = new JLabel("1 Tiết");
		lblTit.setBounds(330, 53, 48, 14);
		panel_3.add(lblTit);
		
		txtOnePeriodExam = new JTextField();
		txtOnePeriodExam.setColumns(10);
		txtOnePeriodExam.setBounds(383, 50, 96, 20);
		panel_3.add(txtOnePeriodExam);
		
		txtFinalExam = new JTextField();
		txtFinalExam.setColumns(10);
		txtFinalExam.setBounds(224, 78, 96, 20);
		panel_3.add(txtFinalExam);
		
		JLabel lblHcK_1_1 = new JLabel("Cuối kỳ");
		lblHcK_1_1.setBounds(171, 81, 48, 14);
		panel_3.add(lblHcK_1_1);
		
		JLabel lblMon_1_1 = new JLabel("Giữa kỳ");
		lblMon_1_1.setBounds(10, 81, 48, 14);
		panel_3.add(lblMon_1_1);
		
		txtMiddleExam = new JTextField();
		txtMiddleExam.setColumns(10);
		txtMiddleExam.setBounds(63, 78, 96, 20);
		panel_3.add(txtMiddleExam);
		
		JLabel lblNewLabel = new JLabel("B\u1EA2NG QU\u1EA2N L\u00DD \u0110I\u1EC2M C\u00C1 NH\u00C2N");
		lblNewLabel.setBounds(10, 11, 751, 40);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		

		inputPointControl = new InputPointControl(studentId); 
		initialTabbed();
		initialTable(studentId);
		initialStudentInfo();
	}
	
	private void initialTabbed() {
		tabbedPane.addTab("2018", null, panelSchoolYear1, "Click to show year 2018");
		tabbedPane.addTab("2019", null, panelSchoolYear2, getTitle());
//		tabbedPane.addTab("2020", null, btnSave, getTitle());
//		tabbedPane.addTab("2021", null, btnSave, getTitle());
	}
	
	private void initialTable(int studentId) {

		String[] header = inputPointControl.getHeaderTable();
		ArrayList <Report> reportList = inputPointControl.getReportStudent(studentId);
		DefaultTableModel model = new DefaultTableModel(header, 0);
		Object[] row = new Object[header.length];

		for (int i = 0; i < reportList.size(); i++) {
			row[0] = reportList.get(i).getSemeter();
			row[1] = inputPointControl.convertSubjectIdToName(reportList.get(i).getSubjectId());
			row[2] = reportList.get(i).getDailyExam();
			row[3] = reportList.get(i).getFifteenExam();
			row[4] = reportList.get(i).getOnePeriodExam();
			row[5] = reportList.get(i).getMiddleSemester();
			row[6] = reportList.get(i).getFifteenExam();
			row[7] = reportList.get(i).getFifteenExam();
			model.addRow(row);
		}
		tblReport1.setModel(model);
	}
	
	private void initialStudentInfo() {
		Student student = inputPointControl.liteStudentInfo();
		txtFullName.setText(student.getlastName() + ""+ student.getFirstName());
	}
}
