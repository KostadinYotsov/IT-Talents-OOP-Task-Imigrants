package imigranti;

import java.util.ArrayList;

import durjavi.City;
import durjavi.Country;
import durjavi.PoliceOficer;
import weapons.Weapon;
import weapons.Weapon.Type;

public abstract class Imigrant {
	
	protected class Pasport {
		private final String name;
		private final String mestorajdane;
		private int age;
		
		Pasport(String name, String mestorajdane, int age) {
			this.name = name;
			this.mestorajdane = mestorajdane;
			this.age = age;
		}

		public String getName() {
			return name;
		}
	}
	
	protected Pasport pasport;
	private double money;
	private ArrayList<Imigrant> relatives;
	protected ArrayList<Weapon> weapons;
	private Country country;
	private City city;
	private String type;
	private PoliceOficer policer;
	
	public Imigrant(String name, String mestorajdane, int age, String type ,double money ) {
		this.money = money;
		this.relatives = new ArrayList<>();
		this.weapons = new ArrayList<>();
		this.type=type;
	}
	
	public void addCoutty (Country c) {
		if (c!=null) {
			this.country=c;
		}
	}
	
	public void addCity (City c) {
		if (c!=null && this.country.containsCity(c)) {
			this.city=c;
		}
	}
	
	public void addRelative (Imigrant i) {
		if (i!=null && i!=this && !relatives.contains(i)) {
			relatives.add(i);
		}
	}

	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public abstract boolean hasPasport ();
	
	public abstract void buyWeapon (Weapon w);
	
	public boolean hasWeapons() {
		return (weapons.size()>0);
	}
	
	public City getCity() {
		return city;
	}

	public void imigrateTo (Country co, City ci) {
		if (co.containsCity(ci)) {
			PoliceOficer p=ci.zachisliPoliceOfficer();
			if (!p.check(this)) {
				this.city=ci;
				this.country=co;
			}
		}
		for (Imigrant i : relatives) {
			if (i.country!=null && i.city!=null) {
				break;
			}
			i.imigrateTo(co, ci);
		}
	}
	
	public void killPeople () {
		if (!this.hasWeapons()) {
			return;
		}
		if (this.hasPasport()) {
			System.out.println(this.type + " : " + this.pasport.name + " otkri strelba s vsichki svoi orujiq.");
		}
		else {
			System.out.println(this.type + " otkri strelba s vsichki svoi orujiq.");
		}
		int num=0;
		City c = this.city;
		for (Weapon w : this.weapons) {
			if (w.getType()==Type.MACHINE_GUN) {
				c.setNumOfCitizens(c.getNumOfCitizens()-50);
				num+=50;
			}
			else {
				c.setNumOfCitizens(c.getNumOfCitizens()-10);
				num+=10;
			}
		}
		System.out.println("Broq na jertvite e " + num);
	}
	
	public boolean hasBomb () {
		if (this.type!="Ekstremist") {
			return false;
		}
		for (Weapon w : weapons) {
			if (w.getType()==Type.BOMB) {
				return true;
			}
		}
		return false;
	}
	
	public void printInfo () {
		if (this.pasport==null) {
			System.out.println("Tozi imigrant e "+ this.type + " nqma pasport");
		}
		else {
		System.out.println(this.type +"-" +this.pasport.name + " : " +'\n' + "    *Mestorajdane : " + this.pasport.age + '\n'+  "    *Godini : " + this.pasport.age);
		}
		if (this.hasWeapons()) {
			System.out.println("    *Orujiq : ");
			for (Weapon w : this.weapons) {
				System.out.println("        -" + w);
			}
		}
	}

	
}
