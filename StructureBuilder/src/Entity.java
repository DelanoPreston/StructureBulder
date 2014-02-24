import java.awt.Graphics;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Entity extends JComponent{
	double accel = 0.0;
	double veloc = 0.0;
	double mass = 0.0;
	double[] position;
	
	public Entity(double inMass, double[] inPosition){
		mass = inMass;
		position = inPosition;
	}
	public Entity(double inMass, double[] inHeadEnd, double[] inTailEnd){
		mass = inMass;
		position[0] = Math.abs(inHeadEnd[0] - inTailEnd[0]);
		position[1] = Math.abs(inHeadEnd[1] - inTailEnd[1]);
	}
	
	public void update(){
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}
}
