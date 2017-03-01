package durjavi;

import java.util.Random;

import imigranti.Imigrant;

public class PoliceMan extends PoliceOficer {
	
	public PoliceMan(String name) {
		super(name, "Policeman");
	}

	@Override
	public boolean check(Imigrant imigrant) {
		if (imigrant.hasBomb()) {
		return false;
		}
		if (!imigrant.hasBomb() && !imigrant.hasPasport()) {
			return new Random().nextBoolean();
		}
		return false;
	}

}
