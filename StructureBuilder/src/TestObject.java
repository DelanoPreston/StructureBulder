import java.awt.Graphics;


@SuppressWarnings("serial")
public class TestObject extends Entity{
	
	
	public TestObject(double inMass, double[] inPosition){
		super(inMass, inPosition);
		
		
	}
	
	public void update(){
		
		if(position[1] > 350){
			veloc = -veloc;
			position[1] = 350;
		}
		if(veloc < 0)
			veloc += .01;
		else
			veloc -= .01;
		
		accel = .125;
		veloc += accel;
		position[1] += veloc;
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		g.drawRect((int)position[0] - 16,(int)position[1] - 16, 32, 32);
	}
}
