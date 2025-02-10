
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Step33 extends JFrame implements ActionListener,ItemListener,KeyListener
{


		JFrame F5 = new JFrame("Pizza House");	
	
		Label l12,l13,l14,l15;
		Checkbox c[]=new Checkbox[13];
		Label t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39;
		TextField t[]=new TextField[13];//1,t2,t3,t4,t5,t6,t7,t8;
		Button b2,b5,b6,b7;
		JTextArea aInfo = new JTextArea(10, 20);
		Connection con;
		PreparedStatement pstmt,pstmt2,pstmt3;
		
			String order_name[]={" ","Toasted Pizza","Desert Pizza","Pizza Romana","Pizza Maninora","Chicken Spicy","Kheema Masala","Double Trouble","Ultimate Chicken"};
			double cost[]={0,160,180,200,200,220,285,250,220};
			String total_order=new String();
			double total_cost=0;
			int i=0,Rest_id=0,Cust_id=0;
			int cnt[]={0,0,0,0,0,0,0,0,0,0,0,0,0};
			String abc=new String();

		Step33(int rs,int ci)
				{
					F5.setSize(1400,1000);
					F5.setLayout(null);
					F5.setVisible(true);
					F5.setForeground(Color.cyan);

					Rest_id=rs;
					Cust_id=ci;					
			

					l12=new Label("WELCOME To Pizza House...!!!!");
					Font f1=new Font("PRISTINA",Font.BOLD,30);
					l12.setBounds(250,80,850,30);
					l12.setFont(f1);
					l12.setForeground(Color.white);
					F5.add(l12);
					


					l13=new Label("\" VEG \" ");
					Font f3=new Font("PRISTINA",Font.BOLD,25);
					l13.setBounds(325,130,250,30);
					l13.setFont(f3);
					F5.add(l13);

					Font f5=new Font("PRISTINA",Font.BOLD,20);

					c[1]=new Checkbox("Toasted Pizza");
					c[1].setBounds(50,225, 250,40); 
					c[1].setFont(f5) ; 
					F5.add(c[1]);
					c[1].addItemListener(this);

					t28=new Label("Rs.160");
					Font f2=new Font("PRISTINA",Font.BOLD,15);
					t28.setBounds(300,230,80,30);
					t28.setFont(f2);
					F5.add(t28);
					
					t[1]=new TextField("");
					t[1].setBounds(400,230, 50,20);  
					t[1].addKeyListener(this);
					//F5.add(t1);
					
					c[2]=new Checkbox("Onion Desert Pizza");
					c[2].setBounds(50,325, 250,40); 
					c[2].setFont(f5) ; 
					F5.add(c[2]);
					c[2].addItemListener(this);

					t29=new Label("Rs.180");
					t29.setBounds(300,330,80,30);
					t29.setFont(f2);
					F5.add(t29);

					t[2]=new TextField("");
					t[2].setBounds(400,330, 50,20);  
					t[2].addKeyListener(this); 
					t[2].addKeyListener(this);   
					//F5.add(t2);


					c[3]=new Checkbox("Pizza Romana");
					c[3].setBounds(50,425,250,40);
					c[3].setFont(f5) ;  
					F5.add(c[3]);
					c[3].addItemListener(this);

					t30=new Label("Rs.200");
					t30.setBounds(300,430,80,30);
					t30.setFont(f2);
					F5.add(t30);

					t[3]=new TextField("");
					t[3].setBounds(400,430, 50,20);
					t[3].addKeyListener(this);  
					//F5.add(t3);


					c[4]=new Checkbox("Pizza Marinora");
					c[4].setBounds(50,525, 250,40); 
					c[4].setFont(f5) ; 
					F5.add(c[4]);
					c[4].addItemListener(this);

					t31=new Label("Rs.200");
					t31.setBounds(300,530,80,30);
					t31.setFont(f2);
					F5.add(t31);

					t[4]=new TextField("");
					t[4].setBounds(400,530, 50,20); 
					t[4].addKeyListener(this);   
					//F5.add(t4);

					l15=new Label("\"NON-VEG \"");
					l15.setBounds(575,130,400,30);
					l15.setFont(f3);
					F5.add(l15);
								
								
					c[5]=new Checkbox("Chicken Spicy");
					c[5].setBounds(550,225, 250,40);  
					c[5].setFont(f5) ;
					F5.add(c[5]);
					c[5].addItemListener(this);

					t32=new Label("Rs. 220");
					t32.setBounds(800,230,80,30);
					t32.setFont(f2);
					F5.add(t32);
					
					t[5]=new TextField("");
					t[5].setBounds(900,230, 50,20);
					t[5].addKeyListener(this);    
					//F[5].add(t5);

					c[6]=new Checkbox("Kheema Masala");
					c[6].setBounds(550,325, 250,40);  
					c[6].setFont(f5) ;
					F5.add(c[6]);
					c[6].addItemListener(this);


					t33=new Label("Rs.285");
					t33.setBounds(800,330,80,30);
					t33.setFont(f2);
					F5.add(t33);

					t[6]=new TextField("");
					t[6].setBounds(900,330, 50,20); 
					t[6].addKeyListener(this);  
					//F5.add(t6);

					c[7]=new Checkbox("Double Trouble");
					c[7].setBounds(550,425, 250,40);
					c[7].setFont(f5) ;  
					F5.add(c[7]);
					c[7].addItemListener(this);

					t34=new Label("Rs.250");
					t34.setBounds(800,430,80,30);
					t34.setFont(f2);
					F5.add(t34);

					t[7]=new TextField("");
					t[7].setBounds(900,430, 50,20);  
					//F5.add(t7);

					c[8]=new Checkbox("Ultimate Chicken");
					c[8].setBounds(550,525, 250,40);  
					c[8].setFont(f5) ;
					F5.add(c[8]);
					c[8].addItemListener(this);

					t35=new Label("Rs.220");
					t35.setBounds(800,530,80,30);
					t35.setFont(f2);
					F5.add(t35);

					t[8]=new TextField("");
					t[8].setBounds(900,530, 50,20);
					t[8].addKeyListener(this);   
					//F5.add(t8);
						

					b5=new Button("ORDER");		
					b5.setBounds(750,700,150,40);
					Font f6=new Font("PRISTINA",Font.BOLD,20);
					b5.setFont(f6);
					b5.setBackground(Color.darkGray);							
					b5.setForeground(Color.white);
					F5.add(b5);
					b5.addActionListener(this);	


					b2=new Button("CANCEL ORDER");		
					b2.setBounds(200,700,200,40);
					b2.setFont(f6);
					b2.setBackground(Color.darkGray);							
					b2.setForeground(Color.white);
					F5.add(b2);
					b2.addActionListener(this);
					
				
					b7=new Button("RESET");		
					b7.setBounds(500,700,200,40);
					b7.setFont(f6);
					b7.setBackground(Color.darkGray);							
					b7.setForeground(Color.white);
					F5.add(b7);
					b7.addActionListener(this);

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
											F5.add(t[i]);

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
											F5.remove(t[i]);																
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
					
				
							if(ae.getSource()==b5)
			 				 {
								try
								{
									
									


						
							for(i=1;i<9;i++)
									{
										if(cnt[i]==0)
										continue;
											

										 pstmt =con.prepareStatement("insert into Pizza_House(cust_id,order_name,quantity,bill,total_amount) values(?,?,?,?,?)");
								
							
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

							F5.setVisible(false);		
						       Bill3 b=new Bill3(Cust_id);

							
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
							 pstmt2 =con.prepareStatement("delete from Pizza_House where cust_id=? ");

							

							pstmt2.setInt(1,Cust_id);
							pstmt3.setInt(1,Cust_id);
							
							pstmt2.executeUpdate();
							pstmt3.executeUpdate();
							
							

								F5.setVisible(false);
								Step1 st=new Step1();
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
									
								for(i=1;i<9;i++)
								{
									c[i].setState(false);
									F5.remove(t[i]);
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
		new Step33(1,1);
		
			
	}
	
}
