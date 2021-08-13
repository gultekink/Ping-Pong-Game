
public class PaddleLeft {
	private int yPos=0;
	final int XPOS=30;
	public PaddleLeft(){
		setPos(120);
	}
	public void setPos(int pos){
		this.yPos=pos;
		if(yPos>230){
			setPos(230);
			
		}else if(yPos<0){
			setPos(0);
		}
	}
	public int getPos(){
		return yPos;
	}
}
