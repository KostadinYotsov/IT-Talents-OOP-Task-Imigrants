import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import durjavi.City;
import durjavi.Comandos;
import durjavi.Country;
import durjavi.PoliceMan;
import durjavi.PoliceOficer;
import imigranti.Ekstremist;
import imigranti.Imigrant;
import imigranti.NormalenImigrant;
import imigranti.RadikalenImigrant;
import weapons.Weapon;
import weapons.Weapon.Type;

public class Demo {

	public static void main(String[] args) {

		Country france=new Country("France");
		
		String [] namesOfCities= { "Nice", "Paris", "Lyon", "Nancy", "Strasbourg" };
		String [] nameOfPoliceOfficers= { "Zinedine Zidane", "Paul Pogba", "Martin Fourcade", "Giles Simon", "Fabien Bartez" };
 		for (int i=0; i<5; i++) {
			String nameOfCity=namesOfCities[i];
			City city=new City(nameOfCity, new Random().nextInt(2_000_000)+1_000_000);
			france.addCity(city);
			for (int j=0; j<5; j++) {
				String nameOfPoliceOficer=nameOfPoliceOfficers[j];
				PoliceOficer p;
				if (new Random().nextBoolean()) {
					p=new PoliceMan(nameOfPoliceOficer);
				}
				else{
					p=new Comandos(nameOfPoliceOficer);
				}
				city.addPolicers(p);
			}
		}
		france.printInfo();
		
		String [] namesOfImigrants = {"Bashar", "Sami", "Mohamed", "Rahim", "Ramzi", "Ronzi", "Murad", "Medhi" };
		String [] mestorajdane= {"Syria - Damascus", "Iraq - Baghdat", "Pakistan - Islamabad" };
		ArrayList<Imigrant> imigrants=new ArrayList<>();
		for (int i=0; i<100; i++ ) {
			String name=namesOfImigrants[new Random().nextInt(namesOfImigrants.length)];
			String m=mestorajdane[new Random().nextInt(mestorajdane.length)];
			int chislo=new Random().nextInt(100);
			if (chislo<25) {
				RadikalenImigrant r=new RadikalenImigrant(name, m, new Random().nextInt(20)+10, new Random().nextDouble()*10+10_000);
				imigrants.add(r);
			}
			else {
				if (chislo>=25 && chislo<60) {
					Ekstremist e= new Ekstremist(name, m, new Random().nextInt(20)+10, new Random().nextDouble()*10+10_000);
					imigrants.add(e);
				}
				else {
					NormalenImigrant n=new NormalenImigrant(name, m, new Random().nextInt(20)+10, new Random().nextDouble()*10+10_000);
					imigrants.add(n);
				}
			}
		}
		
		for (Imigrant i : imigrants) {
			i.addRelative(imigrants.get(new Random().nextInt(100)));
			i.addRelative(imigrants.get(new Random().nextInt(100)));
		}
		
		ArrayList<Weapon> wepons=new ArrayList<>();
		for (int i=0; i<200; i++) {
			Type type=Type.values()[new Random().nextInt(Type.values().length)];
			Weapon w=new Weapon(type);
			wepons.add(w);
		}
		
		for (Imigrant i : imigrants) {
			if (!(i instanceof NormalenImigrant)) {
				for (int j=0; j<5; j++) {
					if (wepons.size()-1<=0) {
						break;
					}
					i.buyWeapon(wepons.get(new Random().nextInt(wepons.size()-1)));
					wepons.remove(new Random().nextInt(wepons.size()-1));
				}
			}
		}
		for (Imigrant i : imigrants) {
			City city=france.getCity();
			i.imigrateTo(france, city);
			//i.killPeople();
			i.printInfo();
		}
	}
}
