package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import core.DashboardControl;
import core.RelationHelpers;
import core.TeacherControl;
import model.Student;
import model.Teacher;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class TeacherManagement extends JFrame {

	private JFrame frmBngiuKhin;
	private JTable table;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtDOB;
	private JTextField txtPhoneNumber;
	private JTextField txtHomeTown;
	private TeacherControl teacherControler = new TeacherControl(); 
	private JTextField txtSchool;
	private JTextField txtID;
	private JButton btnChange;
	private RelationHelpers helpers = new RelationHelpers();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					TeacherManagement window = new TeacherManagement();
					window.frmBngiuKhin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeacherManagement() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBngiuKhin = new JFrame();
		frmBngiuKhin.setTitle("B\u1EA3ng \u0111i\u1EC1u khi\u1EC3n h\u1ECDc b\u1EA1");
		frmBngiuKhin.setBounds(100, 100, 910, 627);
		frmBngiuKhin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable() {
			public boolean isCellEditable(int row, int column){
		        return false;
		   }
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel tableModel = table.getModel();
				txtID.setText(tableModel.getValueAt(i, 0).toString());
				txtHo.setText(tableModel.getValueAt(i, 1).toString());
				txtTen.setText(tableModel.getValueAt(i, 2).toString());
				txtDOB.setText(tableModel.getValueAt(i, 3).toString());
				txtPhoneNumber.setText(tableModel.getValueAt(i, 4).toString());
				txtHomeTown.setText(tableModel.getValueAt(i, 6).toString());
				txtSchool.setText(tableModel.getValueAt(i, 7).toString());
				
				//Checked
				if(txtID.getText().length() <= 0) {
					System.out.println("False");
					btnChange.setEnabled(false);
				}
				else {
					btnChange.setEnabled(true);
				}
			}
		});
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollPane.setViewportView(table);
		
		JLabel lblTitle = new JLabel("QUẢN LÝ GIÁO VIÊN");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelAction = new JPanel();
		panelAction.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelSelection = new JPanel();
		panelSelection.setBorder(new TitledBorder(null, "H\u1ECDc sinh \u0111ang ch\u1ECDn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frmBngiuKhin.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panelAction, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelSelection, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(205)
							.addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
							.addGap(266))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(panelAction, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelSelection, GroupLayout.PREFERRED_SIZE, 281, Short.MAX_VALUE))
					.addGap(21))
		);
		
		JPanel panel_right = new JPanel();
		
		JPanel panel_left = new JPanel();
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "H\u00E0nh \u0111\u1ED9ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_panelSelection = new GroupLayout(panelSelection);
		gl_panelSelection.setHorizontalGroup(
			gl_panelSelection.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelSelection.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelSelection.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelSelection.createSequentialGroup()
							.addComponent(panel_left, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel_right, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelSelection.setVerticalGroup(
			gl_panelSelection.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSelection.createSequentialGroup()
					.addGroup(gl_panelSelection.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_right, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_left, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(59))
		);
		
		btnChange = new JButton("Thay \u0111\u1ED5i");
		btnChange.setIcon(new ImageIcon(this.getClass().getResource("/update_student.png")));
		JButton btnReset = new JButton("Huỷ bỏ");
		btnReset.setIcon(new ImageIcon(this.getClass().getResource("/cancel.png")));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetSelectedInput();
			}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(299, Short.MAX_VALUE)
					.addComponent(btnReset)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnChange)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChange)
						.addComponent(btnReset))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Button Change Student information
				 */
				Student student = new Student();
				student.setId(Integer.parseInt(txtID.getText()));
				student.setFirstName(txtHo.getText());
				student.setlastName(txtTen.getText());
				student.setHomeTown(txtHomeTown.getText());
				student.setPhoneNumber(txtPhoneNumber.getText());
				student.setAddress(txtDOB.getText());
				boolean resultUpdate = teacherControler.changeStudentInformation(student);
				if(resultUpdate) {
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin học sinh thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);
					 fillData();
						
				}
				else 
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin học sinh thất bại", "Thất bại", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		txtHo = new JTextField();
		txtHo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1 = new JLabel("T\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtTen.setColumns(10);
		
		txtSchool = new JTextField();
		txtSchool.setEditable(false);
		txtSchool.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtSchool.setColumns(10);
		
		JLabel lblTrng = new JLabel("Tr\u01B0\u1EDDng");
		lblTrng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblNewLabel_1_1 = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JRadioButton radioMale = new JRadioButton("Nam");
		
		JRadioButton radioFemale = new JRadioButton("N\u1EEF");
		GroupLayout gl_panel_left = new GroupLayout(panel_left);
		gl_panel_left.setHorizontalGroup(
			gl_panel_left.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_left.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_left.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_left.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtHo, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
						.addGroup(gl_panel_left.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
							.addGap(21)
							.addComponent(txtTen, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_left.createSequentialGroup()
							.addComponent(lblTrng, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(5)
							.addComponent(txtSchool, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
						.addGroup(gl_panel_left.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(radioMale)
							.addGap(2)
							.addComponent(radioFemale, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)))
					.addGap(39))
		);
		gl_panel_left.setVerticalGroup(
			gl_panel_left.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_left.createSequentialGroup()
					.addGroup(gl_panel_left.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_left.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(txtHo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_left.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_left.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(txtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_left.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_left.createSequentialGroup()
							.addGap(3)
							.addComponent(lblTrng))
						.addComponent(txtSchool, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_panel_left.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(radioMale)
						.addComponent(radioFemale))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		panel_left.setLayout(gl_panel_left);
		
		txtDOB = new JTextField();
		txtDOB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtDOB.setColumns(10);
		
		JLabel lblDOB = new JLabel("Ngày sinh");
		lblDOB.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblSinThoi = new JLabel("S\u0110T");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPhoneNumber.setColumns(10);
		
		JLabel lblQuQun = new JLabel("Qu\u00EA qu\u00E1n");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtHomeTown = new JTextField();
		txtHomeTown.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHomeTown.setColumns(10);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtID.setColumns(10);
		
		JLabel lblaCh_1 = new JLabel("Mã HS");
		lblaCh_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_panel_right = new GroupLayout(panel_right);
		gl_panel_right.setHorizontalGroup(
			gl_panel_right.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_right.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_right.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_right.createSequentialGroup()
							.addComponent(lblaCh_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addGroup(gl_panel_right.createSequentialGroup()
							.addComponent(lblDOB)
							.addGap(11)
							.addComponent(txtDOB, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addGroup(gl_panel_right.createSequentialGroup()
							.addComponent(lblSinThoi, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(txtPhoneNumber, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
						.addGroup(gl_panel_right.createSequentialGroup()
							.addComponent(lblQuQun, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtHomeTown, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
					.addGap(38))
		);
		gl_panel_right.setVerticalGroup(
			gl_panel_right.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_right.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_right.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_right.createSequentialGroup()
							.addGap(4)
							.addComponent(lblaCh_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_right.createSequentialGroup()
							.addGap(1)
							.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_right.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDOB, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_right.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDOB)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_right.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_right.createSequentialGroup()
							.addGap(3)
							.addComponent(lblSinThoi))
						.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_right.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtHomeTown, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuQun))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_right.setLayout(gl_panel_right);
		panelSelection.setLayout(gl_panelSelection);
		panelAction.setLayout(null);
		
		JButton btnAddTeacher = new JButton("Thêm GV");
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddTeacher.setIcon(new ImageIcon(this.getClass().getResource("/add_student_16x16.png")));
		btnAddTeacher.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAddTeacher.setBounds(10, 24, 151, 23);
		panelAction.add(btnAddTeacher);
		
		JButton btnManageReports = new JButton("Qu\u1EA3n l\u00FD h\u1ECDc b\u1EA1");
		btnManageReports.setIcon(new ImageIcon(this.getClass().getResource("/management_report.png")));
		btnManageReports.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnManageReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageReports.setBounds(171, 24, 151, 23);
		panelAction.add(btnManageReports);
		frmBngiuKhin.getContentPane().setLayout(groupLayout);
		fillData();
		btnChange.setEnabled(false);

	}
	
	private void fillData() {
		String[] header = teacherControler.getHeaderTable();
		ArrayList <Teacher> teacherList = teacherControler.getArrayListStudent();
		DefaultTableModel model = new DefaultTableModel(header, 0);
		Object[] row = new Object[header.length];
		for (int i = 0; i < teacherList.size(); i++) {
			row[0] = teacherList.get(i).getID();
			row[1] = teacherList.get(i).getFirstName();
			row[2] = teacherList.get(i).getLastName();
			row[3] = teacherList.get(i).getDob();
			row[4] = teacherList.get(i).getPhoneNumber();
			row[5] = teacherList.get(i).getGender();
			row[6] = teacherList.get(i).getHomeTown();
			row[7] = teacherList.get(i).getSchoolName();
			row[8] = teacherList.get(i).getSubjectName();
			model.addRow(row);
		}
		table.setModel(model);
	}
	
	private void clearTable() {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
	}
	
	private void resetSelectedInput() {
		txtID.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtDOB.setText("");
		txtPhoneNumber.setText("");
		txtHomeTown.setText("");
		txtSchool.setText("");
		btnChange.setEnabled(false);
	}
}
