package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import core.AddStudentControl;
import model.Student;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudent {

	public JFrame frmThmHcSinh;
	private JTextField txtLastName;
	private JTextField txtFirstName;
	private JTextField txtAddress;
	private JTextField txtPhoneNumber;
	private JTextField txtHomeTown;
	private JTextField txtThcsTrnHng;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					AddStudent window = new AddStudent();
					window.frmThmHcSinh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddStudent() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmThmHcSinh = new JFrame();
		frmThmHcSinh.setTitle("Th\u00EAm h\u1ECDc sinh");
		frmThmHcSinh.setBounds(100, 100, 586, 286);
		frmThmHcSinh.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmThmHcSinh.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u1ECDc sinh", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 550, 148);
		frmThmHcSinh.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("H\u1ECD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 23, 75, 23);
		panel.add(lblNewLabel);
		
		txtLastName = new JTextField();
		txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtLastName.setBounds(95, 24, 148, 20);
		panel.add(txtLastName);
		txtLastName.setColumns(10);
		
		txtFirstName = new JTextField();
		txtFirstName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(392, 24, 148, 20);
		panel.add(txtFirstName);
		
		JLabel lblTn = new JLabel("T\u00EAn");
		lblTn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTn.setBounds(307, 23, 75, 23);
		panel.add(lblTn);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtAddress.setColumns(10);
		txtAddress.setBounds(95, 58, 148, 20);
		panel.add(txtAddress);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblaCh.setBounds(10, 57, 75, 23);
		panel.add(lblaCh);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(392, 56, 148, 20);
		panel.add(txtPhoneNumber);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSinThoi.setBounds(307, 55, 75, 23);
		panel.add(lblSinThoi);
		
		JLabel lblQuQun = new JLabel("Qu\u00EA qu\u00E1n");
		lblQuQun.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblQuQun.setBounds(10, 93, 75, 23);
		panel.add(lblQuQun);
		
		txtHomeTown = new JTextField();
		txtHomeTown.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtHomeTown.setColumns(10);
		txtHomeTown.setBounds(95, 94, 148, 20);
		panel.add(txtHomeTown);
		
		txtThcsTrnHng = new JTextField();
		txtThcsTrnHng.setText("THCS Tr\u1EA7n H\u01B0ng \u0110\u1EA1o");
		txtThcsTrnHng.setEditable(false);
		txtThcsTrnHng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtThcsTrnHng.setColumns(10);
		txtThcsTrnHng.setBounds(392, 94, 148, 20);
		panel.add(txtThcsTrnHng);
		
		JLabel lblTrng = new JLabel("Tr\u01B0\u1EDDng");
		lblTrng.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrng.setBounds(307, 93, 75, 23);
		panel.add(lblTrng);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "B\u1EA3ng \u0111i\u1EC1u khi\u1EC3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 170, 550, 46);
		frmThmHcSinh.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAdd = new JButton("Th\u00EAm h\u1ECDc sinh");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//id, String firstName, String lastName, String address, String phoneNumber, String gender, String homeTown, String schoolId, String academicYearStart
				Student student = new Student(0, txtFirstName.getText().toString(), txtLastName.getText().toString(), txtAddress.getText().toString() ,txtPhoneNumber.getText().toString(), "Nam", txtHomeTown.getText().toString(), "1", "2017-01-01");
				AddStudentControl ad = new AddStudentControl();
				boolean isSuccess = ad.addStudent(student);
				if(isSuccess) {
					JOptionPane.showMessageDialog(null, "Cập nhật thông tin học sinh thành công", "Thành công", JOptionPane.INFORMATION_MESSAGE);						
				}
				else JOptionPane.showMessageDialog(null, "Đã có lỗi trong quá trình thêm học sinh mới", "Thất bại", JOptionPane.ERROR_MESSAGE);						

			}
		});
		btnAdd.setBounds(10, 16, 117, 23);
		panel_1.add(btnAdd);
	}
}
