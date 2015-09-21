package ua.org.oa.tomakh.Home1;

import java.util.ArrayList;
import java.util.List;

public class Table extends Furniture{

	private int width;
	private int depth;
	List<Object> objects;
	
	Table(){
		objects = new ArrayList<Object>();
	}
	
	void AddObject(Object obj){
		objects.add(obj);
	}
	
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
		String out = "";
		for(Object obj:objects){
			out += obj + "\n";
		}
		return "Table [\n"
				+ "Description=" + getDescription() +"\n"
				+ "Material=" + getMaterial() + "\n"
				+ "Width=" + width + "cm\n"
				+ "Depth=" + depth + "cm\n"
				+ "X=" + getX() + " cm\n"
				+ "Y=" + getY() + " cm\n"
				+ "Table has \n"
				+ out
				+ "]\n";
	}
	
	
	
}
