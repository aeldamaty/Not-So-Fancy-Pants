//map2 class
public class Map2 {

	//platforms and boundaries
	private int ground;
	private int leftWall;
	private int rightWall;
	private int leftPlatformRightX;
	private int rightPlatformLeftX;
	private int leftRightPlatformGround;
	private int middlePlatformLeftX;
	private int middlePlatformRightX;
	private int middlePlatformGround;
	private int playDoorLeftX;
	private int playDoorRightX;
	private int instructionsBackDoorLeftX;
	private int instructionsBackDoorRightX;
	private int creditsDoorLeftX;
	private int creditsDoorRightX;
	private int storyDoorLeftX;
	private int storyDoorRightX;
	//picture paths
	private final String map2Path;
	private final String map2InstructionsPath;
	private final String map2StoryPath;
	private final String map2CreditsPath;
	
	//constructor
	public Map2(){
		ground=515;
		leftWall=10;
		rightWall=960;
		leftPlatformRightX=145;
		rightPlatformLeftX=850;
		leftRightPlatformGround=365;
		middlePlatformLeftX=300;
		middlePlatformRightX=680;
		middlePlatformGround=305;
		playDoorLeftX=550;
		playDoorRightX=600;
		instructionsBackDoorLeftX=860;
		instructionsBackDoorRightX=910;
		creditsDoorLeftX=560;
		creditsDoorRightX=610;
		storyDoorLeftX=30;
		storyDoorRightX=80;
		
		map2Path="Screen2Main.png";
		map2InstructionsPath="instructions.png";
		map2StoryPath="story.png";
		map2CreditsPath="credits.png";
	}

	//getters and setters
	public int getGround() {
		return ground;
	}
	
	public int getLeftWall() {
		return leftWall;
	}
	
	public int getRightWall() {
		return rightWall;
	}

	public int getLeftPlatformRightX() {
		return leftPlatformRightX;
	}

	public int getRightPlatformLeftX() {
		return rightPlatformLeftX;
	}

	public int getLeftRightPlatformGround() {
		return leftRightPlatformGround;
	}

	public int getMiddlePlatformLeftX() {
		return middlePlatformLeftX;
	}

	public int getMiddlePlatformRightX() {
		return middlePlatformRightX;
	}

	public int getMiddlePlatformGround() {
		return middlePlatformGround;
	}

	public int getPlayDoorLeftX() {
		return playDoorLeftX;
	}

	public int getPlayDoorRightX() {
		return playDoorRightX;
	}

	public int getInstructionsBackDoorLeftX() {
		return instructionsBackDoorLeftX;
	}

	public int getInstructionsBackDoorRightX() {
		return instructionsBackDoorRightX;
	}

	public int getCreditsDoorLeftX() {
		return creditsDoorLeftX;
	}

	public int getCreditsDoorRightX() {
		return creditsDoorRightX;
	}

	public int getStoryDoorLeftX() {
		return storyDoorLeftX;
	}

	public int getStoryDoorRightX() {
		return storyDoorRightX;
	}

	public void setLeftWall(int leftWall) {
		this.leftWall = leftWall;
	}

	public String getMap2Path() {
		return map2Path;
	}

	public String getMap2InstructionsPath() {
		return map2InstructionsPath;
	}

	public String getMap2StoryPath() {
		return map2StoryPath;
	}

	public String getMap2CreditsPath() {
		return map2CreditsPath;
	}
	
}
