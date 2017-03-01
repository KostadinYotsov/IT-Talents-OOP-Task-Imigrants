package durjavi;

import java.util.ArrayList;

import imigranti.Imigrant;

public abstract class PoliceOficer {
	
	private String name;
	private City city;
	private Country country;
	private String type;
	
	
	public PoliceOficer(String name, String type) {
		this.name = name;
		this.type=type;
	}
	
	public void addCountry (Country c) {
		if (c!=null) {
			this.country=c;
		}
	}
	
	public void addCity (City c) {
		if (c!=null) {
			this.city=c;
		}
	}
	
	public abstract boolean check(Imigrant imigrant);
	
	@Override
	public String toString() {
		return this.name + " : " + this.type;
	}

	
	
}
