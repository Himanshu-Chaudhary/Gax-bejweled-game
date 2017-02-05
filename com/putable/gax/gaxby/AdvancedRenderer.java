package com.putable.gax.gaxby;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.putable.gax.core.Engine;
import com.putable.gax.core.Gactor;
import com.putable.gax.core.Renderer;
// basically same as GactorRenderor with listeners to change the Jewls and to change them
public class AdvancedRenderer extends JPanel implements Renderer {
	public AdvancedRenderer(){
		this.addListen();
	}
	private BufferedImage image;
	int width, height;
	GactorEngine temp;
	String score ="" ;
	
	@Override
	public void render(Engine e) {
		temp =(GactorEngine) e;
		 width = e.getLevel().getPreferredSiteWidth();
		 height = e.getLevel().getPreferredSiteHeight();
		image = new BufferedImage(e.getWidth()*width,e.getHeight()*height,BufferedImage.TYPE_INT_RGB);
		
        
		Graphics2D g2D = (Graphics2D) image.getGraphics();
		super.paintComponent(g2D);
		   for (int i = 0; i < e.getWidth(); i++){
				for (int j = 0; j < e.getHeight(); j++){
				 Gactor temp = e.get(i, j);
				 if (temp != null) temp.render(g2D, i, j, width, height);
				}
			}
		   score = "Score : " + e.scorePoints(0);
		   repaint();
	}
	 public void paintComponent(Graphics g) {
		 	
	        Graphics2D g2d = (Graphics2D) g;
	        super.paintComponent(g); // Do the regular painting 'above' us
	        g2d.drawImage(image,0,0,this);
	        if (temp != null){
	        	g2d.drawString(score,temp.getWidth()*width/2 , temp.getHeight()*height+10);
	        }
	        
	     
	       
	    }
	 private void addListen ()
	 // code to change the Jewls 
	    {
	        this.addMouseListener (new MouseAdapter ()
	        {boolean isSelected = false;
	        int x,y,x2,y2;
	        
	        Color getColor(Engine e, int x, int y){	        
	        	Jewl temp = (Jewl) e.get(x, y);
	        	if (temp == null) return null;
	        	return temp.getColor();	        	
	        	
	        }
	        
	        boolean isNeighbour (int x, int x2,int y, int y2){
	        	if ((x==x2)&&(y==y2)) return false;
	        	return ((Math.abs(x2-x) <= 1) && (Math.abs(y2-y) <= 1));
	        	}
	        void is3Same (int x,int y,Engine e){
	        	// checks if three same jewls are aligned after cganging Jewls
	        	checkNeigbourSame(x, y, e, 1,0);
	        	 
	        	checkNeigbourSame(x, y, e, -1,0);
	        	checkNeigbourSame(x, y, e, 0,-1);
	        	checkNeigbourSame(x, y, e, 0,1);
	        }

			private void checkNeigbourSame(int x, int y, Engine e, int xDir, int yDir) {
				boolean exist = e.exists(x+xDir, y+yDir);
	        	if (exist && (getColor(e,x,y)==getColor(e,x+xDir,y+yDir))){
	        		exist = e.exists(x+xDir+xDir, y+yDir+yDir);
	        		if (exist && (getColor(e,x+xDir,y+yDir)==getColor(e,x+xDir+xDir,y+yDir+yDir))){
	        			temp.get(x, y).operate(0);
	        			temp.get(x+xDir, y+yDir).operate(0);
	        			temp.get(x+xDir+xDir, y+yDir+yDir).operate(0);
	        			temp.scorePoints(1);
	        			
	        		}
	        	}
			}
	            @Override public void mouseClicked (MouseEvent e){ 
	            	if (isSelected){
	            		 x2 =e.getX()/width; 
	            		 y2 = e.getY()/height;
	            		 if (temp.exists(x2, y2)){
	            		Jewl temp1 = (Jewl) temp.get(x, y) ;
	            		Jewl temp2 = (Jewl) temp.get(x2, y2)	;    
	            		if (isNeighbour(x,x2,y,y2)){
	            			// changes the jewls in the Gactor
	            			temp.clear(x2, y2);
	            			temp.clear(x, y);
	            			temp.set(x, y, temp2);
	            			temp.set(x2, y2,temp1);
	            			
	            			is3Same(x,y,temp);
	            			is3Same(x2,y2,temp);
	            		}
	            		isSelected = false;
	            	}}
	            	 x = e.getX()/width;
	            	 y = e.getY()/height;
	            	 if (temp.exists(x, y))isSelected = true;
	            	}
	            });
	            

}
}
