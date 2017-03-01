package durjavi;

import java.util.Random;

import imigranti.Imigrant;

public class Comandos extends PoliceOficer {

	public Comandos(String name) {
		super(name, "Comandos");

	}

	@Override
	public boolean check(Imigrant imigrant) {
		if (!imigrant.hasPasport()) {
			int chislo=new Random().nextInt(10);
			if (chislo<=8) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	
}
