import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;



public class Bill3 extends JFrame implements ActionListener
{


		JFrame F = new JFrame("Billing Details");	
	
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
		JLabel t3,t4,t5,t6;
		Button b1,b2;
		
		Connection con;
		PreparedStatement pstmt,pstmt2,pstmt3,pstmt4,pstmt5,pstmt6,pstmt7;
		int c_id,dc;
		double d1,d2;

		Font f1=new Font("PRISTINA",Font.BOLD,20);
		Font f2=new Font("PRISTINA",Font.PLAIN,20);
		Font f3=new Font("PRISTINA",Font.BOLD,30);


		Bill3(int ci)
				{
					F.setSize(1200,1000);
					F.setLayout(null);
					F.setVisible(true);

						c_id=ci;
						
					

					b1=new Button("CONFORM ORDER");		
					b1.setBounds(750,650,150,40);
					Font f4=new Font("PRISTINA",Font.BOLD,20);
					b1.setFont(f4);
					b1.setBackground(Color.darkGray);							
					b1.setForeground(Color.white);
					F.add(b1);
					b1.addActionListener(this);	

					b2=new Button("CANCEL ORDER");		
					b2.setBounds(200,650,200,40);
					b2.setFont(f4);
					b2.setBackground(Color.darkGray);							
					b2.setForeground(Color.white);
					F.add(b2);
					b2.addActionListener(this);
					
						try
					{

						Class.forName("com.mysql.cj.jdbc.Driver");
	  					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/harshda","root","1234");
					}
						catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"ERROR IN CONNECTION");					
					}	



					try{			
					

						l1=new JLabel(" Pizza House");
						l1.setBackground(Color.white);
						l1.setBounds(400,50,300,60);
						l1.setFont(f3);
						F.add(l1);
							

						String name=new String();
					pstmt=con.prepareStatement("select cust_name from cust_details where cust_id=?");
					pstmt.setInt(1,c_id);

							ResultSet rs = pstmt.executeQuery();
							while(rs.next())
							{
								name=rs.getString(1);
							}

						l4=new JLabel("Hallo  "+name);
						l4.setBackground(Color.white);
						l4.setBounds(150,100,300,40);
						l4.setFont(f1);
						F.add(l4);
												

					
								l7 = new JLabel(" ITEM ORDERED ");
								l7.setBackground(Color.white);
								l7.setBounds(150,150,250,30);
								l7.setFont(f2);
								F.add(l7);
								
								l8 = new JLabel("QUANTITY");
								l8.setBounds(500,150,100,30);
								l8.setFont(f2);
								F.add(l8);
								
								l9 = new JLabel("COST");
								l9.setBounds(650,150,80,30);
								l9.setFont(f2);
								F.add(l9);
								
								l10 = new JLabel("TOTAL");
								l10.setBounds(780,150,80,30);
								l10.setFont(f2);
								F.add(l10);
								


					int i = 0,j = 0,x=0;
					pstmt2=con.prepareStatement("select order_name,quantity,bill,total_amount from Pizza_House where cust_id=?");
					pstmt2.setInt(1,c_id);

							ResultSet rs2 = pstmt2.executeQuery();

							while(rs2.next())
							{
								
								
								t3 = new JLabel();
								t3.setBounds(150,200+x,250,30);
								t3.setFont(f2);
								F.add(t3);
								t3.setText(rs2.getString(1));

								t5 = new JLabel();
								t5.setBounds(500,200+x,100,30);
								t5.setFont(f2);
								F.add(t5);
								int q =rs2.getInt(2);
								t5.setText(Integer.toString(q));

								t4 = new JLabel();
								t4.setBounds(650,200+x,80,30);
								t4.setFont(f2);
								F.add(t4);
								Double bill = Double.parseDouble(rs2.getString(3));
								t4.setText(Double.toString(bill));

								t6 = new JLabel();
								t6.setBounds(780,200+x,80,30);
								t6.setFont(f2);
								F.add(t6);
								Double ta = Double.parseDouble(rs2.getString(4));
								t6.setText(Double.toString(ta));

								
						
								x=x+25;

							}


						pstmt3=con.prepareStatement("select sum(total_amount) from Pizza_House where cust_id=?");
						pstmt3.setInt(1,c_id);

							ResultSet rs3 = pstmt3.executeQuery();
		
								l5 = new JLabel("Total  Bill  :  ");
								l5.setBounds(200,500,300,30);
								l5.setFont(f2);
								F.add(l5);
							while(rs3.next())
							{
								
								d1=rs3.getDouble(1);
								String d=Double.toString(d1);
								l6 = new JLabel(d);
								l6.setBounds(600,500,200,30);
								l6.setFont(f2);
								F.add(l6);
							}


					
						pstmt4=con.prepareStatement("select sum(total_amount)*0.12 from Pizza_House where cust_id=?");
					pstmt4.setInt(1,c_id);

							ResultSet rs4 = pstmt4.executeQuery();
		
								l11 = new JLabel("GST (12%) : ");
								l11.setBounds(200,530,300,30);
								l11.setFont(f1);
								F.add(l11);
							while(rs4.next())
							{
								
								d2=rs4.getDouble(1);
								String d=Double.toString(d2);
								l12 = new JLabel(d);
								l12.setBounds(600,530,200,30);
								l12.setFont(f1);
								F.add(l12);
							}


							if(d1>=1000)
							{

								dc=0;
								l15 = new JLabel("Congratulations....No Delivery Charge for u : ");
								l15.setBounds(200,650,700,30);
								l15.setFont(f1);
								F.add(l15);
							}
							else
							{
								dc=50;
							}

							l13 = new JLabel("Delivery Charge : ");
							l13.setBounds(200,560,300,30);
							l13.setFont(f1);
							F.add(l13);
							
							l14 = new JLabel();
							l14.setBounds(600,560,200,30);
							l14.setFont(f1);
							F.add(l14);
							l14.setText(Integer.toString(dc));


							l16 = new JLabel("Total Payable Amount : ");
							l16.setBounds(200,590,300,30);
							l16.setFont(f1);
							F.add(l16);
							
							l17 = new JLabel();
							l17.setBounds(600,590,200,30);
							l17.setFont(f1);
							F.add(l17);
							double d=d1+d2;
							l17.setText(Double.toString(d));



							pstmt7=con.prepareStatement("insert into  Pizza_House_Bill (cust_id,paid_amount) values(?,?) ");
					pstmt7.setInt(1,c_id);
					pstmt7.setDouble(2,d);
					
					

							pstmt7.executeUpdate();


						
							
						}

							catch(Exception e)

							{
								System.out.println(e);
							}

			

				
				}



			public void actionPerformed(ActionEvent ae)
				{

				if(ae.getSource()==b1)
			 	{				
					
						JOptionPane.showMessageDialog(null,"Your order is saved...Thank you...!!!!");

						F.setVisible(false);
						Step1 st=new Step1();	

				}


					
						if(ae.getSource()==b2)
			 				 {
								try
								{
									
								
							 pstmt5 =con.prepareStatement("delete from cust_details where cust_id=? ");
							pstmt6 =con.prepareStatement("delete from Pizza_House where cust_id=? ");

							

							pstmt5.setInt(1,c_id);
							pstmt6.setInt(1,c_id);
							pstmt5.executeUpdate();
							pstmt6.executeUpdate();
							
							

								F.setVisible(false);
								Step1 st=new Step1();
								}

								catch(Exception e)
								{
									System.out.println(e);		
								}



							}


			}
				
		
public static void main(String args[])
	{
		new Bill3(1);										
		
	}
	
}
