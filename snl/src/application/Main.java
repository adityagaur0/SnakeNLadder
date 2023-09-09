package application;
	
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.*;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.effect.Glow;



public class Main extends Application
{
	public int random;
	
	public Glow glow = new Glow(0.7);
	public Glow glow2 = new Glow(0.0);
	
	public static int Box = 50;
	public static int bre = 10;
	public static int len = 10;
	
	public Button gamebutton;
	public Label Result;
	
	public int c = 1;
	
	public int o1 = 0;
	public int o2 = 0;
	
	public int p1 = 1;
	public int p2 = 1;
	
	public int p1t = p1;
	public int p2t = p2;
	
	public Circle player1;
	public Circle player2;
	
	public int playerPosition1 = 1;
	public int playerPosition2 = 1;
	
	public boolean player1Turn = true;
	public boolean player2Turn = true;
	
	public static int p1x = 25;
	public static int p1y = 525;
	
	public static int p2x = 25;
	public static int p2y = 525;
	
	public static int p1temp = p1x;
	public static int p1ytemp = p1y;
	
	public static int p2temp = p2x;
	public static int p2ytemp = p2y;
	
	public boolean gamestart = false;
	
	private Group group = new Group();
	
	public static ImageView dice;
	public static ImageView arrow;
	
	public Button b1;
	public Button b2;
	
