//Cheetah Class
public class Cheetah {

	private int x,y;//x and y position of cheetah 
	boolean moveRight;//boolean for if he is moving right
	private final String picturePathLeft,picturePathRight;//picture paths of cheetah pics
	
	//constructor
	public Cheetah(){
		x=0;
		y=500;
		moveRight=true;
		picturePathLeft="cheetahLeft.gif";
		picturePathRight="cheetahRight.gif";
	}

	//getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}

	public String getPicturePathLeft() {
		return picturePathLeft;
	}

	public String getPicturePathRight() {
		return picturePathRight;
	}
	
}
