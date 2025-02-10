
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Menu3 extends JFrame implements ActionListener
{

		JFrame F3 = new JFrame("Pizza House");

		Label l[]=new Label[30];
		
		Button b1,b2;
		
		
			Menu3()
				{
					
					F3.setSize(1200,1000);
					F3.setLayout(null);
					F3.setVisible(true);
					F3.setForeground(Color.cyan);
				
					
					l[26]=new Label("WELCOME To Pizza House...!!!!");
					Font f1=new Font("PRISTINA",Font.BOLD,30);
					l[26].setBounds(250,80,550,30);
					l[26].setFont(f1);
					l[26].setBackground(Color.red);
					l[26].setForeground(Color.black);
					F3.add(l[26]);
					
					l[27]=new Label("\"VEG \" ");
					Font f3=new Font("PRISTINA",Font.BOLD,30);
					l[27].setBounds(75,150,200,30);
					l[27].setFont(f3);
					F3.add(l[27]);

					Font f2=new Font("PRISTINA",Font.BOLD,18);

					l[1]=new Label("Toasted Pizza");
					l[1].setBounds(50,250, 180,40);
					l[1].setFont(f2);
					F3.add(l[1]);
					
					
					l[2]=new Label("Rs.160");
					l[2].setBounds(300,255,80,30);
					l[2].setFont(f2);
					F3.add(l[2]);
					
					
					l[3]=new Label("Desert Pizza");
					l[3].setBounds(50,300, 180,40);
					l[3].setFont(f2);  
					F3.add(l[3]);
					
					l[4]=new Label("Rs.180");
					l[4].setBounds(300,305,80,30);
					l[4].setFont(f2);
					F3.add(l[4]);


					l[5]=new Label("Pizza Romana");
					l[5].setBounds(50,350, 180,40);  
					l[5].setFont(f2);					
					F3.add(l[5]);
					

					l[6]=new Label("Rs.200");
					l[6].setBounds(300,355,80,30);
					l[6].setFont(f2);
					F3.add(l[6]);

					l[7]=new Label("Pizza Marinora");
					l[7].setBounds(50,400, 180,40);  
					l[7].setFont(f2);					
					F3.add(l[7]);
					

					l[8]=new Label("Rs.200");
					l[8].setBounds(300,405,80,30);
					l[8].setFont(f2);
					F3.add(l[8]);




					l[9]=new Label("\"NON-VEG\"");
					l[9].setBounds(575,150,400,30);
					l[9].setFont(f3);
					F3.add(l[9]);


					l[10]=new Label("Chicken Spice");
					l[10].setBounds(550,250,180,40);
					l[10].setFont(f2);
					F3.add(l[10]);

					l[11]=new Label("Rs.220");
					l[11].setBounds(800,255,80,30);
					l[11].setFont(f2);
					F3.add(l[11]);
					

					l[12]=new Label("Kheema Masala");
					l[12].setBounds(550,300,180,40);
					l[12].setFont(f2);
					F3.add(l[12]);

					l[13]=new Label("Rs.285");
					l[13].setBounds(800,305,80,30);
					l[13].setFont(f2);
					F3.add(l[13]);


					
					l[28]=new Label("Double Trouble");
					l[28].setBounds(550,350, 180,40);
					l[28].setFont(f2);
					F3.add(l[28]);

					l[29]=new Label("Rs.250");
					l[29].setBounds(800,355,80,30);
					l[29].setFont(f2);
					F3.add(l[29]);

					l[14]=new Label(" Ultimate Chicken ");
					l[14].setBounds(550,400,180,40);
					l[14].setFont(f2);
					F3.add(l[14]);

					l[15]=new Label("Rs.220");
					l[15].setBounds(800,405,80,30);
					l[15].setFont(f2);
					F3.add(l[15]);
					
					b1=new Button("ORDER Now");		
					b1.setBounds(750,600,150,40);
					Font f4=new Font("PRISTINA",Font.BOLD,20);
					b1.setFont(f4);
					b1.setBackground(Color.darkGray);							
					b1.setForeground(Color.white);
					F3.add(b1);
					b1.addActionListener(this);	

					b2=new Button("SEE ANOTHER RESTAURANT");		
					b2.setBounds(150,600,450,40);
					b2.setFont(f4);
					b2.setBackground(Color.darkGray);							
					b2.setForeground(Color.white);
					F3.add(b2);
					b2.addActionListener(this);

				}
				
			
				
			
				public void actionPerformed(ActionEvent ae)
					{
							if(ae.getSource()==b1)
			 				 {
								try
								{
								F3.setVisible(false);		
								Step3 s33=new Step3(33);

								}

							catch(Exception e)
							{
								System.out.println(e);		
							}
	
						}

						if(ae.getSource()==b2)
			 				 {
								try
								{
									
								F3.setVisible(false);	
								Step2 s2=new Step2();


								}

								catch(Exception e)
								{
									System.out.println(e);		
								}

							}
				}


public static void main(String args[])
	{
		new Menu3();
		
	}
	
}

