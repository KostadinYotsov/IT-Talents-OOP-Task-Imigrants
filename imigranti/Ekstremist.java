package imigranti;

import java.util.ArrayList;

import weapons.Weapon;
import weapons.Weapon.Type;

public class Ekstremist extends Imigrant {
		
	public Ekstremist(String name, String mestorajdane, int age, double money) {
		super(name, mestorajdane, age,"Ekstremist", money);
		this.pasport=null;
	}

	@Override
	public boolean hasPasport() {
		return false;
	}

	@Override
	public void buyWeapon(Weapon w) {
		if (w!=null && this.getMoney()>=w.getPrice()) {
			this.weapons.add(w);
			this.setMoney(this.getMoney()-w.getPrice());
		}	
	}
	
	public void blowUp () {
		if (this.hasBomb()) {
			System.out.println(this.getCity().getName() + " e zalichen ot liceto na zemqta.");
		}
	}
}
