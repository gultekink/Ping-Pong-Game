
public class PaddleRight {
	private int yPos=0, score;
	final int XPOS=460;
	
	
	public PaddleRight(int ballPos){
		setPos(ballPos);
		setScore(0);
	}
	public void setPos(int pos){
		this.yPos=pos;
		if(yPos>230){
			setPos(230);
		}
		else if(yPos < 0){
			setPos(0);
		}
	}
	public int getPos(){
		return yPos;
	}
	public void setScore(int score){
		this.score=score;
	}
	public int getScore(){
		return this.score;
	}
}
