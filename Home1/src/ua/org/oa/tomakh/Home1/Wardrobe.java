package ua.org.oa.tomakh.Home1;

public class Wardrobe extends Furniture{

	private int width;
	private int depth;
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}	

	@Override
	public String toString() {
		return "Wardrobe [\n"
				+ "Description=" + getDescription() +"\n"
				+ "Material=" + getMaterial() + "\n"
				+ "Width=" + width + "cm\n"
				+ "Depth=" + depth + "cm\n"
				+ "X=" + getX() + " cm\n"
				+ "Y=" + getY() + " cm\n"
				+ "]\n";
	}
	
	
	
}