	private Parent create()
	{
		Pane root = new Pane();
		root.setPrefSize(bre*Box, (len*Box) + 200 );
		
		root.getChildren().addAll(group);
		
		for(int i=0; i<len; i++)
		{
			for(int j=0; j<bre; j++)
			{
				Boxes bb = new Boxes(Box,Box);
				bb.setTranslateX(j*Box);
				bb.setTranslateY(i*Box);
				
				group.getChildren().add(bb);
				
			}
		}
		
		player1 = new Circle(20);
		player2 = new Circle(20);
		
		player1.setId("Player 1");
		player1.getStyleClass().add("style.css");
		player1.setTranslateX(p1x);
		player1.setTranslateY(p1y);
		player1.setFill(Color.BLUE);
		
		player2.setId("Player 2");
		player2.getStyleClass().add("style.css");
		player2.setTranslateX(p2x);
		player2.setTranslateY(p2y);
		player2.setFill(Color.BLUEVIOLET);
		
		b1 = new Button("Player 1");
		b2 = new Button("Player 2");
		
		
		b1.setTranslateX(25);
		b1.setTranslateY(650);
		b1.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event)
			{
				
				if(o1 == 0 && gamestart != false && player1Turn != false)
				{
					random = Diceroll.get_diceroll();
					Result.setText("Dice : " + String.valueOf(random));
					
					try 
					{
						Diceroll.timer(random);
					} 
					
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(random == 1)
					{
						p1x = 25;
						p1y = 475;
						p1 = 1;
						
						player1.setTranslateX(p1x);
						player1.setTranslateY(p1y);
						movePlayer(p1x,p1y,player1);
						
						o1 = 1;
					}
					
					player1Turn = false;
					player2Turn = true;
					
					b1.setEffect(glow);
					b2.setEffect(glow2);
					
					//arrow.setRotate(270);
					arrow.setX(432);
					arrow.setY(580);
				}
				
				if(gamestart != false)
				{
					if(player1Turn != false && o1 == 1)
					{
						int flag = 1;
						
						random = Diceroll.get_diceroll();
						Result.setText("Dice : " + String.valueOf(random));
						
						try 
						{
							Diceroll.timer(random);
						} 
						
						catch (InterruptedException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(p1 == 1 && random == 2 && p1x == 25)
						{
							p1x = 25;
							p1y = 375;
							p1 = 3;
							movePlayer(p1x,p1y,player1);
							player1Turn = false;
							player2Turn = true;
							//System.out.print("inside");
							flag = 0;
							
							b1.setEffect(glow);
							b2.setEffect(glow2);
							
							//arrow.setRotate(270);
							arrow.setX(432);
							arrow.setY(580);
						}
						
						if(p1 == 1 && random == 1 && p1x == 75)
						{
							p1x = 25;
							p1y = 375;
							p1 = 3;
							movePlayer(p1x,p1y,player1);
							player1Turn = false;
							player2Turn = true;
							//System.out.print("inside");
							flag = 0;
							
							b1.setEffect(glow);
							b2.setEffect(glow2);
							
							//arrow.setRotate(270);
							arrow.setX(432);
							arrow.setY(580);
						}
						
						if(flag == 1)
						{
							m1();
							if(p1x>0 && p1y>0)
							{
								movePlayer(p1x,p1y,player1);
								//System.out.println(p1x + " " + p1y);
								player1Turn = false;
								player2Turn = true;
								
								b1.setEffect(glow);
								b2.setEffect(glow2);
								
								//arrow.setRotate(270);
								arrow.setX(432);
								arrow.setY(580);
							}	
							
							else
							{
								p1x = p1temp;
								p1y = p1ytemp;
								p1 = p1t;
								player1Turn = false;
								player2Turn = true;
								
								b1.setEffect(glow);
								b2.setEffect(glow2);
								
								//arrow.setRotate(270);
								arrow.setX(432);
								arrow.setY(580);
							}
						}
					}
				}
			}
		});
		
		
		b2.setTranslateX(425);
		b2.setTranslateY(650);
		b2.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) 
			{
				if(o2 == 0 && gamestart != false && player2Turn != false)
				{
					random = Diceroll.get_diceroll();
					Result.setText("Dice : " + String.valueOf(random));
					
					try 
					{
						Diceroll.timer(random);
					} 
					
					catch (InterruptedException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					if(random == 1)
					{
						p2x = 25;
						p2y = 475;
						p2 = 1;
						
						player2.setTranslateX(p2x);
						player2.setTranslateY(p2y);
						movePlayer(p2x,p2y,player2);
						
						o2 = 1;
					}
					
					player1Turn = true;
					player2Turn = false;
					
					b2.setEffect(glow);
					b1.setEffect(glow2);
					
					//arrow.setRotate(270);
					arrow.setX(32);
					arrow.setY(580);
					
				}
				
				if(gamestart != false)
				{
					if(player2Turn != false && o2 == 1)
					{
						int flag = 1;
						
						random = Diceroll.get_diceroll();
						Result.setText("Dice : " + String.valueOf(random));
						
						try 
						{
							Diceroll.timer(random);
						} 
						
						catch (InterruptedException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(p2 == 1 && random == 2 && p2x == 25)
						{
							p2x = 25;
							p2y = 375;
							p2 = 3;
							movePlayer(p2x,p2y,player2);
							player2Turn = false;
							player1Turn = true;
							
							flag = 0;
							
							b2.setEffect(glow);
							b1.setEffect(glow2);
							
							arrow.setX(32);
							arrow.setY(580);

						}
						
						if(p2 == 1 && random == 1 && p2x == 75)
						{
							p2x = 25;
							p2y = 375;
							p2 = 3;
							movePlayer(p2x,p2y,player2);
							player2Turn = false;
							player1Turn = true;
							
							flag = 0;
							
							b2.setEffect(glow);
							b1.setEffect(glow2);
						    
							arrow.setX(32);
							arrow.setY(580);

						}
						
						if(flag == 1)
						{
							m2();
							
							if(p2x>0 && p2y>0)
							{
								movePlayer(p2x,p2y, player2);
								player1Turn = true;
								player2Turn = false;
								
								b2.setEffect(glow);
								b1.setEffect(glow2);
							    
								arrow.setX(32);
								arrow.setY(580);

							}
							
							else
							{
								p2x = p2temp;
								p2y = p2ytemp;
								p2 = p2t;
								player1Turn = true;
								player2Turn = false;
								
								b2.setEffect(glow);
								b1.setEffect(glow2);
								
								arrow.setX(32);
								arrow.setY(580);


							}
						}
					}
				}
			}
		});
		
		gamebutton = new Button("Start Game");
		gamebutton.setTranslateX(220);
		gamebutton.setTranslateY(650);
		
		gamebutton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) 
			{
				gamestart = true;
				
				
				if(c == 1)
				{
					gamebutton.setText("Game started");
					c = 0;
					p1x = 25;
					p1y = 525;
					p1 = 1;
					
					p2x = 25;
					p2y = 525;
					p2 = 1;
					
					player1.setTranslateX(p1x);
					player1.setTranslateY(p1y);
					movePlayer(p1x,p1y,player1);

					player2.setTranslateX(p2x);
				    player2.setTranslateY(p2y);
					movePlayer(p2x,p2y,player2);
					
					player1Turn = true;
					player2Turn = false;
					
					b2.setEffect(glow);
					b1.setEffect(glow2);
					
					o1 = 0;
					o2 = 0;
					
					arrow.setRotate(360);
					arrow.setX(32);
					arrow.setY(580);
				}
				
				
			}
		});
		
		
		Result = new Label("Dice : 0");
		Result.setTextFill(Color.WHITE);
		Result.setTranslateX(237);
		Result.setTranslateY(625);
		
		Image board = new Image("snake.jpeg");
		ImageView bgim = new ImageView();
		bgim.setImage(board);
		bgim.setFitHeight(500);
		bgim.setFitWidth(500);
		
		Image bg = new Image("bg.jpg");
		ImageView bg_ = new ImageView();
		bg_.setImage(bg);
		bg_.setFitHeight(800);
		bg_.setFitWidth(500);
		
		Image ls = new Image("six.jpeg");
		dice = new ImageView(ls);
		dice.setFitHeight(50);
		dice.setFitWidth(50);
		dice.setX(233);
		dice.setY(570);
		
		Image arr = new Image("arrow.png");
		arrow = new ImageView(arr);
		arrow.setFitHeight(60);
		arrow.setFitWidth(40);
		arrow.setRotate(270);
		arrow.setX(150);
		arrow.setY(634);
		
		
		group.getChildren().addAll(bg_);
		group.getChildren().addAll(bgim);
		group.getChildren().addAll(player1);
		group.getChildren().addAll(player2);
		group.getChildren().addAll(b1);
		group.getChildren().addAll(b2);
		group.getChildren().addAll(gamebutton);
		group.getChildren().addAll(Result);
		group.getChildren().addAll(dice);
		group.getChildren().addAll(arrow);
		
		//System.out.println("bkjkb");
		
		return root;
		
	}
	
	private void m1()
	{
		p1temp = p1x;
		p1ytemp = p1y;
		p1t = p1;
		
		for(int i=0; i<random; i++)
		{	
			if(p1%2 == 1)
			{
				//System.out.print("a");
				p1x += 50;
				
			}
				
			if(p1%2 == 0)
			{
				//System.out.print("b");
				p1x -= 50;
				
			}
				
			if(p1x > 475)
			{
				//System.out.print("c");
				p1x -= 50;
				p1y -= 50;
				p1++;
				
			}
				
			if(p1x < 25)
			{
				//System.out.print("d");
				p1y -= 50;
				p1x += 50;
				p1++;
				
			}
		}
		
		
		if(p1x == 25 && p1y == 25)
		{
			//System.out.print("e");
			//p1x = 25;
			//p1y = 25;
			
			gamestart = false;
			//translatePlayer(p1x,p1y,player1);
			//randResult.setText("Player One Won");
			
			originalPos();
			Win.win("PLAYER 1 WON");
			
			gamebutton.setText("Start Again");
			c = 1;
		}
		
		//System.out.println(" ");
		
		// Ladders
		
		if(p1x == 375 && p1y == 475)
		{
			
			p1x = 275;
			p1y = 275;
			p1  = 5;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 225 && p1y == 425)
		{
			
			p1x = 275;
			p1y = 375;
			p1 = 3;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 425 && p1y == 375)
		{   
			
			p1x = 375;
			p1y = 325;
			p1 = 4;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 175 && p1y == 325)
		{
			
			p1x = 225;
			p1y = 175;
			p1 = 7;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 475 && p1y == 275)
		{
			
			p1x = 475;
			p1y = 175;
			p1 = 7;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 175 && p1y == 175)
		{
			
			p1x = 175;
			p1y = 125;
			p1 = 8;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 25 && p1y == 175)
		{
			
			p1x = 75;
			p1y = 75;
			p1 = 9;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 225 && p1y == 125)
		{
			
			p1x = 275;
			p1y = 25;
			p1 = 10;
			movePlayer(p1x, p1y, player1);
		}
		
		if(p1x == 425 && p1y == 75)
		{
			
			p1x = 475;
			p1y = 25;
			p1 = 10;
			movePlayer(p1x, p1y, player1);
		}
		
		//Snakessssssssss
		
		
		if(p1x == 175 && p1y == 375)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 225;
			p1y = 475;
			p1 = 1;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 125 && p1y == 275)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 75;
			p1y = 375;
			p1 = 3;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 25 && p1y == 225)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 75;
			p1y = 275;
			p1 = 5;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 225 && p1y == 225)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 225;
			p1y = 375;
			p1 = 3;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 425 && p1y == 175)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 375;
			p1y = 275;
			p1 = 5;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 475 && p1y == 75)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 425;
			p1y = 125;
			p1 = 8;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 275 && p1y == 75)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 375;
			p1y = 225;
			p1 = 6;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 125 && p1y == 25)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 125;
			p1y = 225;
			p1 = 6;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 225 && p1y == 25)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 175;
			p1y = 75;
			p1 = 9;
			movePlayer(p1x,p1y,player1);
		}
		
		if(p1x == 325 && p1y == 25)
		{
			movePlayer(p1x, p1y, player1);
			p1x = 375;
			p1y = 125;
			p1 = 8;
			movePlayer(p1x,p1y,player1);
		}
	}
	
	private void m2()
	{
		p2temp = p2x;
		p2ytemp = p2y;
		p2t = p2;
		
		for(int i=0; i<random; i++)
		{
			if(p2x < 0 && p2y < 0)
			{
				break;
			}
			
			if(p2%2 == 1)
			{
				p2x += 50;
			}
				
			if(p2%2 == 0)
			{
				p2x -= 50;
			}
				
			if(p2x > 475)
			{
				p2x -= 50;
				p2y -= 50;
				p2++;
			}
				
			if(p2x < 25)
			{
				p2y -= 50;
				p2x += 50;
				p2++;
			}
			
		}
		
		if(p2x == 25 && p2y == 25)
		{
			p2x = 25;
			p2y = 25;
			gamestart = false;
			//randResult.setText("Player Two Won");
			
			originalPos();
			Win.win("PLAYER 2 WON");
			gamebutton.setText("Start Again");
			c = 1;
		}
		
		if(p2x == 375 && p2y == 475)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 275;
			p2y = 275;
			p2 = 5;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 225 && p2y == 425)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 275;
			p2y = 375;
			p2 = 3;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 425 && p2y == 375)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 375;
			p2y = 325;
			p2 = 4;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 175 && p2y == 325)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 225;
			p2y = 175;
			p2 = 7;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 475 && p2y == 275)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 475;
			p2y = 175;
			p2 = 7;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 175 && p2y == 175)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 175;
			p2y = 125;
			p2 = 8;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 25 && p2y == 175)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 75;
			p2y = 75;
			p2 = 9;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 225 && p2y == 125)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 275;
			p2y = 25;
			p2 = 10;
			movePlayer(p2x, p2y, player2);
		}
		
		if(p2x == 425 && p2y == 75)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 475;
			p2y = 25;
			p2 = 10;
			movePlayer(p2x, p2y, player2);
		}
		
		
		// Snakesssssss
		
		
		if(p2x == 175 && p2y == 375)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 225;
			p2y = 475;
			p2 =1;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 125 && p2y == 275)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 75;
			p2y = 375;
			p2 = 3;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 25 && p2y == 225)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 75;
			p2y = 275;
			p2 = 5;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 225 && p2y == 225)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 225;
			p2y = 375;
			p2 = 3;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 425 && p2y == 175)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 375;
			p2y = 275;
			p2 = 5;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 475 && p2y == 75)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 425;
			p2y = 125;
			p2 = 8;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 275 && p2y == 75)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 375;
			p2y = 225;
			p2 = 6;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 125 && p2y == 25)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 125;
			p2y = 225;
			p2 = 6;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 225 && p2y == 25)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 175;
			p2y = 75;
			p2 = 9;
			movePlayer(p2x,p2y,player2);
		}
		
		if(p2x == 325 && p2y == 25)
		{
			movePlayer(p2x, p2y, player2);
			p2x = 375;
			p2y = 125;
			p2 = 8;
			movePlayer(p2x,p2y,player2);
		}
	}	
	
	private void movePlayer(int x,int y,Circle c)
	{
		//System.out.println(x + " " + y);
		
		TranslateTransition moving = new TranslateTransition(Duration.millis(1000),c);
		moving.setToX(x);
		moving.setToY(y);
		moving.setAutoReverse(false);
		moving.play();
	}	
	
	private void originalPos()
	{
		arrow.setRotate(270);
		arrow.setX(150);
		arrow.setY(634);
		
		b1.setEffect(glow);
		b2.setEffect(glow);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception
	{
		Scene scene = new Scene(create());
		primaryStage.setTitle("Snake and Ladder");		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) 
	{
			launch(args);
	}
}
