
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 class FeedBack extends JFrame implements ActionListener
{

		JFrame F = new JFrame("Give FeedBack");
		

		 Label l1,l2,l3,l4;
		 Font f1;
		 Button b1,b2,b3,b4;
	
			public FeedBack()
				{
					
					F.setSize(1200,1000);
					F.setLayout(null);
					F.setVisible(true);


					l1=new Label("Pick_A_Pizza");
					Font f1=new Font("PRISTINA",Font.BOLD,25);
					l1.setBounds(200,100,350,50);
					l1.setFont(f1);
					l1.setForeground(Color.white);
					l1.setBackground(Color.black);
					F.add(l1);

					l2=new Label("Pizza_Hut");
					l2.setBounds(200,250,350,50);
					l2.setFont(f1);
					l2.setForeground(Color.white);
					l2.setBackground(Color.black);
					F.add(l2);

					l3=new Label("Pizza_House");
					l3.setBounds(200,400,350,50);
					l3.setFont(f1);
					l3.setForeground(Color.white);
					l3.setBackground(Color.black);
					F.add(l3);

					l4=new Label("Dominose");
					l4.setBounds(200,550,350,50);
					l4.setFont(f1);
					l4.setForeground(Color.white);
					l4.setBackground(Color.black);
					F.add(l4);
				
					


					b1=new Button("NEXT");		
					b1.setBounds(600,100,250,50);
					b1.setFont(f1);
					b1.setBackground(Color.darkGray);							
					b1.setForeground(Color.white);
					F.add(b1);
					b1.addActionListener(this);

					b2=new Button("NEXT");		
					b2.setBounds(600,250,250,50);
					b2.setFont(f1);
					b2.setBackground(Color.darkGray);							
					b2.setForeground(Color.white);
					F.add(b2);
					b2.addActionListener(this);


					b3=new Button("NEXT");		
					b3.setBounds(600,400,250,50);
					b3.setFont(f1);
					b3.setBackground(Color.darkGray);							
					b3.setForeground(Color.white);
					F.add(b3);
					b3.addActionListener(this);


					b4=new Button("NEXT");		
					b4.setBounds(600,550,250,50);
					b4.setFont(f1);
					b4.setBackground(Color.darkGray);							
					b4.setForeground(Color.white);
					F.add(b4);
					b4.addActionListener(this);

				
			}
	

			


	public  void actionPerformed(ActionEvent ae)
		{
			
				
			
			if(ae.getSource()==b1)
			  {
				try
					{

						F.setVisible(false);
						FeedBack1 f1=new FeedBack1(11);
						

					}


				catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Enter valid details");			
					}

			  }


			else if(ae.getSource()==b2)
			  {
				try
					{

						F.setVisible(false);
						FeedBack1 f2=new FeedBack1(22);
						

					}


				catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Enter valid details");			
					}

			  }


			else if(ae.getSource()==b3)
			  {
				try
					{

						F.setVisible(false);
						FeedBack1 f3=new FeedBack1(33);
						

					}


				catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Enter valid details");			
					}

			  }


			else if(ae.getSource()==b4)
			  {
				try
					{

						F.setVisible(false);
						FeedBack1 f4=new FeedBack1(44);
						

					}


				catch(Exception e)
					{
						JOptionPane.showMessageDialog(null,"Enter valid details");			
					}

			  }

		}

							


public static void main(String args[])
	{
		FeedBack f=new FeedBack();
		
	}
}




















