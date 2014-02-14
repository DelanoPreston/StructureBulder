import java.awt.Graphics;

import javax.swing.JComponent;


@SuppressWarnings("serial")
public class Entity extends JComponent{
	double accel = 0.0;
	double veloc = 0.0;
	double[] position = {0.0, 0.0};
	
	double mass = 0.0;
	
	public Entity(double inMass, double[] inPosition){
		mass = inMass;
		position = inPosition;
	}
	
	public void paintComponent(Graphics g){
		
	}
}
