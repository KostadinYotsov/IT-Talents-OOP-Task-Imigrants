package weapons;

public class Weapon {
	
	public enum Type {BOMB, PISTOL, MACHINE_GUN} 
	
	private Type type;
	private double price;
	
	public Weapon(Type type) {
		this.type = type;
		if (type==Type.BOMB) {
			this.price = 1000;
		}
		else {
			if (type==Type.MACHINE_GUN) {
				this.price=500;
			}
			else {
				this.price=150;
			}
		}	
	}

	public Type getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return this.type +" : " +this.price;
	}
	
	
}
