//Coconut Class
import java.util.Random;


public class Coconut {

	private int x,y;//x and y position of coconut
	
	Random generator=new Random();//generator 
	
	//constructor
	public Coconut(){
		x=generator.nextInt(960);
		y=0;
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
