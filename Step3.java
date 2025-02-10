import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class Step3 extends JFrame implements ActionListener
{

		JFrame F3 = new JFrame("Fill The Details to order");
		

		//For Customer Details
		 Label l1,l2,l3,l4,l5;
		 TextField t1,t2,t3,t4,t5;
		 Font f1,f2;
		 Button b1,b2;
		 Connection con;
		 PreparedStatement pstmt,pstmt2;
		
				
				
				int Restaurant_id=0;
			public Step3(int rs)
				{
					
					F3.setSize(1200,1000);
					F3.setLayout(null);
					F3.setVisible(true);


					Restaurant_id=rs;
					
					//For Customer Details
					l1=new Label("Customer_Name  :  ");
					Font f1=new Font("PRISTINA",Font.BOLD,25);
					l1.setBounds(100,100,350,50);
					l1.setFont(f1);
					l1.setForeground(Color.black);
					

					l2=new Label("Mobile_Number  :  ");
					l2.setBounds(100,150,350,50);
					l2.setFont(f1);
					l2.setForeground(Color.black);

					l3=new Label("Flat_no : ");
					l3.setBounds(100,200,350,50);
					l3.setFont(f1);
					l3.setForeground(Color.black);

					l4=new Label("Building_Name : ");
					l4.setBounds(100,250,350,50);
					l4.setFont(f1);
					l4.setForeground(Color.black);
				
					l5=new Label("Area : ");
					l5.setBounds(100,300,350,50);
					l5.setFont(f1);
					l5.setForeground(Color.black);
				
					t1=new TextField();
					Font f2=new Font("PRISTINA",Font.BOLD,20);
					t1.setBounds(550,100,300,30);
					t1.setFont(f2);
					F3.add(l1);
					F3.add(t1);

					t2=new TextField();
					t2.setBounds(550,150,300,30);
					t2.setFont(f2);
					F3.add(l2);
					F3.add(t2);

					t3=new TextField();
					t3.setBounds(550,200,300,30);
					t3.setFont(f2);
					F3.add(l3);
					F3.add(t3);

					t4=new TextField();
					t4.setBounds(550,250,300,30);
					t4.setFont(f2);
					F3.add(l4);
					F3.add(t4);

					t5=new TextField();
					t5.setBounds(550,300,300,30);
					t5.setFont(f2);
					F3.add(l5);
					F3.add(t5);


					b1=new Button("NEXT");		
					b1.setBounds(500,500,250,50);
					b1.setFont(f1);
					b1.setBackground(Color.darkGray);							
					b1.setForeground(Color.white);
					F3.add(b1);
					b1.addActionListener(this);
					
					
					try
				{

						Class.forName("com.mysql.cj.jdbc.Driver");
	  					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/harshda","root","1234");
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR IN CONNECTION");					
				}

				
			}
	

			


	public  void actionPerformed(ActionEvent ae)
		{
			
				
			
			if(ae.getSource()==b1)
			  {
				try
					{
						long mob=0L;
						String flat_n="";
						int cust_id=0;
						String name="";
						String build_nm ="";
						String area="";

									
					if(Restaurant_id==11)
			 		 {
				
						
						 pstmt =con.prepareStatement("insert into cust_details(cust_name,contact_no,flat_no,building_name,area,rest_id) values(?,?,?,?,?,11)");
									

							name=t1.getText();
							pstmt.setString(1,name);
							
							
							mob=Long.parseLong(t2.getText());
							if(mob>999999999L && mob<=9999999999L)
							{	
							pstmt.setLong(2,mob);
							}
							else
							{
							JOptionPane.showMessageDialog(null,"Enter valid contact no.");

							}

							flat_n=t3.getText();					
							pstmt.setString(3,flat_n);

							build_nm=t4.getText();
							pstmt.setString(4,build_nm);

							area=t5.getText();
							pstmt.setString(5,area);

							pstmt.executeUpdate();

				
							JOptionPane.showMessageDialog(null,"Record is saved");



					
							 pstmt2 =con.prepareStatement("select cust_id from cust_details where cust_name=? AND contact_no=? AND flat_no=? AND building_name=? AND area=? ");

							

							pstmt2.setString(1,name);
							pstmt2.setLong(2,mob);
							pstmt2.setString(3,flat_n);
							pstmt2.setString(4,build_nm);
							pstmt2.setString(5,area);


							ResultSet rs=pstmt2.executeQuery();
							rs.next();


							cust_id=rs.getInt(1);

							F3.setVisible(false);
							Step31 a=new Step31(11,cust_id);
		
					}

				else if(Restaurant_id==22)
			 		 {
				
						
						 pstmt =con.prepareStatement("insert into cust_details(cust_name,contact_no,flat_no,building_name,area,rest_id) values(?,?,?,?,?,22)");
									

							name=t1.getText();
							pstmt.setString(1,name);
										
							mob=Long.parseLong(t2.getText());
								if(mob>999999999L && mob<=9999999999L)
								{
								pstmt.setLong(2,mob);
																		
								}
								else
								{
								JOptionPane.showMessageDialog(null,"Enter valid cotact no.");

								}
							
							flat_n=t3.getText();					
							pstmt.setString(3,flat_n);

							build_nm=t4.getText();
							pstmt.setString(4,build_nm);

							area=t5.getText();
							pstmt.setString(5,area);

							pstmt.executeUpdate();

				
							JOptionPane.showMessageDialog(null,"Record is saved");

							 pstmt2 =con.prepareStatement("select cust_id from cust_details where cust_name=? AND contact_no=? AND flat_no=? AND building_name=? AND area=? ");

							

							pstmt2.setString(1,name);
							pstmt2.setLong(2,mob);
							pstmt2.setString(3,flat_n);
							pstmt2.setString(4,build_nm);
							pstmt2.setString(5,area);


							ResultSet rs=pstmt2.executeQuery();
							rs.next();


							cust_id=rs.getInt(1);

							F3.setVisible(false);
							Step32 b=new Step32(22,cust_id);
					}


				
					
				else if(Restaurant_id==33)
			 		 {
				
						
						 pstmt =con.prepareStatement("insert into cust_details(cust_name,contact_no,flat_no,building_name,area,rest_id) values(?,?,?,?,?,33)");
									

							name=t1.getText();
							pstmt.setString(1,name);
							



							mob=Long.parseLong(t2.getText());
							if(mob>999999999L && mob<=9999999999L)
							{	
							pstmt.setLong(2,mob);
							}
							else
							{
							JOptionPane.showMessageDialog(null,"Enter valid cotact no.");

							}						
							

							flat_n=t3.getText();					
							pstmt.setString(3,flat_n);

							build_nm=t4.getText();
							pstmt.setString(4,build_nm);

							area=t5.getText();
							pstmt.setString(5,area);

							
							pstmt.executeUpdate();

				
							JOptionPane.showMessageDialog(null,"Record is saved");
			
							 pstmt2 =con.prepareStatement("select cust_id from cust_details where cust_name=? AND contact_no=? AND flat_no=? AND building_name=? AND area=? ");

							

							pstmt2.setString(1,name);
							pstmt2.setLong(2,mob);
							pstmt2.setString(3,flat_n);
							pstmt2.setString(4,build_nm);
							pstmt2.setString(5,area);


							ResultSet rs=pstmt2.executeQuery();
							rs.next();


							cust_id=rs.getInt(1);

							F3.setVisible(false);								
							Step33 c=new Step33(33,cust_id);
					}


				else if(Restaurant_id==44)
			 		 {
				
						
						 pstmt =con.prepareStatement("insert into cust_details(cust_name,contact_no,flat_no,building_name,area,rest_id) values(?,?,?,?,?,44)");
									

							name=t1.getText();
							pstmt.setString(1,name);
							

							mob=Long.parseLong(t2.getText());
							if(mob>999999999L && mob<=9999999999L)
							{	
							pstmt.setLong(2,mob);
							}
							else
							{
							JOptionPane.showMessageDialog(null,"Enter valid cotact no.");

							}			
							
							flat_n=t3.getText();					
							pstmt.setString(3,flat_n);

							build_nm=t4.getText();
							pstmt.setString(4,build_nm);

							area=t5.getText();
							pstmt.setString(5,area);

							
							pstmt.executeUpdate();

							
							
							JOptionPane.showMessageDialog(null,"Record is saved");


							 pstmt2 =con.prepareStatement("select cust_id from cust_details where cust_name=? AND contact_no=? AND flat_no=? AND building_name=? AND area=? ");

							

							pstmt2.setString(1,name);
							pstmt2.setLong(2,mob);
							pstmt2.setString(3,flat_n);
							pstmt2.setString(4,build_nm);
							pstmt2.setString(5,area);


							ResultSet rs=pstmt2.executeQuery();
							rs.next();


							cust_id=rs.getInt(1);

							F3.setVisible(false);
							Step34 d=new Step34(44,cust_id);
						
					}


				

				}


				catch(Exception e)
								{
									JOptionPane.showMessageDialog(null,"Enter valid details");			
								}


			}



		}	
								


public static void main(String args[])
	{
		Step3 d=new Step3(1);
		
	}
}



