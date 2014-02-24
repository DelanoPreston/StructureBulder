
public enum Material {
	WOOD, ALUMINUM, STEEL;
	
	public double strength;
	
	static{
		WOOD.strength = 100.0;
		ALUMINUM.strength = 250.0;
		STEEL.strength = 350.0;
	}
}
