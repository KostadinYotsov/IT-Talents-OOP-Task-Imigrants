package imigranti;

import java.util.ArrayList;
import java.util.Random;

import durjavi.City;
import weapons.Weapon;
import weapons.Weapon.Type;

public class RadikalenImigrant extends Imigrant {

	public RadikalenImigrant(String name, String mestorajdane, int age, double money) {
		super(name, mestorajdane, age,"Radikal", money);
		if (new Random().nextInt(100)<=34) {
			this.pasport=new Pasport(name, mestorajdane, age);
		}
		else {
			this.pasport=null;
		}
	}
	
	@Override
	public boolean hasPasport() {
		return this.pasport!=null;
	}
	
	@Override
	public void buyWeapon(Weapon w) {
		if (w!=null && w.getType()!=Type.BOMB && this.getMoney()>=w.getPrice()) {
			this.weapons.add(w);
			this.setMoney(this.getMoney()-w.getPrice());
		}
	}
}
