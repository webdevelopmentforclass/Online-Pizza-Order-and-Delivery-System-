import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class FeedBack1 extends JFrame implements ActionListener
{

		JFrame F = new JFrame("FeedBack");
		

		
		 Label l1,l2,l3;
		 TextField t1,t2,t3;
		 Font f1,f2;
		 Button b1,b2;


		 Connection con;
		 PreparedStatement pstmt,pstmt2;
		
				
			int Restaurant_id=0;	
				
			public FeedBack1(int rs)
				{
					
					F.setSize(1200,1000);
					F.setLayout(null);
					F.setVisible(true);

					Restaurant_id=rs;

					l1=new Label("Did you liked your Service....?");
					Font f1=new Font("PRISTINA",Font.BOLD,25);
					l1.setBounds(100,100,850,50);
					l1.setFont(f1);
					l1.setForeground(Color.black);
					F.add(l1);

					t1=new TextField();
					Font f2=new Font("PRISTINA",Font.BOLD,12);
					t1.setBounds(100,150,300,30);
					t1.setFont(f2);
					F.add(t1);
					

					l2=new Label("Any Suggetions...?");
					l2.setBounds(100,250,400,50);
					l2.setFont(f1);
					l2.setForeground(Color.black);
					F.add(l2);

					t2=new TextField();
					t2.setBounds(100,300,600,30);
					t2.setFont(f2);
					F.add(t2);					

					l3=new Label("Give Ratings...(*/10)");
					l3.setBounds(100,400,600,50);
					l3.setFont(f1);
					l3.setForeground(Color.black);
					F.add(l3);

					t3=new TextField();
					t3.setBounds(100,450,300,30);
					t3.setFont(f2);
					F.add(t3);

					
					b1=new Button("SAVE");		
					b1.setBounds(300,600,250,50);
					b1.setFont(f1);
					b1.setBackground(Color.darkGray);							
					b1.setForeground(Color.white);
					F.add(b1);
					b1.addActionListener(this);


					b2=new Button("HOME");		
					b2.setBounds(700,600,250,50);
					b2.setFont(f1);
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

				
			}
	

			


	public  void actionPerformed(ActionEvent ae)
		{
			
				
			
			if(ae.getSource()==b1)
			  {
				
				try
				{		
				if(Restaurant_id==11)
					{
					
						 pstmt =con.prepareStatement("insert into Pick_A_Pizza_FeedBack(service,suggestions,ratings) values(?,?,?)");
									

							String service_ans=t1.getText();
							pstmt.setString(1,service_ans);
							
							String suggest=t2.getText();
							pstmt.setString(2,suggest);

							
							float rate=Float.parseFloat(t3.getText());
							if(rate>0 || rate<11 )
							{
							pstmt.setFloat(3,rate);
							}

							else
							{
							JOptionPane.showMessageDialog(null,"Please give Valid points...out of 10");
							}
							
							pstmt.executeUpdate();

				
							JOptionPane.showMessageDialog(null,"Record is saved.....Thank you for your FeedBack");

						
					}


				

				else if(Restaurant_id==22)
			 		 {
				
						 pstmt =con.prepareStatement("insert into Pizza_Hut_FeedBack(service,suggestions,ratings) values(?,?,?)");
									

							String service_ans=t1.getText();
							pstmt.setString(1,service_ans);
							
							String suggest=t2.getText();
							pstmt.setString(2,suggest);

							
							float rate=Float.parseFloat(t3.getText());
							if(rate>0 || rate<11 )
							{
							pstmt.setFloat(3,rate);
							}

							else
							{
							JOptionPane.showMessageDialog(null,"Please give Valid points...out of 10");
							}
							
							pstmt.executeUpdate();

				
							JOptionPane.showMessageDialog(null,"Record is saved.....Thank you for your FeedBack");

						
						
					}


				
					
				else if(Restaurant_id==33)
			 		 {
				
						 pstmt =con.prepareStatement("insert into Pizza_House_FeedBack(service,suggestions,ratings) values(?,?,?)");
									

							String service_ans=t1.getText();
							pstmt.setString(1,service_ans);
							
							String suggest=t2.getText();
							pstmt.setString(2,suggest);

							
							float rate=Float.parseFloat(t3.getText());
							if(rate>0 || rate<11 )
							{
							pstmt.setFloat(3,rate);
							}

							else
							{
							JOptionPane.showMessageDialog(null,"Please give Valid points...out of 10");
							}
							
							pstmt.executeUpdate();

				
							JOptionPane.showMessageDialog(null,"Record is saved.....Thank you for your FeedBack");

						
					}	

				else if(Restaurant_id==44)
			 		 {
				
						 pstmt =con.prepareStatement("insert into Dominose_FeedBack(service,suggestions,ratings) values(?,?,?)");
									

							String service_ans=t1.getText();
							pstmt.setString(1,service_ans);
							
							String suggest=t2.getText();
							pstmt.setString(2,suggest);

							
							float rate=Float.parseFloat(t3.getText());
							if(rate>0 || rate<11 )
							{
							pstmt.setFloat(3,rate);
							}

							else
							{
							JOptionPane.showMessageDialog(null,"Please give Valid points...out of 10");
							}
							
							pstmt.executeUpdate();

				
							JOptionPane.showMessageDialog(null,"Record is saved.....Thank you for your FeedBack");
	
					}

				}
				catch(Exception e)
								{
									JOptionPane.showMessageDialog(null,"Enter valid details");			
								}

				}
			
				if(ae.getSource()==b2)


			  {
				
				try
				{
						F.setVisible(false);
						Step1 f=new Step1(); 

				}

				catch(Exception e)
								{
									JOptionPane.showMessageDialog(null,"Error");			
								}
	


			}	
		
	}						


public static void main(String args[])
	{
		FeedBack1 f1=new FeedBack1(1);
		
	}
}
