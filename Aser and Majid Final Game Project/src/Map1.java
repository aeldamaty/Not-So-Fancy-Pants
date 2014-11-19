//Map 1 class
public class Map1 {

	//boundaries
	private int ground;
	private int leftWall;
	private int doorX;
	//picture path
	private final String map1Path;
	
	//constructor
	public Map1(){
		
		ground=570;
		leftWall=20;
		doorX=683;
		map1Path="Screen1.png";
	}

	//getters and setters
	public int getGround() {
		return ground;
	}

	public int getLeftWall() {
		return leftWall;
	}

	public int getDoorX() {
		return doorX;
	}

	public String getMap1Path() {
		return map1Path;
	}
	
}
