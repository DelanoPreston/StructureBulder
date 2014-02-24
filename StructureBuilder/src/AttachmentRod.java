import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import Physics.Force;


@SuppressWarnings("serial")
public class AttachmentRod extends Entity{
	AttachmentPoint head;
	AttachmentPoint tail;
	float stress = 0.0f;
	Material material;
	Force netForce; 
	
	public AttachmentRod(double inMass, AttachmentPoint inPositionHead, AttachmentPoint inPositionTail){
		super(inMass, inPositionHead.position, inPositionTail.position);
		head = inPositionHead;
		tail = inPositionTail;
		material = Material.WOOD;
	}
	
	public void update(){
		stress += .01f;
		if(stress > 1f)
			stress = -1f;
		
		netForce = new Force(mass);
	}
	
	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2D = (Graphics2D)g;
		
		
		if(stress >= 0)
			g.setColor(new Color(stress, 0.0f, 0.0f, 1.0f));
		else
			g.setColor(new Color(0.0f, 0.0f, -stress, 1.0f));
		
		g2D.setStroke(new BasicStroke(3));
		g2D.drawLine((int)head.position[0], (int)head.position[1], (int)tail.position[0], (int)tail.position[1]);
	}
	
	public void calcStress(){
		
	}
}
