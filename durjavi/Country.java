package durjavi;

import java.util.ArrayList;
import java.util.Random;

public class Country {
	
	private String name;
	private ArrayList<City> cities;
	
	public Country(String name) {
		this.name = name;
		cities=new ArrayList<>();
	}
	
	public void addCity (City c) {
		if (c!=null) {
			cities.add(c);
		}
	}
	
	public boolean containsCity (City c) {
		return cities.contains(c);
	}
	
	
	
	public City getCity() {
		return cities.get(new Random().nextInt(cities.size()-1));
	}

	public void printInfo () {
		System.out.println(this.name);
		for (City c : cities) {
			c.printInfo();
		}
	}
}
