package ua.org.oa.tomakh.Home1;

public class Chair extends Furniture{
	public String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Chair [\n"
				+ "Description=" + getDescription() +"\n"
				+ "Model=" + model + "\n"
				+ "Material=" + getMaterial() + "\n"
				+ "X=" + getX() + " cm\n"
				+ "Y=" + getY() + " cm\n"
				+ "]\n";
	}
	
	
	
}
