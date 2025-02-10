//Step 1 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Step1 extends JFrame implements ActionListener
{
		
		JFrame F1 = new JFrame("Pizza World");
			Label lab1;
			Button but1,but2,but3,but4;
			
		
				Step1()
				{
									
					lab1=new Label(" WELCOME To Pizza World...!!!!");
					lab1.setBackground(Color.black);
					lab1.setForeground(Color.red);
					Font f1=new Font("PRISTINA",Font.BOLD,40);
					lab1.setBounds(230,80,900,30);
					lab1.setFont(f1);
					F1.add(lab1);
				
					Font f2=new Font("PRISTINA",Font.BOLD,20);

					but1=new Button("See Restaurants");						
					but1.setBounds(400,200,450,40);
					but1.setFont(f2);
					but1.setBackground(Color.red);							
					but1.setForeground(Color.white);
					but1.addActionListener(this);	
					F1.add(but1);

					but2=new Button("Give FeedBack");						
					but2.setBounds(400,300,450,40);
					but2.setFont(f2);
					but2.setBackground(Color.red);							
					but2.setForeground(Color.white);
					but2.addActionListener(this);	
					F1.add(but2);
					
					but3=new Button("See Ratings");						
					but3.setBounds(400,400,450,40);
					but3.setFont(f2);
					but3.setBackground(Color.red);							
					but3.setForeground(Color.white);
					but3.addActionListener(this);	
					F1.add(but3);


					but4=new Button("Exit");						
					but4.setBounds(400,500,450,40);
					but4.setFont(f2);
					but4.setBackground(Color.red);							
					but4.setForeground(Color.white);
					but4.addActionListener(this);	
					F1.add(but4);

					F1.setSize(1200,1000);
					F1.setLayout(null);
					F1.setVisible(true);
					
		
				}
				
				
				
				public void actionPerformed(ActionEvent ae)
					{
							if(ae.getSource()==but1)
								{
									F1.setVisible(false);

										Step2 s2=new Step2();
								}

							 if(ae.getSource()==but2)
								{
									F1.setVisible(false);

										FeedBack b=new FeedBack();
								}


							 if(ae.getSource()==but3)
								{
									F1.setVisible(false);

										Ratings s2=new Ratings();
								}


							if(ae.getSource()==but4)
								{
									F1.setVisible(false);

										
								}
				
					}
				
	
public static void main(String args[])
	{
		
			new Step1();
		
	}
	
}

