
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class Step2 extends JFrame implements ActionListener
{
		JFrame F2 = new JFrame("Restaurents");

		Label l4,l5,l6,l7,l8,l9,l10,l11;
		Font f1,f2;
		Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
		CardLayout cl;
		Connection con;
		PreparedStatement pstmt;
		
			Step2()
			{
					
					l4=new Label("Select your restaurent  :  ");
					Font f1=new Font("PRISTINA",Font.BOLD,40);
					l4.setBounds(250,50,550,50);
					l4.setFont(f1);
					l4.setForeground(Color.black);
					F2.add(l4);

					l5=new Label("Restaurent");
					Font f3=new Font("PRISTINA",Font.BOLD,35);
					l5.setBounds(100,200,300,40);
					l5.setFont(f3);
					l5.setForeground(Color.white);
					l5.setBackground(Color.black);
					F2.add(l5);
			
					l6=new Label("Menucard");
					l6.setBounds(450,200,300,40);
					l6.setFont(f3);
					l6.setForeground(Color.white);
					l6.setBackground(Color.black);
					F2.add(l6);

					l7=new Label("Order");
					l7.setBounds(800,200,300,40);
					l7.setFont(f3);
					l7.setForeground(Color.white);
					l7.setBackground(Color.black);
					F2.add(l7);
			

					l8=new Label("Pick A Pizza");
					Font f2=new Font("PRISTINA",Font.BOLD,30);
					l8.setBounds(100,300,300,30);
					l8.setFont(f2);
					l8.setForeground(Color.white);
					l8.setBackground(Color.blue);
					F2.add(l8);


					l9=new Label("Pizza Hut");
					l9.setBounds(100,400,300,30);
					l9.setFont(f2);
					l9.setForeground(Color.white);
					l9.setBackground(Color.red);
					F2.add(l9);


					l10=new Label("Pizza House");
					l10.setBounds(100,500,300,30);
					l10.setFont(f2);
					l10.setForeground(Color.white);
					l10.setBackground(Color.orange);
					F2.add(l10);


					l11=new Label("Dominose");
					l11.setBounds(100,600,300,30);
					l11.setFont(f2);
					l11.setForeground(Color.white);
					l11.setBackground(Color.darkGray);
					F2.add(l11);


					b3=new Button("Order Now");		
					b3.setBounds(800,300,300,30);
					b3.setFont(f2);
					b3.setBackground(Color.blue);							
					b3.setForeground(Color.white);
					F2.add(b3);
					b3.addActionListener(this);	

					b4=new Button("Order Now");		
					b4.setBounds(800,400,300,30);
					b4.setFont(f2);
					b4.setBackground(Color.red);							
					b4.setForeground(Color.white);
					F2.add(b4);
					b4.addActionListener(this);	

					b5=new Button("Order Now");		
					b5.setBounds(800,500,300,30);
					b5.setFont(f2);
					b5.setBackground(Color.orange);							
					b5.setForeground(Color.white);
					F2.add(b5);
					b5.addActionListener(this);	

					b6=new Button("Order Now");		
					b6.setBounds(800,600,300,30);
					b6.setFont(f2);
					b6.setBackground(Color.darkGray);							
					b6.setForeground(Color.white);
					F2.add(b6);
					b6.addActionListener(this);

					b7=new Button("Menucard");		
					b7.setBounds(450,300,300,30);
					b7.setFont(f2);
					b7.setBackground(Color.blue);							
					b7.setForeground(Color.white);
					F2.add(b7);
					b7.addActionListener(this);

					b8=new Button("Menucard");		
					b8.setBounds(450,400,300,30);
					b8.setFont(f2);
					b8.setBackground(Color.red);							
					b8.setForeground(Color.white);
					F2.add(b8);
					b8.addActionListener(this);

					b9=new Button("Menucard");		
					b9.setBounds(450,500,300,30);
					b9.setFont(f2);
					b9.setBackground(Color.orange);							
					b9.setForeground(Color.white);
					F2.add(b9);
					b9.addActionListener(this);
				
					b10=new Button("Menucard");		
					b10.setBounds(450,600,300,30);
					b10.setFont(f2);
					b10.setBackground(Color.darkGray);							
					b10.setForeground(Color.white);
					F2.add(b10);
					b10.addActionListener(this);


					F2.setSize(1200,1000);
					F2.setLayout(null);
					F2.setVisible(true);
					

			try
				{
							System.out.println("Hiii");
						
							Class.forName("com.mysql.cj.jdbc.Driver");
	  					  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/harshda","root","1234");
			
				}
		catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"ERROR IN CONNECTION");					
				}
			}


	public void actionPerformed(ActionEvent ae)
		{
				if(ae.getSource()==b3)
			 		 {
						try
						{
							F2.setVisible(false);						
							
							Step3 a=new Step3(11);
							
						}

						catch(Exception e)
						{
							System.out.println(e);		
						}
	
					}
			
			if(ae.getSource()==b4)
			  {
				try
					{		
							F2.setVisible(false);
							
							Step3 b=new Step3(22);							

					}

				catch(Exception e)
				{
					System.out.println(e);		
				}

			}

		if(ae.getSource()==b5)
			  {
				try
					{
							F2.setVisible(false);
							JOptionPane.showMessageDialog(null,"You selected Pizza House");	
							
							Step3  c=new Step3(33);								
								
			
					}

				catch(Exception e)
				{
					System.out.println(e);		
				}

			}


		if(ae.getSource()==b6)
			  {
				try
					{
					
							F2.setVisible(false);
							JOptionPane.showMessageDialog(null,"You selected Dominos");	
							
							Step3 d=new Step3(44);					
					}
					

				catch(Exception e)
				{
					System.out.println(e);		
				}

			}

				

		
			if(ae.getSource()==b7)
			  {
				try
					{
					
							F2.setVisible(false);
							
						Menu1 m=new Menu1();
					
					}
					

				catch(Exception e)
				{
					System.out.println(e);		
				}

			}


			if(ae.getSource()==b8)
			  {
				try
					{
					
							F2.setVisible(false);
							Menu2 m2=new Menu2();
					
					}
					

				catch(Exception e)
				{
					System.out.println(e);		
				}

			}


			if(ae.getSource()==b9)
			  {
				try
					{
					
							F2.setVisible(false);
							Menu3 m3=new  Menu3();
					}
					

				catch(Exception e)
				{
					System.out.println(e);		
				}

			}


			if(ae.getSource()==b10)
			  {
				try
					{
					
							F2.setVisible(false);
							Menu4 m4=new Menu4();
					
					}
					

					catch(Exception e)
					{
						System.out.println(e);		
					}

			}
		}



public static void main(String args[])
	{
		new Step2();
	}
}
