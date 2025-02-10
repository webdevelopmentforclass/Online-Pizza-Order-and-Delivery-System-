
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Step32 extends JFrame implements ActionListener,ItemListener,KeyListener
{


		JFrame F4 = new JFrame("Pizza Hut");	
	
		Label l9,l10,l11;
		Checkbox c[]=new Checkbox[13];
		Label t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27;
		TextField t[]=new TextField[13];//1,t2,t3,t4,t5,t6,t7,t8;
		Button b2,b3,b4,b5;
		JTextArea aInfo = new JTextArea(10, 20);
		Connection con;
		PreparedStatement pstmt,pstmt2,pstmt3;
		
			String abc=new String();		
	
			String order_name[]={" ","Pahadi Pizza","Cheese Pizza","Exotica","Country Special","Paneer Vegorama","Delux Vegiee","Vegiee Lover","Spice verloaded"};
			double cost[]={0,195,200,220,225,165,180,185,250};
			String total_order=new String();
			double total_cost=0;
			int i=0,Rest_id=0,Cust_id=0;
			int cnt[]={0,0,0,0,0,0,0,0,0,0,0,0,0};

		Step32(int rs,int ci)
				{
					F4.setSize(1400,1000);
					F4.setLayout(null);
					F4.setVisible(true);
					F4.setForeground(Color.cyan);

					Rest_id=rs;
					Cust_id=ci;
				
					l9=new Label("WELCOME To Pizza Hut...!!!!");
					Font f1=new Font("PRISTINA",Font.BOLD,30);
					l9.setBounds(250,80,850,30);
					l9.setFont(f1);
					l9.setForeground(Color.white);
					F4.add(l9);
					
					l10=new Label("\" VEG CORNER\" ");
					Font f3=new Font("PRISTINA",Font.BOLD,25);
					l10.setBounds(325,160,250,30);
					l10.setFont(f3);
					F4.add(l10);

					Font f5=new Font("PRISTINA",Font.BOLD,20);

					c[1]=new Checkbox("Pahadi Pizza");
					c[1].setBounds(50,225,250,40); 
					c[1].setFont(f5) ; 
					F4.add(c[1]);
					c[1].addItemListener(this);

					t16=new Label("Rs.195");
					Font f2=new Font("PRISTINA",Font.BOLD,15);
					t16.setBounds(300,230,80,30);
					t16.setFont(f2);
					F4.add(t16);
					
					t[1]=new TextField("");
					t[1].setBounds(400,230, 50,20);
					t[1].addKeyListener(this);  
					//F4.add(t1);
					
					c[2]=new Checkbox("Cheese Pizza");
					c[2].setBounds(50,325, 250,40); 
					c[2].setFont(f5) ; 
					F4.add(c[2]);
					c[2].addItemListener(this);

					t17=new Label("Rs.200");
					t17.setBounds(300,330,80,30);
					t17.setFont(f2);
					F4.add(t17);

					t[2]=new TextField("");
					t[2].setBounds(400,330, 50,20);  
					t[2].addKeyListener(this);  
//F4.add(t2);

					c[3]=new Checkbox("Exotica");
					c[3].setBounds(50,425, 250,40);
					c[3].setFont(f5) ;  
					F4.add(c[3]);
					c[3].addItemListener(this);

					t18=new Label("Rs.220");
					t18.setBounds(300,430,80,30);
					t18.setFont(f2);
					F4.add(t18);

					t[3]=new TextField("");
					t[3].setBounds(400,430, 50,20);  
					t[3].addKeyListener(this);
					//F4.add(t3);


					c[4]=new Checkbox("Country Special");
					c[4].setBounds(50,525, 250,40); 
					c[4].setFont(f5) ; 
					F4.add(c[4]);
					c[4].addItemListener(this);

					t19=new Label("Rs.225");
					t19.setBounds(300,530,80,30);
					t19.setFont(f2);
					F4.add(t19);


					t[4]=new TextField("");
					t[4].setBounds(400,530, 50,20);
					t[4].addKeyListener(this);    
					//F4.add(t4);

					c[5]=new Checkbox("Paneer Vegorama");
					c[5].setBounds(550,225, 250,40);
					c[5].setFont(f5) ;  
					F4.add(c[5]);
					c[5].addItemListener(this);

					t20=new Label("Rs.165");
					t20.setBounds(800,230,80,30);
					t20.setFont(f2);
					F4.add(t20);
					
					t[5]=new TextField("");
					t[5].setBounds(900,230, 50,20);
					t[5].addKeyListener(this);    
					//F4.add(t5);

					c[6]=new Checkbox("Delux Vegiee");
					c[6].setBounds(550,325, 250,40); 
					c[6].setFont(f5) ; 
					F4.add(c[6]);
					c[6].addItemListener(this);


					t21=new Label("Rs.180");
					t21.setBounds(800,330,80,30);
					t21.setFont(f2);
					F4.add(t21);
					
					t[6]=new TextField("");
					t[6].setBounds(900,330, 50,20);
					t[6].addKeyListener(this);  
					//F4.add(t6);

					c[7]=new Checkbox("Veggie Lover");
					c[7].setBounds(550,425,250,40); 
					c[7].setFont(f5) ; 
					F4.add(c[7]);
					c[7].addItemListener(this);

					t22=new Label("Rs.185");
					t22.setBounds(800,430,80,30);
					t22.setFont(f2);
					F4.add(t22);

					t[7]=new TextField("");
					t[7].setBounds(900,430, 50,20);
					t[7].addKeyListener(this);  
					//F4.add(t7);

					c[8]=new Checkbox("Spice Overloaded");
					c[8].setBounds(550,525, 250,40); 
					c[8].setFont(f5) ; 
					F4.add(c[8]);
					c[8].addItemListener(this);

					t23=new Label("Rs.250");
					t23.setBounds(800,530,80,30);
					t23.setFont(f2);
					F4.add(t23);

					t[8]=new TextField("");
					t[8].setBounds(900,530, 50,20); 
					t[8].addKeyListener(this);  
					//F4.add(t8);
						

					b3=new Button("ORDER");		
					b3.setBounds(750,650,150,40);
					Font f4=new Font("PRISTINA",Font.BOLD,20);
					b3.setFont(f4);
					b3.setBackground(Color.darkGray);							
					b3.setForeground(Color.white);
					F4.add(b3);
					b3.addActionListener(this);	



					b2=new Button("CANCEL ORDER");		
					b2.setBounds(200,650,200,40);
					b2.setFont(f4);
					b2.setBackground(Color.darkGray);							
					b2.setForeground(Color.white);
					F4.add(b2);
					b2.addActionListener(this);
					
					b5=new Button("RESET");		
					b5.setBounds(500,650,200,40);
					b5.setFont(f4);
					b5.setBackground(Color.darkGray);							
					b5.setForeground(Color.white);
					F4.add(b5);
					b5.addActionListener(this);


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
																		
									System.out.println("You selected: "+order_name[i]+" with cost"+cost[i]);
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
											F4.add(t[i]);

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
											F4.remove(t[i]);																
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
					
				
							if(ae.getSource()==b3)
			 				 {
								try
								{
								
							for(i=1;i<9;i++)
									{
										if(cnt[i]==0)
										continue;
									
										 pstmt =con.prepareStatement("insert into Pizza_Hut(cust_id,order_name,quantity,bill,total_amount) values(?,?,?,?,?)");
								
							
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

							F4.setVisible(false);		
						       Bill2 b=new Bill2(Cust_id);

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
							
							 pstmt3 =con.prepareStatement("delete from cust_details where cust_id=? ");	
							 pstmt2 =con.prepareStatement("delete from Pizza_Hut where cust_id=? ");

							

							pstmt2.setInt(1,Cust_id);
							pstmt3.setInt(1,Cust_id);
							
							pstmt2.executeUpdate();
							pstmt3.executeUpdate();
							

								F4.setVisible(false);
								Step1 st=new Step1();
								}

								catch(Exception e)
								{
									System.out.println(e);		
								}



							}


							else if(ae.getSource()==b5)
			 				 {
								try
								{
									
								for(i=1;i<9;i++)
								{
									c[i].setState(false);
									F4.remove(t[i]);
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
		new Step32(1,1);
	
	}	
	
}
