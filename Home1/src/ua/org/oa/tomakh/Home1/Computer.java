package ua.org.oa.tomakh.Home1;

public class Computer {
	private String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Computer [ \n"
				+ "description=" + description + "\n"
				+ "]";
	}
	
}
