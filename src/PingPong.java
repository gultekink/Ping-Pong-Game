import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.Timer;

public class PingPong extends Applet implements MouseMotionListener, ActionListener{
	 Ball ball;
	 PaddleLeft pLeft;
	 PaddleRight pRight;
	 
	 Font newFont = new Font("sansserif", Font.BOLD, 20);
	 

	 Graphics bufferGraphics;

	 Image offscreen;
	 
	 final int WIDTH = 500, HEIGHT = 300;

	 long currentTime;
	  

	 public void init() 
	 { 
	      setSize(500, 300);
	    
	      ball = new Ball();
	      pLeft = new PaddleLeft();
	      pRight = new PaddleRight(ball.getY() - 35);
	  
	      addMouseMotionListener(this);
	      
	      setBackground(Color.yellow);
	      offscreen = createImage(WIDTH,HEIGHT);
	      bufferGraphics = offscreen.getGraphics();
	 }
	  
	 public void start(){
	    
	     currentTime = System.currentTimeMillis();
	      
	    
	     Timer time = new Timer(15, this);    
	     
	    
	     time.start();
	    
	    
	     repaint();
	 }
	  
	 public void stop(){
	      
	 }

	  public void paint(Graphics g) 
	 {
	      bufferGraphics.clearRect(0,0,WIDTH,HEIGHT);
	      
	      
	      bufferGraphics.setColor(Color.blue);
	 
	      bufferGraphics.fillRect(pLeft.XPOS,pLeft.getPos(),10,70);
	      

	      bufferGraphics.fillRect(pRight.XPOS, pRight.getPos(), 10, 70);
	       
	    
	      bufferGraphics.setColor(Color.black);
	      bufferGraphics.setFont(newFont);
	      
	      bufferGraphics.drawString("Ping Pong", 130, 15);

	      bufferGraphics.drawString(""+ pRight.getScore(),300,15);
	     
	      bufferGraphics.fillRect(240,0,20,300);
	      
	      bufferGraphics.setColor(Color.green);
	      bufferGraphics.fillRect(ball.getX(),ball.getY(),10,10);
	      g.drawImage(offscreen,0,0,this);
	      Toolkit.getDefaultToolkit().sync();
	 }
	 public void update(Graphics g)
	 {
	      paint(g);
	 }

	 public void mouseMoved(MouseEvent evt){
	      pLeft.setPos(evt.getY()- 35);
	 }
	 public void mouseDragged(MouseEvent evt) 
	 {
		 
	 }

	 public void checkCollision(){

	    if(ball.getY() == 0 || ball.getY() == 290){
	        ball.dy = (ball.dy * -1);
	    }
	     
	    if((ball.getX() == 40) && hitPaddle()){
	        ball.dx = (ball.dx * -1);
	    }
	    if(ball.getX() == 460){
	        ball.dx = (ball.dx * -1);
	    }
	    if(ball.getX() == 0){
	        pRight.setScore(pRight.getScore() + 1);
	        ball.reset();
	    }
	 }
	 public boolean hitPaddle(){
	     boolean didHit = false;
	     if((pLeft.getPos() - 10) <= ball.getY() && (pLeft.getPos() + 70) > ball.getY()){

	       
	         didHit = true;

	     }
	     return didHit;
	 }




	   public void actionPerformed(ActionEvent arg0) {

	        ball.move();

	      

	        pRight.setPos(ball.getY() - 35);
	        
	        checkCollision();
	        
	       repaint();

	   }
}
