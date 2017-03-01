package imigranti;

import weapons.Weapon;

public class NormalenImigrant extends Imigrant {

	
	public NormalenImigrant(String name, String mestorajdane, int age, double money) {
		super(name, mestorajdane, age,"Imigrant", money);
		this.pasport=new Pasport(name, mestorajdane, age);
	}

	@Override
	public boolean hasPasport() {
		return true;
	}

	@Override
	public void buyWeapon(Weapon w) {
		System.out.println("Sorry guy you can't buy a weapon.");
		return;
	}

}
