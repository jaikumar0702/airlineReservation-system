import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class addcustomer extends JInternalFrame {
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtnic;
	private JTextField txtpassport;
	private JTextField txtcontact;
	private JLabel txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcustomer frame = new addcustomer();
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
	
	String path=null;
	byte[] userimage=null;
	
	public addcustomer() {
		
		setBounds(100, 100, 1226, 700);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(240, 255, 240));
		panel.setBackground(new Color(0, 0, 255));
		
		JLabel lblNewLabel_5 = new JLabel("Customer ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		 txtid = new JLabel();
		txtid.setForeground(new Color(255, 0, 0));
		txtid.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 255));
		
		JLabel txtphoto = new JLabel("");
		txtphoto.setPreferredSize(new Dimension(250, 250));
		txtphoto.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton btnbrowse = new JButton("Browse");
		btnbrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					JFileChooser picchooser=new JFileChooser();
					picchooser.showOpenDialog(null);
					File pic= picchooser.getSelectedFile();
					
					FileNameExtensionFilter filter= new FileNameExtensionFilter("","images","png","jpg");
					picchooser.addChoosableFileFilter(filter);
					
					path=pic.getAbsolutePath();
					BufferedImage img ;
					img = ImageIO.read(picchooser.getSelectedFile());
					ImageIcon imageIcon= new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT) );
                        txtphoto.setIcon(imageIcon);
                        
                        File image = new File(path);
                        FileInputStream fis=new FileInputStream(image);
                        ByteArrayOutputStream baos= new ByteArrayOutputStream();
                        
                        byte[] buff = new byte[1024];                      
                        for(int readNum; (readNum=fis.read(buff)) !=-1 ; ) {
                        	baos.write(buff,0,readNum);
                        }
                        userimage=baos.toByteArray();
                  
                        
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnAdd = new JButton("Add");
		
		
		JButton btncancel = new JButton("Cancel");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(txtphoto, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
							.addGap(44)
							.addComponent(btncancel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(172)
							.addComponent(btnbrowse, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
							.addGap(89))))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(92)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtid, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(837, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtid))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(txtphoto, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnbrowse, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(btncancel, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(126, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_7 = new JLabel("Date Of Birth");
		lblNewLabel_7.setForeground(new Color(240, 248, 255));
		lblNewLabel_7.setBackground(new Color(240, 255, 240));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setForeground(new Color(240, 248, 255));
		lblNewLabel_8.setBackground(new Color(240, 255, 240));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_9 = new JLabel("Contact");
		lblNewLabel_9.setForeground(new Color(240, 248, 255));
		lblNewLabel_9.setBackground(new Color(240, 255, 240));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JDateChooser txtdob = new JDateChooser();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		
		txtcontact = new JTextField();
		txtcontact.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblNewLabel_9, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(lblNewLabel_8, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(txtdob, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtcontact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(98)
							.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(99)
							.addComponent(txtdob, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtcontact, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(128, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBackground(new Color(255, 99, 71));
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setPreferredSize(new Dimension(30, 13));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setForeground(new Color(240, 255, 240));
		
		JLabel lblNewLabel_2 = new JLabel("NIc NO");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(new Color(240, 255, 240));
		
		JLabel lblNewLabel_3 = new JLabel("Passport id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setForeground(new Color(240, 255, 240));
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setForeground(new Color(240, 255, 240));
		
		txtfirstname = new JTextField();
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setColumns(10);
		
		txtnic = new JTextField();
		txtnic.setColumns(10);
		
		txtpassport = new JTextField();
		txtpassport.setColumns(10);
		
		JTextArea txtaddress = new JTextArea();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtlastname)
							.addComponent(txtfirstname, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
							.addComponent(txtnic)
							.addComponent(txtpassport))
						.addComponent(txtaddress, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtfirstname, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtlastname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
						.addComponent(txtnic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE)
						.addComponent(txtpassport, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtaddress, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
					.addGap(75))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		
		
		autoId();
		txtid= new JLabel();
		
		
		btnAdd.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				String id ="111";
				String firstname= txtfirstname.getText();
				String lastname=txtlastname.getText();
				String nicno= txtnic.getText();
				String passportno=txtpassport.getText();
				String address=txtaddress.getText().toString();
				
				DateFormat da =new SimpleDateFormat("yyyy-mm-dd ");
				String date =da.format(txtdob.getDate());
				
				String Gender = null;
				if(rdbtnNewRadioButton.isSelected()) {
					Gender="Male";
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					Gender="Female";
				}
				String contact =txtcontact.getText();
				
				
				try {
					Conn c1=new Conn();
					String s2="insert INTO customer VALUES('"+id+"','"+firstname+"','"+lastname+"','"+nicno+"','"+passportno+"','"+address+"','"+date+"','"+Gender+"','"+contact+"','"+userimage+"')";
				      c1.s.executeUpdate(s2);
				      JOptionPane.showMessageDialog(null, "Registration Created");
				}
				catch(Exception e1) {
					System.out.println(e1);
					
				}
			}
		});
		

	}
	
	
	
	public void autoId() {
		  try {
			  Conn c1= new Conn();
			  String s="select MAX(id) from customer";
			  System.out.println("dsf");
			 ResultSet rs= c1.s.executeQuery(s);
			   rs.next();
			   
			 if(rs.getString(1) == null) {
				txtid.setText("CS001");
			 }
			 else
			 {
				 long ID= Long.parseLong(rs.getString("MAX(id)").substring(2,rs.getString("MAX(id)").length()));
				 ID++;
				 txtid.setText(" CS" +String.format("%03d", ID));
			 } 
		  }catch(Exception e){
			  
			  System.out.println(e);
		  }
	}
}
