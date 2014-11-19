//player class
import java.awt.Image;


public class Player {
	
	//positions and accelerations
	private int xPos;
	private int yPos;
	private int yVelocity;
	private int yAcceleration;
	//lives and score
	private int lives;
	private int score;
	
	//picture paths
	private final String STANDINGLEFT_PATH;
	private final String STANDINGRIGHT_PATH;
	private final String LEFT_PATH;
	private final String RIGHT_PATH;
	private final String JUMPING_PATH;
	//constructor
	public Player(){
		xPos=300;
		yPos=300;
		yVelocity=0;
		yAcceleration=1;
		lives=3;
		score=0;
		STANDINGLEFT_PATH = "standingLeft.gif";
		STANDINGRIGHT_PATH="standingRight.gif";
		LEFT_PATH = "movingLeft.gif";
		RIGHT_PATH = "movingRight.gif";
		JUMPING_PATH = "jumping.gif";		
		
	}
	//getters and setters
	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getyVelocity() {
		return yVelocity;
	}

	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}

	public int getyAcceleration() {
		return yAcceleration;
	}

	public void setyAcceleration(int yAcceleration) {
		this.yAcceleration = yAcceleration;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int health) {
		this.lives = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLEFT_PATH() {
		return LEFT_PATH;
	}

	public String getRIGHT_PATH() {
		return RIGHT_PATH;
	}

	public String getJUMPING_PATH() {
		return JUMPING_PATH;
	}

	public String getSTANDINGLEFT_PATH() {
		return STANDINGLEFT_PATH;
	}
	
	public String getSTANDINGRIGHT_PATH(){
		return STANDINGRIGHT_PATH;
	}
	
}
