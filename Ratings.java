import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class Ratings extends JFrame implements ActionListener
{

		JFrame F = new JFrame("Ratings");
		
		 Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
		 Font f1,f2;
		 Button b1;


		// Connection con;
		 Statement st,stmt1,stmt2,stmt3;
		ResultSet rs,rs1,rs2,rs3;
		
				
			public Ratings()
				{
					
					F.setSize(1200,1000);
					F.setLayout(null);
					F.setVisible(true);

					

					try
				{

					Class.forName("com.mysql.cj.jdbc.Driver");
	  				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/harshda","root","1234");

			
					l1=new Label("Restaurant Name");
					Font f1=new Font("PRISTINA",Font.BOLD,35);
					l1.setBounds(100,100,400,50);
					l1.setFont(f1);
					l1.setForeground(Color.black);
					l1.setBackground(Color.cyan);
					F.add(l1);

					
					l2=new Label("Ratings");
					l2.setBounds(600,100,200,50);
					l2.setFont(f1);
					l2.setForeground(Color.black);
					l2.setBackground(Color.cyan);
					F.add(l2);

					Font f2=new Font("PRISTINA",Font.BOLD,25);
		
					
					l3=new Label("Pick A Pizza");
					l3.setBounds(110,250,380,50);
					l3.setFont(f2);
					l3.setForeground(Color.black);
					l3.setBackground(Color.cyan);
					F.add(l3);

					l4=new Label("Pizza Hut");
					l4.setBounds(110,350,380,50);
					l4.setFont(f2);
					l4.setForeground(Color.black);
					l4.setBackground(Color.cyan);
					F.add(l4);

					l5=new Label("Pizza House");
					l5.setBounds(110,450,380,50);
					l5.setFont(f2);
					l5.setForeground(Color.black);
					l5.setBackground(Color.cyan);
					F.add(l5);


					l6=new Label("Dominose");
					l6.setBounds(110,550,380,50);
					l6.setFont(f2);
					l6.setForeground(Color.black);
					l6.setBackground(Color.cyan);
					F.add(l6);

					b1=new Button("Go Back");		
					b1.setBounds(450,650,250,50);
					b1.setFont(f1);
					b1.setBackground(Color.darkGray);							
					b1.setForeground(Color.white);
					F.add(b1);
					b1.addActionListener(this);
					
				
						Statement st=con.createStatement();
						ResultSet rs=st.executeQuery("select avg(ratings) from Pick_A_Pizza_FeedBack");
						rs.next();

						float r=rs.getFloat(1);

						String str=String.valueOf(r);
							l7=new Label(str);
							l7.setBounds(620,250,380,50);
							l7.setFont(f2);
							l7.setForeground(Color.black);
							l7.setBackground(Color.cyan);
							F.add(l7);

						stmt1 =con.createStatement();
						rs1=stmt1.executeQuery("select avg(ratings) from Pizza_Hut_FeedBack");

						rs1.next();
						float r1=rs1.getFloat(1);
						String str1=String.valueOf(r1);
							l8=new Label(str1);
							l8.setBounds(620,350,380,50);
							l8.setFont(f2);
							l8.setForeground(Color.black);
							l8.setBackground(Color.cyan);
							F.add(l8);

						stmt2 =con.createStatement();
						rs2=stmt2.executeQuery("select avg(ratings) from Pizza_House_FeedBack");

						rs2.next();
						float r2=rs2.getFloat(1);
						String str2=String.valueOf(r2);
							l9=new Label(str2);
							l9.setBounds(620,450,380,50);
							l9.setFont(f2);
							l9.setForeground(Color.black);
							l9.setBackground(Color.cyan);
							F.add(l9);


						stmt3 =con.createStatement();
						rs3=stmt3.executeQuery("select avg(ratings) from Dominose_FeedBack");

						rs3.next();
						float r3=rs3.getFloat(1);
						String str3=String.valueOf(r3);
							l10=new Label(str3);
							l10.setBounds(620,550,380,50);
							l10.setFont(f2);
							l10.setForeground(Color.black);
							l10.setBackground(Color.cyan);
							F.add(l10);
					}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR IN CONNECTION");
					System.out.println(e);					
				}
			
			}
	

	public  void actionPerformed(ActionEvent ae)
		{
			
				
			
			if(ae.getSource()==b1)
			  {
				
				try
				{		
					F.setVisible(false);
					Step1 st=new Step1();

				}
				catch(Exception e)
								{
									JOptionPane.showMessageDialog(null,"Error");			
								}

		}	
		
	}						


public static void main(String args[])
	{
		Ratings r=new Ratings();
		
	}
}




















