package ua.org.oa.tomakh.Home1;

public class Furniture {
	private String description;
	private String material;
	private int x;
	private int y;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Furniture [ \n"
				+ "description=" + description + "\n"
				+ "material=" + material + "\n"
				+ "x=" + x + "\n"
				+ "y=" + y + "\n"
				+ "]";
	}
	
}
