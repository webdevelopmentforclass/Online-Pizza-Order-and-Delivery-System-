import java.util.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Step31 extends JFrame implements ActionListener,ItemListener,KeyListener
{

		JFrame F3 = new JFrame("Pick A Pizza");

		Label l5,l6,l7,l8;
		Checkbox c[]=new Checkbox[13];
		Label t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
		TextField t[]=new TextField[13];//1,t22,t33,t44,t55,t66,t77,t88;
		Button b1,b2,b3;
		Connection con;
		PreparedStatement pstmt,pstmt2,pstmt3;
			

			String order_name[]={"null ", "Veggie Paradie","Farm House","Peppy Panner","Mexicn Green Wave","Chicken Tikka","Non-Veg Supreme","Chicken Pepperoni","Peri Peri Chicken"};

			double cost[]={0,180,200,180,220,280,300,285,250};
			String total_order=new String();
			double total_cost=0;
			int i=0,Rest_id=0,Cust_id=0;
			int cnt[]={0,0,0,0,0,0,0,0,0};

			String abc=new String();


			Step31(int rs,int ci)
				{
					
					F3.setSize(1400,1000);
					F3.setLayout(null);
					F3.setVisible(true);
					F3.setForeground(Color.cyan);
				
					Rest_id=rs;
					Cust_id=ci;
					
					l5=new Label("WELCOME To Pick_A_Pizza...!!!!");
					Font f1=new Font("PRISTINA",Font.BOLD,30);
					l5.setBounds(250,80,550,30);
					l5.setFont(f1);
					l5.setBackground(Color.red);
					l5.setForeground(Color.black);
					F3.add(l5);
					

					l6=new Label("\"VEG LOVERS\" ");
					Font f3=new Font("PRISTINA",Font.BOLD,25);
					l6.setBounds(75,160,200,30);
					l6.setFont(f3);
					F3.add(l6);

					Font f5=new Font("PRISTINA",Font.BOLD,20);

					c[1]=new Checkbox("Veggie Paradie");
					c[1].setBounds(50,225, 250,40);
					c[1].setFont(f5) ; 
					F3.add(c[1]);
					c[1].addItemListener(this);
					
					t4=new Label("Rs.180");
					Font f2=new Font("PRISTINA",Font.BOLD,15);
					t4.setBounds(300,230,80,30);
					t4.setFont(f2);
					F3.add(t4);
					
					t[1]=new TextField();
					t[1].setBounds(400,230, 50,20);
					t[1].addKeyListener(this);  
					//F3.add(t[1]);					

					c[2]=new Checkbox("Farm House");
					c[2].setBounds(50,325, 250,40); 
					c[2].setFont(f5) ;  
					F3.add(c[2]);
					c[2].addItemListener(this);

					t5=new Label("Rs.200");
					t5.setBounds(300,330,80,30);
					t5.setFont(f2);
					F3.add(t5);

					t[2]=new TextField();
					t[2].setBounds(400,330, 50,20);
					t[2].addKeyListener(this);  
					//F3.add(t[2]);

					c[3]=new Checkbox("Peppy Paneer");
					c[3].setBounds(50,425, 250,40); 
					c[3].setFont(f5) ;  
					F3.add(c[3]);
					c[3].addItemListener(this);

					t6=new Label("Rs.180");
					t6.setBounds(300,430,80,30);
					t6.setFont(f2);
					F3.add(t6);

					t[3]=new TextField();
					t[3].setBounds(400,430, 50,20); 
					t[3].addKeyListener(this); 
					//F3.add(t[3]);


					c[4]=new Checkbox("Maxican-Green Wave");
					c[4].setBounds(50,525, 250,40); 
					c[4].setFont(f5) ;  
					F3.add(c[4]);
					c[4].addItemListener(this);

					t7=new Label("Rs.220");
					t7.setBounds(300,530,80,30);
					t7.setFont(f2);
					F3.add(t7);

					t[4]=new TextField();
					t[4].setBounds(400,530, 50,20);
					t[4].addKeyListener(this);  
					//F3.add(t[4]);


					l7=new Label("\"NON-VEG LOVERS\"");
					l7.setBounds(575,160,400,30);
					l7.setFont(f3);
					//F3.add(l7);


					c[5]=new Checkbox("Chicken Tikka");
					c[5].setBounds(550,225, 250,40); 
					c[5].setFont(f5) ;  
					F3.add(c[5]);
					c[5].addItemListener(this);					

					t8=new Label("Rs.280");
					t8.setBounds(800,230,80,30);
					t8.setFont(f2);
					F3.add(t8);
					
					t[5]=new TextField();
					t[5].setBounds(900,230, 50,20);
					t[5].addKeyListener(this);  
					//F3.add(t[5]);

					c[6]=new Checkbox("Non-Veg Supreme");
					c[6].setBounds(550,325, 250,40);
					c[6].setFont(f5) ;   
					F3.add(c[6]);
					c[6].addItemListener(this);

					t9=new Label("Rs.300");
					t9.setBounds(800,330,80,30);
					t9.setFont(f2);
					F3.add(t9);

					t[6]=new TextField();
					t[6].setBounds(900,330, 50,20); 
					t[6].addKeyListener(this); 
					//F3.add(t[6]);

					c[7]=new Checkbox("Chicken Pepperoni");
					c[7].setBounds(550,425, 250,40);  
					c[7].setFont(f5) ; 
					F3.add(c[7]);
					c[7].addItemListener(this);

					t10=new Label("Rs.285");
					t10.setBounds(800,430,80,30);
					t10.setFont(f2);
					F3.add(t10);

					t[7]=new TextField();
					t[7].setBounds(900,430, 50,20);
					t[7].addKeyListener(this);  
					//F3.add(t[7]);

					c[8]=new Checkbox("Periperi Chicken");
					c[8].setBounds(550,525, 250,40); 
					c[8].setFont(f5) ;  
					F3.add(c[8]);
					c[8].addItemListener(this);

					t11=new Label("Rs.250");
					t11.setBounds(800,530,80,30);
					t11.setFont(f2);
					F3.add(t11);

					t[8]=new TextField();
					t[8].setBounds(900,530, 50,20); 
					t[8].addKeyListener(this); 
					//F3.add(t[8]);
						

					b1=new Button("CONFORM ORDER");		
					b1.setBounds(750,650,150,40);
					Font f4=new Font("PRISTINA",Font.BOLD,20);
					b1.setFont(f4);
					b1.setBackground(Color.darkGray);							
					b1.setForeground(Color.white);
					F3.add(b1);
					b1.addActionListener(this);	

					b2=new Button("CANCEL ORDER");		
					b2.setBounds(200,650,200,40);
					b2.setFont(f4);
					b2.setBackground(Color.darkGray);							
					b2.setForeground(Color.white);
					F3.add(b2);
					b2.addActionListener(this);
					
					b3=new Button("RESET");		
					b3.setBounds(500,650,150,40);
					b3.setFont(f4);
					b3.setBackground(Color.darkGray);							
					b3.setForeground(Color.white);
					F3.add(b3);
					b3.addActionListener(this);



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
				
				
				
				
			
				public void itemStateChanged(ItemEvent ie)
				{

						for(i=1;i<9;i++)
						{

							if(ie.getSource()==c[i])
									{
			 				 
										if(c[i].getState())
										{
											try
											{
									
											System.out.println("You selected: "+order_name[i]+" with cost  Rs."+cost[i]);
											cnt[i]=1;
											
											}
					

											catch(Exception e)
											{
											System.out.println(e);		
											}
								
									
										}

										

								}
							}


						for(i=1;i<9;i++)

							{
									 
							if(ie.getSource()==c[i])
								{
									if(c[i].getState()==false)
										{
											try
											{
									
											System.out.println("You canceled: "+order_name[i]+" with cost  Rs."+cost[i]);
											cnt[i]=0;
											}								

											catch(Exception e)
											{
											System.out.println(e);		
											}

										}
								}
								
							}


						for(i=1;i<9;i++)
						{

							if(ie.getSource()==c[i])
									{
			 				 
										if(c[i].getState())
										{
											try
											{
									
											if(cnt[i]==1)
											{
											F3.add(t[i]);

											}
											}
					

											catch(Exception e)
											{
											System.out.println(e);		
											}
								
									
										}

										if(c[i].getState()==false)

										{
											try{
											F3.remove(t[i]);																
											   }

											catch(Exception e)
											{
											System.out.println(e);		
											}

											

										}

										

								}


						}

							

							
							
					
				}


				public void  keyTyped(KeyEvent ke)
					{

						char c=ke.getKeyChar();
						if(!(Character.isDigit(c)))
						{
				
							//ke.consume();
							JOptionPane.showMessageDialog(null,"Please enter proper value");
						}
					}

				public void keyPressed(KeyEvent ke){}
	
				public void keyReleased(KeyEvent ke){}



				public void actionPerformed(ActionEvent ae)
					{
						if(ae.getSource()==b1)
			 				{
								try
								{	

						
							for(i=1;i<9;i++)
								{
									if(cnt[i]==0)
									continue;
							
									 pstmt =con.prepareStatement("insert into Pick_A_Pizza(cust_id,order_name,quantity,bill,total_amount) values(?,?,?,?,?)");
								
							
									pstmt.setInt(1,Cust_id);
										
									pstmt.setString(2,order_name[i]);
									int q=1;
									String a=t[i].getText();

									if(a.isEmpty())
									{
									pstmt.setInt(3,q);
									}
									else
									{
									q=Integer.parseInt(t[i].getText());
									pstmt.setInt(3,q);
							
									}

									pstmt.setDouble(4,cost[i]);
						
									double tb=cost[i]*q;
									pstmt.setDouble(5,tb);

							
									pstmt.executeUpdate();


							}

	
						
	
								F3.setVisible(false);		
						    		   Bill1 se=new Bill1(Cust_id);

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
									
								
							 pstmt2 =con.prepareStatement("delete from cust_details where cust_id=? ");
							pstmt3 =con.prepareStatement("delete from Pick_A_Pizza where cust_id=? ");

							

							pstmt2.setInt(1,Cust_id);
							pstmt3.setInt(1,Cust_id);
							pstmt2.executeUpdate();
							pstmt3.executeUpdate();
							

								F3.setVisible(false);
								Step1 st=new Step1();
								}

								catch(Exception e)
								{
									System.out.println(e);		
								}



							}


						

						if(ae.getSource()==b3)
			 				 {
								try
								{
									
								for(i=1;i<9;i++)
								{
									c[i].setState(false);
									F3.remove(t[i]);
									
								}


								}

								catch(Exception e)
								{
									System.out.println(e);		
								}



							}
				}


public static void main(String args[])
	{
		new Step31(1,1);
		
	}
	
}

