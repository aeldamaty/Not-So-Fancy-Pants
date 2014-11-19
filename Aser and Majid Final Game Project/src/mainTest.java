//IMPORT
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

//Majid and Aser
//Not so Fancy Pants
//ICS 4U0 - Mr.Sayed
//June 14th 2013
//Not So Fancy Pants is a game. It starts with an intro screen that displays the makers of the game and a loading bar. It then goes to another screen where the user can run around with the player and when he wants to play, he enters a door. This then takes him to the main menu screen. This menu has platforms and doors. The user has to control the player to a specific door depending on what he wants. For example if he wants to go the instructions screen, he goes to the instructions door. You move using the left and right arrow keys, jump with the up key, and enter the door with the spacebar key. Once the user starts the game, he is taken to another screen. He has to avoid getting caught by the cheetah and the falling rotten apples. He also has to collect coconuts to get points. The game ends when you lose all your 3 lives due to getting hit by a rotten apple, or when you get caught by the cheetah once. It displays a dead picture. You then press r to restart or m to go back to the main menu.
//The game has no known bugs, except for the few random times the game freezes when you lose 2 lives. It really has no specific time it happens, but rather happens rarely and randomly. 

///MAIN
public class mainTest extends Applet implements Runnable, ActionListener
{

	//Declare booleans
	boolean introScreen =true;
	boolean loadScreen =false;
	boolean screen1=false;
	boolean screen2=false;
	boolean instructionsScreen=false;
	boolean creditsScreen=false;
	boolean storyScreen=false;
	boolean playScreen=false;
	boolean stand=true;
	boolean mLeft=false;
	boolean mRight=false;
	boolean jump=false;
	boolean lastPositionRight=true;
	boolean restart=false;
	boolean mainMenu=false;
	boolean spacebar=false;
	boolean initiateJump=false;
	
	//How many times did the player play the game?
	int restarts = 1 ; //Its one because the player starts off  by playing one game automatically
	
	//To see how many times he has jumped
	int jumpCounter=0;
	
	//Spawn rate for the cocunuts and the rotten fruit
	static int timerForNextMeteoroidSpawn=0;
	static int timerForNextCoconutSpawn=0;
	
	//sets 2 variables to act as dimensions for the screen
	static int appletsize_x = 1020;
	static int appletsize_y = 650;
	
	//This is for the highscores.
	String playerName="Nobody is";//default person holding highscore
	int hs1=0;
	int highscore=0;
	int highscore2=0;
	int highscore3=0;

	//Default image
	private Image dbImage;
	private Graphics dbg;
	
	//Declare images
	Image intro;
	Image loading;
	Image standingLeft;
	Image standingRight;
	Image movingLeft;
	Image movingRight;
	Image jumping;
	Image firstbg;
	Image secondbg;
	Image instructions;
	Image story;
	Image credits;
	Image gameMap;
	Image fireBall;
	Image coconut;
	Image cheetahLeftPic;
	Image cheetahRightPic;
	Image lostLive;
	Image dead;
	Image coverA;
	Image cocoFeverA;
	Image rollA;
	Image gameLoveA;
	Image invisA;
	Image deadA;
	Image doctorA;
	Image healthyA;
	Image hundredA;
	Image beastA;
	Image highscoreA;
	Image fancyA;
	
	//call the other classes
	Player one=new Player();
	Cheetah cheetah=new Cheetah();
	Map1 firstMap=new Map1();
	Map2 secondMap=new Map2();
	GameMap playMap=new GameMap();
	
	//fireballs array
	ArrayList<Fireball> allFireballs = new ArrayList <Fireball> ();
	String fireBallPath="rotten.png";//picture path
	//coconuts array
	ArrayList <Coconut> allCoconuts = new ArrayList <Coconut>();
	String coconutPath = "coconut.png";//picture path
	
