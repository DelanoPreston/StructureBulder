import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Entity extends JComponent{
	double accel = 0.0;
	double veloc = 0.0;
//	double[] positionHead  = null;
	
	double mass = 0.0;
	
	public Entity(double inMass){//, double[] inPosition){
		mass = inMass;
//		positionHead = inPosition;
	}
	
	public void update(){
		
	}
	
	public void paintComponent(Graphics g){
		
	}
}
