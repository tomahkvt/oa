package ua.org.oa.tomakh.Home1;

import java.util.ArrayList;
import java.util.List;

public class MyRoom {
	List<Object> objects;
	int sizex;
	int sizey;
	MyRoom(){
		objects = new ArrayList<Object>();
	}
	
	void AddObject(Object obj){
		objects.add(obj);
	}
	
	public int getSizex() {
		return sizex;
	}

	public void setSizex(int sizex) {
		this.sizex = sizex;
	}

	public int getSizey() {
		return sizey;
	}

	public void setSizey(int sizey) {
		this.sizey = sizey;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String out = "Size of my Room width="+ getSizex() +"cm\n"
		+ "Size of my Room length="+ getSizey() +"cm\n"
		+ "In my Room is located\n";
		for(Object obj:objects){
			out += obj + "\n";
		}
		return out;
	}
	
	public static void main(String[] args) {
		Chair chaire = new Chair();
		MyRoom myRoom = new MyRoom();
		Table table = new Table();
		Wardrobe wardrobe = new Wardrobe();
		SwedishWall swedishWall = new SwedishWall(); 
		Computer computer = new Computer();
		computer.setDescription("Computer Desktop");
		
		swedishWall.setDescription("SwedishWall");
		swedishWall.setMaterial("metal");
		swedishWall.setX(300);
		swedishWall.setY(200);
		myRoom.setSizex(300);
		myRoom.setSizey(400);
		chaire.setModel("Modern");
		chaire.setDescription("computer chair");
		chaire.setMaterial("metal plastic");
		chaire.setX(200);
		chaire.setY(50);
		table.setDepth(60);
		table.setWidth(120);
		table.setX(120);
		table.setY(0);
		table.setDescription("Computer table");
		table.setMaterial("Particleboard");
		table.AddObject(computer);
		wardrobe.setDepth(60);
		wardrobe.setWidth(150);
		wardrobe.setX(0);
		wardrobe.setY(250);
		wardrobe.setDescription("Wardrobe");
		wardrobe.setMaterial("Particleboard");

		
		myRoom.AddObject(chaire);
		myRoom.AddObject(table);
		myRoom.AddObject(wardrobe);
		myRoom.AddObject(swedishWall);
		System.out.println(myRoom);

	}



}
