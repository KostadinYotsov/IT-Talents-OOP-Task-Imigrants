package durjavi;

import java.util.ArrayList;
import java.util.Random;

public class City {
	
	private String name;
	private ArrayList<PoliceOficer> policers;
	private int numOfCitizens;
	
	public City(String name, int numOfCitizens) {
		this.name = name;
		this.numOfCitizens = numOfCitizens;
		this.policers=new ArrayList<>();
	}
	
	public void addPolicers (PoliceOficer p) {
		if (p!=null) {
			policers.add(p);
		}
	}

	public void setNumOfCitizens(int numOfCitizens) {
		this.numOfCitizens = numOfCitizens;
	}

	
	public int getNumOfCitizens() {
		return numOfCitizens;
	}
	
	

	public String getName() {
		return name;
	}

	public void printInfo() {
		System.out.println("    *" + this.name + " - " + this.numOfCitizens + " citizens." );
		System.out.println("        *Police Officers:");
		for (PoliceOficer p : policers) {
			System.out.println("        *" + p);
		}
		
	}

	public PoliceOficer zachisliPoliceOfficer() {
		PoliceOficer p=policers.get(new Random().nextInt(policers.size()-1));
		return p;
	}
}
