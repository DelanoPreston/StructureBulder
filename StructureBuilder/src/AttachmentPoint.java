import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Physics.Force;


@SuppressWarnings("serial")
public class AttachmentPoint extends Entity{
	Force netForce; 
	
	public AttachmentPoint(double inMass, double[] inPosition) {
		super(inMass, inPosition);
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2D = (Graphics2D)g;
		g2D.setColor(new Color(0.0f, 0.0f, 1.0f, 1.0f));
		double[] forceEndPoint = {Math.cos(netForce.getDirection()), Math.sin(netForce.getDirection())};
		g2D.drawLine((int)position[0] - 5, (int)position[1] - 5, (int)forceEndPoint[0], (int)forceEndPoint[1]);
		
		g2D.setColor(new Color(0.0f, 0.0f, 0.0f, 1.0f));
		g2D.setStroke(new BasicStroke(1));
		g2D.drawOval((int)position[0] - 5, (int)position[1] - 5, 10, 10);
	}
}