	//Init method
	public void init ()
	{
		//set window settings
		resize (appletsize_x,appletsize_y);
		setLayout (null);//null layout is default layout
		
		//Attach the file paths to the image and prepare images
		standingLeft = getToolkit ().getImage (one.getSTANDINGLEFT_PATH());
		prepareImage (standingLeft, this);
		standingRight = getToolkit ().getImage (one.getSTANDINGRIGHT_PATH());
		prepareImage (standingRight, this);
		movingLeft = getToolkit ().getImage (one.getLEFT_PATH());
		prepareImage (movingLeft, this);
		movingRight = getToolkit ().getImage (one.getRIGHT_PATH());
		prepareImage (movingRight, this);
		jumping = getToolkit ().getImage (one.getJUMPING_PATH());
		prepareImage (jumping, this);
		firstbg = getToolkit ().getImage (firstMap.getMap1Path());
		prepareImage (firstbg, this);
		secondbg = getToolkit ().getImage (secondMap.getMap2Path());
		prepareImage (secondbg, this);
		instructions=getToolkit().getImage (secondMap.getMap2InstructionsPath());
		prepareImage (instructions,this);
		story=getToolkit().getImage (secondMap.getMap2StoryPath());
		prepareImage (story,this);
		credits=getToolkit().getImage (secondMap.getMap2CreditsPath());
		prepareImage (credits,this);
		gameMap=getToolkit().getImage (playMap.getGameMapPath());
		prepareImage (gameMap,this);
		fireBall=getToolkit().getImage (fireBallPath);
		prepareImage (fireBall,this);
		coconut=getToolkit().getImage (coconutPath);
		prepareImage (coconut,this);
		cheetahLeftPic=getToolkit().getImage (cheetah.getPicturePathLeft());
		prepareImage (cheetahLeftPic,this);
		cheetahRightPic=getToolkit().getImage (cheetah.getPicturePathRight());
		prepareImage (cheetahRightPic,this);
		intro=getToolkit().getImage ("Introanimation.gif");
		prepareImage (intro,this);
		loading=getToolkit().getImage ("load.gif");
		prepareImage (loading,this);
		lostLive=getToolkit().getImage ("dead.png");
		prepareImage (lostLive,this);
		dead=getToolkit().getImage ("death.png");
		prepareImage (dead,this);
		gameLoveA=getToolkit().getImage ("GameLove.png");
		prepareImage (gameLoveA,this);
		rollA=getToolkit().getImage ("rolll.png");
		prepareImage (rollA,this);
		cocoFeverA=getToolkit().getImage ("cocoFever.png");
		prepareImage (cocoFeverA,this);
		coverA=getToolkit().getImage ("cover.png");
		prepareImage (coverA,this);
		invisA=getToolkit().getImage ("invins.png");
		prepareImage (invisA,this);
		deadA=getToolkit().getImage ("playingdead.png");
		prepareImage (deadA,this);
		doctorA=getToolkit().getImage ("doctors.png");
		prepareImage (doctorA,this);
		healthyA=getToolkit().getImage ("healthy.png");
		prepareImage (healthyA,this);
		hundredA=getToolkit().getImage ("hundred.png");
		prepareImage (hundredA,this);
		beastA=getToolkit().getImage ("beast.png");
		prepareImage (beastA,this);
		highscoreA=getToolkit().getImage ("highscore.gif");
		prepareImage (highscoreA,this);
		fancyA=getToolkit().getImage ("fancy.png");
		prepareImage (fancyA,this);
		
		

		
	} // init method


