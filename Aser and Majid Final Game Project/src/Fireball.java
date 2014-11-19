//Fireball/rotten apples class
import java.util.Random;


public class Fireball {

	private int x,y;//x and y position
	
	Random generator=new Random();//generator
	
	//constructor
	public Fireball(){
		x=generator.nextInt(600);
		y=-10;
	}
	
	//getters and setters
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}
	
	
}
