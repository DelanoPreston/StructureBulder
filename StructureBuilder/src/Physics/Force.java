package Physics;

public class Force {
	double direction = 0.0;
	double magnitude = 0.0;
	
	public Force(double inMass){
		magnitude = inMass * Const.ACCEL;
	}
	
	public double getMagnitude(){
		return magnitude;
	}
	
	public double getDirection(){
		if(direction >= 360)
			direction %= 360;
		return direction;
	}
	
	public void addForce(Force inForce){
		double thisX = magnitude * Math.cos(direction);
		double thisY = magnitude * Math.sin(direction);
		
		thisX += inForce.magnitude * Math.cos(inForce.direction);
		thisY += inForce.magnitude * Math.sin(inForce.direction);
		
		magnitude = Math.sqrt((Math.pow(thisX, 2) + Math.pow(thisY, 2)));
		direction = Math.toDegrees(Math.atan(thisY/thisX));
	}
}