	//start method	
	public void start ()
	{

		// define a new thread
		Thread th = new Thread (this);
		// start this thread
		th.start ();


	}

//stop method
	public void stop ()
	{
		//nothing right now
	}

//destroy method
	public void destroy ()
	{
		//nothing right now
	}

//run method
	public void run ()
	{
		// lower ThreadPriority
		Thread.currentThread ().setPriority (Thread.MIN_PRIORITY);
		
		while (true){
			Thread.currentThread ().setPriority (Thread.MAX_PRIORITY);
			
		
			//When screen1 is true, meaning the screen where the the player first has control over the character
			//This happens after the first two screens are over with.
			if (screen1==true){
				
				//Allows the player to have control over the characters jump
				//adds jumping functionality to the character
				if (initiateJump==true){
					if(one.getyVelocity()!=0){
						one.setyPos(one.getyPos()-one.getyVelocity());
						one.setyVelocity(one.getyVelocity()-one.getyAcceleration());
					}
					else{
						initiateJump=false;
					}
				}
				//make the player be able to walk on the ground without falling through
				//Boundries
				else{
					if(one.getyPos()<firstMap.getGround()){
						if ((one.getyPos()+one.getyVelocity())>firstMap.getGround()){
							one.setyVelocity(firstMap.getGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}else {
						one.setyPos(firstMap.getGround());
					}
					if (one.getyPos()==firstMap.getGround()){
						jumpCounter=0;
					}
				}
				//adds functionality for moving the character right
				//increases the x-position by 3 every time
				if (mRight==true){
					one.setxPos(one.getxPos()+3);
				}
				//adds functionality for moving the character left
				//increases the x-position by 3 every time
				//sets boundry for left wall
				if (mLeft==true && one.getxPos()>firstMap.getLeftWall()){
					one.setxPos(one.getxPos()-3);
				}
				if (one.getxPos()>683){
					one.setxPos(200);
					one.setyPos(300);
					screen1=false;
					screen2=true;
				}
			}
			//If the second screen is true. Meaning that the character is now in the menu.
			
			if (screen2==true){
				
				//Allows the player to have control over the characters jump
				//adds jumping functionality to the character
				if (initiateJump==true){
					if(one.getyVelocity()!=0 && one.getyPos()>100){
						one.setyPos(one.getyPos()-one.getyVelocity());
						one.setyVelocity(one.getyVelocity()-one.getyAcceleration());
					}
					else{
						initiateJump=false;
					}
				}
				if (initiateJump==false){
					//gets the locations of the platforms/ground/walls and makes sure the player can not walk/fall through
					//boundries
					if(((secondMap.getLeftPlatformRightX()<one.getxPos() && one.getxPos()<secondMap.getMiddlePlatformLeftX())||(secondMap.getMiddlePlatformRightX()<one.getxPos()&& one.getxPos()<secondMap.getRightPlatformLeftX())) && one.getyPos()<secondMap.getGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getGround()){
							one.setyVelocity(secondMap.getGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
					//SET BOUNDRIES
					else if(((secondMap.getLeftWall()<one.getxPos()&&one.getxPos()<secondMap.getLeftPlatformRightX())||one.getxPos()>secondMap.getRightPlatformLeftX())&& one.getyPos()<secondMap.getLeftRightPlatformGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getLeftRightPlatformGround()){
							one.setyVelocity(secondMap.getLeftRightPlatformGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
					else if ((secondMap.getMiddlePlatformLeftX()<one.getxPos()&&one.getxPos()<secondMap.getMiddlePlatformRightX())&& one.getyPos()<secondMap.getMiddlePlatformGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getMiddlePlatformGround()){
							one.setyVelocity(secondMap.getMiddlePlatformGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
					else if ((((one.getxPos()<secondMap.getLeftPlatformRightX()||one.getxPos()>secondMap.getRightPlatformLeftX())&& one.getyPos()>secondMap.getLeftRightPlatformGround())||(secondMap.getMiddlePlatformLeftX()<one.getxPos()&&secondMap.getMiddlePlatformRightX()>one.getxPos()&&one.getyPos()>secondMap.getMiddlePlatformGround()))&&one.getyPos()<secondMap.getGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getGround()){
							one.setyVelocity(secondMap.getGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
				}
				//adds functionality for moving the character right
				//increases the x-position by 3 every time
				//sets boundry for right wall
				if (mRight==true && one.getxPos()<secondMap.getRightWall()){
					one.setxPos(one.getxPos()+3);
				}
				//adds functionality for moving the character left
				//increases the x-position by 3 every time
				//sets boundry for left wall
				if (mLeft==true && one.getxPos()>secondMap.getLeftWall()){
					one.setxPos(one.getxPos()-3);
				}
				//If spacebar is pressed, activate the door that the player is nearest to
				if (spacebar==true){
					if (one.getxPos()>secondMap.getPlayDoorLeftX() && one.getxPos()<secondMap.getPlayDoorRightX() && one.getyPos()<=secondMap.getMiddlePlatformGround()){
						spacebar=false;
						screen2=false;
						playScreen=true;
					}
					if (one.getxPos()>secondMap.getInstructionsBackDoorLeftX()&&one.getxPos()<secondMap.getInstructionsBackDoorRightX()&& one.getyPos()<=secondMap.getLeftRightPlatformGround()){
						spacebar=false;
						screen2=false;
						instructionsScreen=true;
					}
					if (one.getxPos()>secondMap.getCreditsDoorLeftX()&&one.getxPos()<secondMap.getCreditsDoorRightX()&& one.getyPos()<=secondMap.getGround() && one.getyPos()>secondMap.getMiddlePlatformGround()){
						spacebar=false;
						screen2=false;
						creditsScreen=true;
					}
					if (one.getxPos()>secondMap.getStoryDoorLeftX()&&one.getxPos()<secondMap.getStoryDoorRightX()&& one.getyPos()<=secondMap.getLeftRightPlatformGround()){
						spacebar=false;
						screen2=false;
						storyScreen=true;
					}
				}
			}
			//If the submenus are true, activate all the players properties (jump, move etc)
			if (instructionsScreen==true||creditsScreen==true||storyScreen==true){

				if (initiateJump==true){
					if(one.getyVelocity()!=0 && one.getyPos()>100){
						one.setyPos(one.getyPos()-one.getyVelocity());
						one.setyVelocity(one.getyVelocity()-one.getyAcceleration());
					}
					else{
						initiateJump=false;
					}
				}
				if (initiateJump==false){
					//as said before, gets boundries of all the platforms
					if(((secondMap.getLeftPlatformRightX()<one.getxPos() && one.getxPos()<secondMap.getMiddlePlatformLeftX())||(secondMap.getMiddlePlatformRightX()<one.getxPos()&& one.getxPos()<secondMap.getRightPlatformLeftX())) && one.getyPos()<secondMap.getGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getGround()){
							one.setyVelocity(secondMap.getGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
					else if(((secondMap.getLeftWall()<one.getxPos()&&one.getxPos()<secondMap.getLeftPlatformRightX())||one.getxPos()>secondMap.getRightPlatformLeftX())&& one.getyPos()<secondMap.getLeftRightPlatformGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getLeftRightPlatformGround()){
							one.setyVelocity(secondMap.getLeftRightPlatformGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
					else if ((secondMap.getMiddlePlatformLeftX()<one.getxPos()&&one.getxPos()<secondMap.getMiddlePlatformRightX())&& one.getyPos()<secondMap.getMiddlePlatformGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getMiddlePlatformGround()){
							one.setyVelocity(secondMap.getMiddlePlatformGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
					else if ((((one.getxPos()<secondMap.getLeftPlatformRightX()||one.getxPos()>secondMap.getRightPlatformLeftX())&& one.getyPos()>secondMap.getLeftRightPlatformGround())||(secondMap.getMiddlePlatformLeftX()<one.getxPos()&&secondMap.getMiddlePlatformRightX()>one.getxPos()&&one.getyPos()>secondMap.getMiddlePlatformGround()))&&one.getyPos()<secondMap.getGround()){
						if ((one.getyPos()+one.getyVelocity())>secondMap.getGround()){
							one.setyVelocity(secondMap.getGround()-one.getyPos());
						}
						one.setyPos(one.getyPos()+one.getyVelocity());
						one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
					}
				}
				if (mRight==true && one.getxPos()<secondMap.getRightWall()){
					one.setxPos(one.getxPos()+3);
				}
				if (mLeft==true && one.getxPos()>secondMap.getLeftWall()){
					one.setxPos(one.getxPos()-3);
				}
				if (spacebar==true){
					//if the spacebar button is pressed while the player is infront of the instructions door, exit the instrcutions screen and make the main menu visible
					if (one.getxPos()>secondMap.getInstructionsBackDoorLeftX()&&one.getxPos()<secondMap.getInstructionsBackDoorRightX()&& one.getyPos()<=secondMap.getLeftRightPlatformGround()){
						spacebar=false;
						instructionsScreen=false;
						creditsScreen=false;
						storyScreen=false;
						screen2=true;
					}
				}
				
				
			}
			
			//if the playscreen is true meaning the player is now playing the game...
			if (playScreen==true){
				//set 3 lives
				
				int lives =3;
				
				//If the player is still alive, let the player be able to access its settings (jump etc)
				if(one.getLives()>0){
					if (initiateJump==true){
						if(one.getyVelocity()!=0 && one.getyPos()>10){
							one.setyPos(one.getyPos()-one.getyVelocity());
							one.setyVelocity(one.getyVelocity()-one.getyAcceleration());
						}
						else{
							initiateJump=false;
						}
					}
					else{
						if(one.getyPos()<firstMap.getGround()){
							if ((one.getyPos()+one.getyVelocity())>firstMap.getGround()){
								one.setyVelocity(firstMap.getGround()-one.getyPos());
							}
							one.setyPos(one.getyPos()+one.getyVelocity());
							one.setyVelocity(one.getyVelocity()+one.getyAcceleration());
						}else {
							one.setyPos(firstMap.getGround());
						}
						if (one.getyPos()==firstMap.getGround()){
							jumpCounter=0;
						}
					}
					if (mRight==true){
						one.setxPos(one.getxPos()+3);
					}
					if (mLeft==true && one.getxPos()>firstMap.getLeftWall()){
						one.setxPos(one.getxPos()-3);
					}
					
					//Add the rotten fruit to the screen (random generated)
					timerForNextMeteoroidSpawn++;
					if(timerForNextMeteoroidSpawn==100){
						Fireball newFireBall= new Fireball();
						allFireballs.add(newFireBall);
					}
					else if (timerForNextMeteoroidSpawn>100){
						timerForNextMeteoroidSpawn=0;
					}
				
					//If player touched the rotten fruit, lose a life and makes it disapear off the screen
					for (int i=0;i<allFireballs.size();i++){
						if(allFireballs.get(i).getY()<600){
							allFireballs.get(i).setY(allFireballs.get(i).getY()+3);
						}else{
							allFireballs.remove(i);
						}
						if((allFireballs.get(i).getX()-one.getxPos())<20 && (allFireballs.get(i).getX()-one.getxPos())>-20 && (allFireballs.get(i).getY()-one.getyPos())<20 && (allFireballs.get(i).getY()-one.getyPos())>-20 ){
							one.setLives(one.getLives()-1);
							allFireballs.remove(i);
							
							if(one.getLives()==0){
								if (hs1 > highscore){
									playerName  = JOptionPane.showInputDialog(null,"NEW HIGHSCORE: Enter your name:",
											"NEW HIGHSCORE", JOptionPane.PLAIN_MESSAGE);
									highscore=hs1;	
								}
								}
						}
					}
				
					//Spawn coconuts randomly generated
					timerForNextCoconutSpawn++;
					if(timerForNextCoconutSpawn==100){
						Coconut newCoconut= new Coconut();
						allCoconuts.add(newCoconut);
					}
					else if (timerForNextCoconutSpawn>100){
						timerForNextCoconutSpawn=0;
					}
				
					//Add to score if the cocunut is collected and make it disapear off the screen
					for (int i=0;i<allCoconuts.size();i++){
						if (allCoconuts.get(i).getY()<GameMap.getGround()){
							allCoconuts.get(i).setY(allCoconuts.get(i).getY()+3);
						}
						if((allCoconuts.get(i).getX()-one.getxPos())<20 && (allCoconuts.get(i).getX()-one.getxPos())>-20 && (allCoconuts.get(i).getY()-one.getyPos())<20 && (allCoconuts.get(i).getY()-one.getyPos())>-20 ){
							one.setScore(one.getScore()+1);
							allCoconuts.remove(i);
						}
					}
					
					
					//SET CHEETAH MOVING LEFT TO RIGHT AND SET ITS BOUNDRIES SO IT SWITCHED DIRECTION WHEN IN
					//CONTACT WITH WALL
					if (cheetah.isMoveRight()==true && cheetah.getX()<1000){
						cheetah.setX(cheetah.getX()+5);
					}else{
						cheetah.setMoveRight(false);
					}
					if (cheetah.isMoveRight()==false && cheetah.getX()>10){
						cheetah.setX(cheetah.getX()-5);
					}else{
						cheetah.setMoveRight(true);
					}
					
					if(cheetah.isMoveRight()==true && cheetah.getX()>GameMap.getRightWall()){
						cheetah.setMoveRight(true);
					}
					else if(cheetah.isMoveRight()==false && cheetah.getX()<GameMap.getLeftWall()){
						cheetah.setMoveRight(false);
					}
					
					if (cheetah.isMoveRight()==true && one.getxPos()-cheetah.getX()<200 && one.getxPos()-cheetah.getX()>=20 && one.getyPos()==GameMap.getGround()){
						one.setLives(0);
					}
					else if (cheetah.isMoveRight()==false && one.getxPos()-cheetah.getX()>-20 && one.getxPos()-cheetah.getX()<=0 && one.getyPos()==GameMap.getGround()){
						one.setLives(0);
					}
					
				}
				
				//when player dies
				else{
					//remove fireballs and coconuts
					allFireballs.removeAll(allFireballs);
					allCoconuts.removeAll(allCoconuts);
					//resets position of cheetah
					cheetah.setX(-100);
					cheetah.setMoveRight(true);
					//reset the screen
					if (restart==true){
						playScreen=false;
						screen2=true;
						screen2=false;
						playScreen=true;
						one.setLives(3);
						one.setScore(0);
					}
					//access main menu
					if (mainMenu==true){
						playScreen=false;
						screen2=true;
					}
				}
			}
			
			//Repaint (access paint method)
			repaint();
			try
			{
				// Stop thread for 20 milliseconds
				Thread.sleep (20);
			}
			catch (InterruptedException ex)
			{
				// do nothing
			}

			// set ThreadPriority to maximum value
			Thread.currentThread ().setPriority (Thread.MAX_PRIORITY);
			
		}
	}


	/** Update - Method, implements double buffering */
	public void update (Graphics g)
	{

		// initialize buffer
		if (dbImage == null)
		{
			dbImage = createImage (this.getSize ().width, this.getSize ().height);
			dbg = dbImage.getGraphics ();
		}

		// clear screen in background
		dbg.setColor (getBackground ());
		dbg.fillRect (0, 0, this.getSize ().width, this.getSize ().height);

		// draw elements in background
		dbg.setColor (getForeground ());
		paint (dbg);

		// draw image on the screen
		g.drawImage (dbImage, 0, 0, this);
	}

	// method to handle key - down events
	
	//When a button is pressed what should happen?
	public boolean keyDown (Event e, int key)
	{
		//If up button is clicked, jump
		if (key==Event.UP){
			initiateJump=true;
			jump=true;
			stand=false;
			one.setyVelocity(15);
			jumpCounter=jumpCounter+1;
			
		}
		//If right button is clicked, move right
		else if (key==Event.RIGHT){
			jump=false;
			stand=false;
			mRight=true;
			lastPositionRight=true;
		}
		////If left button is clicked, move left
		else if (key==Event.LEFT){
			jump=false;
			stand=false;
			mLeft=true;
			lastPositionRight=false;
		}
		//if spacebar is pressed access door
		else if (key==32){
			spacebar=true;
		}
		//if r is pressed, reset level
		else if (key == 114){
			restart = true;
			restarts = restarts +1;
		}
		//if m is pressed, go to main menu
		else if (key == 109){
			mainMenu=true;
		}
		
		//if the intro screen is valid, and the enter screen is pressed, enter new screen
		if (introScreen==true){
			 if (key==KeyEvent.VK_ENTER){
				 introScreen=false;
				 loadScreen=true;
			 }
		}
		//if the loading screen is valid, and the enter screen is pressed, enter main menu

		else if (loadScreen==true){
			 if (key==KeyEvent.VK_ENTER){
				 loadScreen=false;
				 screen1=true;
			 }
		}
		//if the play screen is valid, and the r is pressed, restart game

		else if (playScreen==true){
		if (key == 114){
			allFireballs.removeAll(allFireballs);
			allCoconuts.removeAll(allCoconuts);
			cheetah.setX(0);
			cheetah.setMoveRight(true);
			playScreen=false;
			screen2=true;
			screen2=false;
			playScreen=true;
			one.setLives(3);
			one.setScore(0);
		}
		}
		return true;
	}
	
	//When the button is released
	public boolean keyUp (Event e, int key)
	{
		//REVERSES EVERY MOVEMNT TO STOP AND MAKES THE PLAYER GIF TURN TO STANDING
		//Take back everything the button did
		
		if (key==Event.UP){
			stand=true;
			jump=false;
		}
		else if (key==Event.RIGHT){
			mRight=false;
			stand=true;
		}
		else if (key==Event.LEFT){
			mLeft=false;
			stand=true;
		}
		else if (key==32){
			spacebar=false;
		}
		else if (key == 114){
			restart = false;
		}
		else if (key == 109){
			mainMenu=false;
		}
		return true;
	}


	public void actionPerformed (ActionEvent evt)
	{
//nothing yet
	}


//Paint method, lets things be drawn to the screen
	public void paint (Graphics g)
	{
		//Paints a default black background and draws images as screen is appropriate.
		
		//If the introduction screen is showing...show all those pictures and graphics
		if (introScreen==true){

			g.fillRect(0, 0, 1020, 650);
			g.drawImage(intro,120,100,null);
		
			loadScreen=false;
			
			g.setColor(Color.WHITE);
			g.drawString("Press Enter to Skip Introduction",710, 550);

		}
		
		//If the loading screen is showing...show all those pictures and graphics

		if (loadScreen==true){
			introScreen=false;
			
			g.fillRect(0, 0, 1020, 650);

			g.drawImage(loading,120,100,null);
			
			g.setColor(Color.WHITE);
			g.drawString("Press Enter to Continue to Main Menu",687, 550);

		}
		
		//If the entry screen is showing...show all those pictures and graphics

		if (screen1==true){
			g.drawImage(firstbg,0,0,null);
			
			if (mLeft==true){
				g.drawImage(movingLeft,one.getxPos(),one.getyPos(),null);
			}
			else if (mRight==true){
				g.drawImage(movingRight,one.getxPos(),one.getyPos(),null);
			}
			else if (jump==true && mLeft==false && mRight==false){
				g.drawImage(jumping,one.getxPos(),one.getyPos(),null);
			}
			else if (stand==true){
				if (lastPositionRight==true){
					g.drawImage(standingRight,one.getxPos(),one.getyPos(),null);
				}
				else{
					g.drawImage(standingLeft,one.getxPos(),one.getyPos(),null);
				}
			}
		}
		
		//If the main menu screen is showing...show all those pictures and graphics

		if (screen2==true){
			g.drawImage(secondbg,0,0,null);
			
			g.setFont(new Font("Times new Roman", 5, 10));
			g.setColor(Color.BLACK);
			g.drawString(playerName+" currently holding the highscore: " + highscore,30,540);
			g.drawString("2nd:" + highscore2,30,555);
			g.drawString("3rd:" + highscore3,30,570);


			if (mLeft==true){
				g.drawImage(movingLeft,one.getxPos(),one.getyPos(),null);
			}
			else if (mRight==true){
				g.drawImage(movingRight,one.getxPos(),one.getyPos(),null);
			}
			else if (jump==true && mLeft==false && mRight==false){
				g.drawImage(jumping,one.getxPos(),one.getyPos(),null);
			}
			else if (stand==true){
				if (lastPositionRight==true){
					g.drawImage(standingRight,one.getxPos(),one.getyPos(),null);
				}
				else{
					g.drawImage(standingLeft,one.getxPos(),one.getyPos(),null);
				}
			}
		}
		
		//If the instructions screen is showing...show all those pictures and graphics

		if(instructionsScreen==true){
			g.drawImage(instructions,0,0,null);
			if (mLeft==true){
				g.drawImage(movingLeft,one.getxPos(),one.getyPos(),null);
			}
			else if (mRight==true){
				g.drawImage(movingRight,one.getxPos(),one.getyPos(),null);
			}
			else if (jump==true && mLeft==false && mRight==false){
				g.drawImage(jumping,one.getxPos(),one.getyPos(),null);
			}
			else if (stand==true){
				if (lastPositionRight==true){
					g.drawImage(standingRight,one.getxPos(),one.getyPos(),null);
				}
				else{
					g.drawImage(standingLeft,one.getxPos(),one.getyPos(),null);
				}
			}
		}
		
		//If the story screen is showing...show all those pictures and graphics

		if(storyScreen==true){
			g.drawImage(story,0,0,null);
			if (mLeft==true){
				g.drawImage(movingLeft,one.getxPos(),one.getyPos(),null);
			}
			else if (mRight==true){
				g.drawImage(movingRight,one.getxPos(),one.getyPos(),null);
			}
			else if (jump==true && mLeft==false && mRight==false){
				g.drawImage(jumping,one.getxPos(),one.getyPos(),null);
			}
			else if (stand==true){
				if (lastPositionRight==true){
					g.drawImage(standingRight,one.getxPos(),one.getyPos(),null);
				}
				else{
					g.drawImage(standingLeft,one.getxPos(),one.getyPos(),null);
				}
			}
		}
		
		//If the credits screen is showing...show all those pictures and graphics

		if(creditsScreen==true){
			g.drawImage(credits,0,0,null);
			

			if (mLeft==true){
				g.drawImage(movingLeft,one.getxPos(),one.getyPos(),null);
			}
			else if (mRight==true){
				g.drawImage(movingRight,one.getxPos(),one.getyPos(),null);
			}
			else if (jump==true && mLeft==false && mRight==false){
				g.drawImage(jumping,one.getxPos(),one.getyPos(),null);
			}
			else if (stand==true){
				if (lastPositionRight==true){
					g.drawImage(standingRight,one.getxPos(),one.getyPos(),null);
				}
				else{
					g.drawImage(standingLeft,one.getxPos(),one.getyPos(),null);
				}
			}
		}
		
		//If the play screen is showing...show all those pictures and graphics

		if (playScreen==true){
			g.fillRect(0, 0, 1020, 650);

			
			//if there is 3 lives left
			if (one.getLives()==3){

			g.drawImage(gameMap,playMap.getxPos(),playMap.getyPos(),null);
			
			}
			
			g.drawImage(gameMap,playMap.getxPos(),playMap.getyPos(),null);

			/*
			if (one.getScore()==11 ||one.getScore()==32 ||one.getScore()==16 ||one.getScore()==26 ||one.getScore()==46 ||one.getScore()==56 ||one.getScore()==66 ||one.getScore()==76||one.getScore()==100){
				g.drawImage(coverA,680,24,null);
				//TODO

			}
			
			*/
			//=================================================================ACHIEVMENTS=========================================================
			
			//depending on their score/highscore, display the correct achievemnt on the screen
			
			if(one.getScore()>highscore){
			g.drawImage(highscoreA,0,0,null);

			}
			
			if (restarts ==5 && one.getScore()==0){
				g.drawImage(gameLoveA,680,24,null);

			}
			
			if (one.getScore()==100){
				g.drawImage(hundredA,680,24,null);

			}
			
			if (one.getScore()==20 && one.getLives()==3){
				g.drawImage(doctorA,680,24,null);

			}
			
			if (one.getScore()==40 && one.getLives()==3){
				g.drawImage(healthyA,680,24,null);

			}
			
			if (one.getScore()==25 && one.getLives()==3){
				g.drawImage(beastA,680,24,null);

			}
			
			if (one.getScore()==1 && one.getLives()==1){
				g.drawImage(deadA,680,24,null);

			}
			
			if (one.getLives()==3 && one.getScore()==10){
				g.drawImage(rollA,680,24,null);

			}
			
			if (one.getLives()==3 && one.getScore()==30){
				g.drawImage(invisA,680,24,null);

			}
			
			if ( one.getScore()==35 || one.getScore()==150){
				g.drawImage(invisA,680,24,null);

			}

			if ( one.getScore()==15 ||one.getScore()==25 ||one.getScore()==45 ||one.getScore()==55 ||one.getScore()==65 || one.getScore()==75 || one.getScore()==125 || one.getScore()==155|| one.getScore()==205|| one.getScore()==175){
				g.drawImage(cocoFeverA,680,24,null);

			}
			
			//====================================================================================================================================	
			
			//display character
			
			if (mLeft==true){
				g.drawImage(movingLeft,one.getxPos(),one.getyPos(),null);
			}
			else if (mRight==true){
				g.drawImage(movingRight,one.getxPos(),one.getyPos(),null);
			}
			else if (jump==true && mLeft==false && mRight==false){
				g.drawImage(jumping,one.getxPos(),one.getyPos(),null);
			}
			else if (stand==true){
				if (lastPositionRight==true){
					g.drawImage(standingRight,one.getxPos(),one.getyPos(),null);
				}
				else{
					g.drawImage(standingLeft,one.getxPos(),one.getyPos(),null);
				}
			}
			
			for (int i=0;i<allFireballs.size();i++){
				g.drawImage(fireBall,allFireballs.get(i).getX(),allFireballs.get(i).getY(),null);
			}
			for (int k=0;k<allCoconuts.size();k++){
				g.drawImage(coconut,allCoconuts.get(k).getX(),allCoconuts.get(k).getY(),null);
			}
			if (cheetah.isMoveRight()==true){
				g.drawImage(cheetahRightPic,cheetah.getX(),cheetah.getY(),null);
			}else{
				g.drawImage(cheetahLeftPic,cheetah.getX(),cheetah.getY(),null);
			}
	
			
			
			if (one.getLives()==2){
				g.drawImage(lostLive,116,100,null);

			}
			
			if (one.getLives()==1){
				g.drawImage(lostLive,116,100,null);
				g.drawImage(lostLive,142,100,null);
			}
			
			g.setFont(new Font("Times new Roman", 50, 50));
			g.setColor(Color.WHITE);
			g.drawString(Integer.toString(one.getScore()),265,149);
			
			
			//display highscores
			
			if (one.getLives()==0){
				g.drawImage(dead,0,0,null);
				
				hs1 = one.getScore();
				int hs=highscore; 
				int hs2=highscore2;
				int hs3=highscore3;
				
				
				
				if (hs1 > highscore && hs1 >highscore2 && hs1 >highscore3){
				
					highscore=hs1;	
					
					playerName="You are ";
				}
				
				else if (hs1 < highscore && hs1>highscore3 && hs1>highscore2){
					
					highscore2=hs1;	
					
				}
				
				else if (hs1 < highscore2 && hs1>highscore3 ){
					
					highscore3=hs1;	
					
				}
				
				if(hs1>highscore){
					highscore2=hs;
					highscore3=hs2;
				}
			}
			
			
			
			
		}
		
	} // paint method
	
	
} 



