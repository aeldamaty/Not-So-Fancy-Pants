//GameMap Class
public class GameMap {

	private int xPos;//x pos
	private int yPos;//y pos
	private static int leftWall,rightWall,ground;//leftWall right Wall and ground boundaries
	
	private final String gameMapPath;//map path
	
	//constructor
	public GameMap(){
		xPos=0;
		yPos=25;
		gameMapPath="Level.png";
		leftWall=10;
		rightWall=960;
		ground=570;
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

	public String getGameMapPath() {
		return gameMapPath;
	}

	public static int getLeftWall() {
		return leftWall;
	}

	public static int getRightWall() {
		return rightWall;
	}

	public static int getGround() {
		return ground;
	}
	
}
