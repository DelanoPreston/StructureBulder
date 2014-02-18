import java.awt.Graphics;


public class AttachmentPoint extends Entity{
	public double[] position;
	
	
	public AttachmentPoint(double inMass, double[] inPosition) {
		super(inMass);
		position = inPosition;
	}
	
	@Override
	public void update(){
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawOval((int)position[0] - 5, (int)position[1] - 5, 10, 10);
	}
}
