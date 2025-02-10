
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Step34 extends JFrame implements ActionListener,ItemListener,KeyListener
{


		JFrame F6 = new JFrame("Dominose");	
	
		Label l12,l13,l14,l15;
		Checkbox c[]=new Checkbox[13];
		Label t40,t41,t42,t43,t44,t45,t46,t47,t48,t49,t50,t51;
		TextField t[]=new TextField[13];//1,t2,t3,t4,t5,t6,t7,t8;
		
		
		Button b2,b7,b8,b9;
		JTextArea aInfo = new JTextArea(10, 20);
		Connection con;
		PreparedStatement pstmt,pstmt2,pstmt3;
		
			
			String order_name[]={" ","Cheese Crush","Onion Magic","Corn Magic Solo","Green Capsicum","Chicken Hot & Spicy","Chicken Kheema","Corn Chicken","Mutton Masala"};
			
			
			double cost[]={0,215,185,195,180,315,200,225,350};
			String total_order=new String();
			double total_cost=0;
			int i=0,Rest_id=0,Cust_id=0;
			int cnt[]={0,0,0,0,0,0,0,0,0,0,0,0,0};
			String abc=new String();

		Step34(int rs,int ci)
				{
					F6.setSize(1400,1000);
					F6.setLayout(null);
					F6.setVisible(true);
					F6.setForeground(Color.cyan);

					Rest_id=rs;
					Cust_id=ci;
				
					l12=new Label("WELCOME To Dominose...!!!!");
					Font f1=new Font("PRISTINA",Font.BOLD,30);
					l12.setBounds(250,80,850,30);
					l12.setFont(f1);
					l12.setForeground(Color.white);
					F6.add(l12);
					


					l13=new Label("\" VEG SPECIAL\" ");
					Font f3=new Font("PRISTINA",Font.BOLD,25);
					l13.setBounds(325,130,250,30);
					l13.setFont(f3);
					F6.add(l13);

					Font f5=new Font("PRISTINA",Font.BOLD,20);

					c[1]=new Checkbox("Cheese Crush");
					c[1].setBounds(30,225,250,40);
					c[1].setFont(f5) ; 
					F6.add(c[1]);
					c[1].addItemListener(this);

					t40=new Label("Rs.215");
					Font f2=new Font("PRISTINA",Font.BOLD,15);
					t40.setBounds(250,230,60,30);
					t40.setFont(f2);
					F6.add(t40);

					t[1]=new TextField("");
					t[1].setBounds(325,230, 50,30); 
					t[1].addKeyListener(this); 
					//F6.add(t1);
					
					
					c[2]=new Checkbox("Onion Magic");
					c[2].setBounds(30,325, 250,40); 
					c[2].setFont(f5) ; 
					F6.add(c[2]);
					c[2].addItemListener(this);

					t41=new Label("Rs.185");
					t41.setBounds(250,330,60,30);
					t41.setFont(f2);
					F6.add(t41);

					t[2]=new TextField("");
					t[2].setBounds(325,330, 50,30);  
					t[2].addKeyListener(this);  
					//F6.add(t2);


					c[3]=new Checkbox("Corn Magic Solo");
					c[3].setBounds(30,425, 250,40);
					c[3].setFont(f5) ;  
					F6.add(c[3]);
					c[3].addItemListener(this);

					t42=new Label("Rs.195");
					t42.setBounds(250,430,60,30);
					t42.setFont(f2);
					F6.add(t42);

					t[3]=new TextField("");
					t[3].setBounds(325,430, 50,30);
					t[3].addKeyListener(this);  
					//F6.add(t3);

					c[4]=new Checkbox("Green Capsicum");
					c[4].setBounds(30,525,250,40);
					c[4].setFont(f5) ;  
					F6.add(c[4]);
					c[4].addItemListener(this);

					t43=new Label("Rs.180");
					t43.setBounds(250,530,60,30);
					t43.setFont(f2);
					F6.add(t43);

					t[4]=new TextField("");
					t[4].setBounds(325,530, 50,30); 
					t[4].addKeyListener(this);   
					//F6.add(t4);


					l15=new Label("\"NON-VEG SPECIAL\"");
					l15.setBounds(575,130,400,30);
					l15.setFont(f3);
					F6.add(l15);
								
								
					c[5]=new Checkbox("Chicken Hot & Spicy");
					c[5].setBounds(525,225, 250,40);  
					c[5].setFont(f5) ;					
					F6.add(c[5]);
					c[5].addItemListener(this);

					t44=new Label("Rs.315");
					t44.setBounds(750,230,80,30);
					t44.setFont(f2);
					F6.add(t44);
					
					t[5]=new TextField("");
					t[5].setBounds(850,230, 50,30); 
					t[5].addKeyListener(this);   
					//F6.add(t5);
					
					c[6]=new Checkbox("Chicken Kheema");
					c[6].setBounds(525,325,250,40);
					c[6].setFont(f5) ;  
					F6.add(c[6]);
					c[6].addItemListener(this);


					t45=new Label("Rs.200");
					t45.setBounds(750,330,80,30);
					t45.setFont(f2);
					F6.add(t45);

					t[6]=new TextField("");
					t[6].setBounds(850,330, 50,30);
					t[6].addKeyListener(this);   
					//F6.add(t6);

					c[7]=new Checkbox("Corn Chicken");
					c[7].setBounds(525,425, 250,40);
					c[7].setFont(f5) ;  
					F6.add(c[7]);
					c[7].addItemListener(this);

					t46=new Label("Rs.225");
					t46.setBounds(750,430,80,30);
					t46.setFont(f2);
					F6.add(t46);


					t[7]=new TextField("");
					t[7].setBounds(850,430, 50,30); 
					t[7].addKeyListener(this); 
					//F6.add(t7);

					c[8]=new Checkbox("Mutton Masala");
					c[8].setBounds(525,525, 250,40); 
					c[8].setFont(f5) ; 
					F6.add(c[8]);
					c[8].addItemListener(this);

					t47=new Label("Rs.350");
					t47.setBounds(750,530,80,30);
					t47.setFont(f2);
					F6.add(t47);

					t[8]=new TextField("");
					t[8].setBounds(850,530, 50,30);
					t[8].addKeyListener(this);   
					//F6.add(t8);
						

					b7=new Button("ORDER");		
					b7.setBounds(750,650,150,40);
					Font f6=new Font("PRISTINA",Font.BOLD,20);
					b7.setFont(f6);
					b7.setBackground(Color.darkGray);							
					b7.setForeground(Color.white);
					F6.add(b7);
					b7.addActionListener(this);	

					b2=new Button("CANCEL ORDER");		
					b2.setBounds(200,650,200,40);
					b2.setFont(f6);
					b2.setBackground(Color.darkGray);							
					b2.setForeground(Color.white);
					F6.add(b2);
					b2.addActionListener(this);
					

					b9=new Button("RESET");		
					b9.setBounds(500,650,200,40);
					b9.setFont(f6);
					b9.setBackground(Color.darkGray);							
					b9.setForeground(Color.white);
					F6.add(b9);
					b9.addActionListener(this);

						try
				{

						Class.forName("com.mysql.cj.jdbc.Driver");
	  					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/harshda","root","1234");
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
											F6.add(t[i]);

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
											F6.remove(t[i]);																
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
					
				
							if(ae.getSource()==b7)
			 				 {
								try
								{


							for(i=1;i<9;i++)
									{
										if(cnt[i]==0)
													continue;
										 pstmt =con.prepareStatement("insert into Dominose(cust_id,order_name,quantity,bill,total_amount) values(?,?,?,?,?)");
								
							
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

							
			
	
							

							F6.setVisible(false);		
						     	Bill4 b=new Bill4(Cust_id);

					


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
							 pstmt2 =con.prepareStatement("delete from Dominose where cust_id=? ");

							

							pstmt2.setInt(1,Cust_id);
							pstmt3.setInt(1,Cust_id);
							
							pstmt2.executeUpdate();
							pstmt3.executeUpdate();	
							
								F6.setVisible(false);
								Step1 st=new Step1();
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
									
								for(i=1;i<9;i++)
								{
									c[i].setState(false);
									F6.remove(t[i]);
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
		new Step34(1,1										);
		
	}
	
}
