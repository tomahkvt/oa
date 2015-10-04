package org.oa.ajax_rest_demo.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "food")
public class Food {

    @XmlElement
    private long id;
    @XmlElement
    private String name;
    @XmlElement
    private double cost;
    @XmlElement
    private long idAnimal;
    
    public Food(){
    	
    }
    
    public Food(String name, double cost, long idAnimal) {
		super();
		
		this.name = name;
		this.cost = cost;
		this.idAnimal = idAnimal;
	}
    
	public Food(long id, String name, double cost, long idAnimal) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.idAnimal = idAnimal;
	}
	
	public Food(long id, String name, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public long getIdAnimal() {
		return idAnimal;
	}
	public void setIdAnimal(long idAnimal) {
		this.idAnimal = idAnimal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cost);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (idAnimal ^ (idAnimal >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Food other = (Food) obj;
		if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
			return false;
		if (id != other.id)
			return false;
		if (idAnimal != other.idAnimal)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    

 
}
