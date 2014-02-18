import java.awt.Graphics;
import java.awt.Point;


@SuppressWarnings("serial")
public class AttachmentRod extends Entity{
	AttachmentPoint head;
	AttachmentPoint tail;
	
	public AttachmentRod(double inMass, AttachmentPoint inPositionHead, AttachmentPoint inPositionTail){
		super(inMass);//, inPositionHead);
		head = inPositionHead;
		tail = inPositionTail;
	}
	
	public void update(){
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawLine((int)head.position[0], (int)head.position[1], (int)tail.position[0], (int)tail.position[1]);
	}
}
